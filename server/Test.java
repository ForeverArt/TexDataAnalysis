import java.util.ArrayList;

import com.google.gson.Gson;
import java.sql.Date;
import entity.Receipt;
import entity.Content;

public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gson gson=new Gson();
		ArrayList<Receipt> receipts = new ArrayList<Receipt>();
		for (int i=0;i<=2;i++){
			String name = "name"+i;
			double value = 2.2+i;
			@SuppressWarnings("deprecation")
			Date date = new Date(2016,1,1);
			Receipt receipt = new Receipt(name,value,date);
			receipts.add(receipt);
		}
		@SuppressWarnings("unchecked")
		ArrayList<Receipt> input = (ArrayList<Receipt>) receipts.clone();
		@SuppressWarnings("unchecked")
		ArrayList<Receipt> output = (ArrayList<Receipt>) receipts.clone();
//		ArrayList<ArrayList<Receipt>> content = new ArrayList<ArrayList<Receipt>>();
//		content.add(input);
//		content.add(output);
//		ArrayList<ArrayList<ArrayList<Receipt>>> data = new ArrayList<ArrayList<ArrayList<Receipt>>>();
//		data.add(content);
		Content content = new Content(input,output);
		String json = gson.toJson(content);
		System.out.println(json);
	}

}
