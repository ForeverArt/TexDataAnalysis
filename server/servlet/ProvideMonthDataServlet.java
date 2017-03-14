package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.ReceiptDao;
import entity.Receipt;

/**
 * Servlet implementation class ProvideMonthDataServlet
 */
@WebServlet("/ProvideMonthDataServlet")
public class ProvideMonthDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReceiptDao receiptDao = new ReceiptDao();

    /**
     * Default constructor. 
     */
    public ProvideMonthDataServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Gson gson=new Gson();
		response.setContentType("text/xml;charset=UTF-8");
        PrintWriter out = response.getWriter();
		
        String info = request.getParameter("month").toString();
        String yearStr = info.substring(0, 4);
        String monthStr = info.substring(4, 6);
        int year = Integer.parseInt(yearStr);
        int month = Integer.parseInt(monthStr);
        try {
        	ArrayList<Receipt> receipts = receiptDao.searchByMonth(year, month);
        	String json = gson.toJson(receipts);
        	System.out.println(json);
            out.write(json);
            out.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
