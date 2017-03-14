package dao;

import java.sql.*;
import java.util.ArrayList;
import util.Jdbc;

import entity.Receipt;

public class ReceiptDao {
	private String tablename;
	public ReceiptDao(){
		this.tablename = "T_RECEIPT";
	}
	public boolean insert(Receipt instance)throws ClassNotFoundException, SQLException{
		Connection con = Jdbc.connect();
		Statement sta = null;
		int rs;
		sta = (Statement) con.createStatement();
		rs = sta.executeUpdate("INSERT INTO "+tablename+" (name,value,time) VALUES ('"+ instance.getName() +"',"+ instance.getValue() +",'"+ instance.getDate() +"')");
		Jdbc.close(sta, con);
		return rs == 1;
	}
	public ArrayList<Receipt> searchByMonth(int year, int month) throws ClassNotFoundException, SQLException{
		Connection con = Jdbc.connect();
		Statement sta = null;
		ResultSet rs = null;
		sta = (Statement) con.createStatement();
		ArrayList<Receipt> receipts = new ArrayList<Receipt>();
		rs = (ResultSet) sta.executeQuery("SELETC * FROM "+tablename+" WHERE TO_CHAR(time,'YYYY-MM') = TO_CHAR('"+year+"-"+month+"','YYYY-MM')");
		while(rs.next()){
			Receipt u = new Receipt();
			u.setName(rs.getString("name"));
			u.setValue(rs.getDouble("value"));
			u.setDate(rs.getDate("time"));
			receipts.add(u);
		}
		if(rs != null){
			rs.close();
		}
		Jdbc.close(sta, con);
		return receipts;
	}
	public ArrayList<Receipt> searchByYear(int year) throws ClassNotFoundException, SQLException{
		Connection con = Jdbc.connect();
		Statement sta = null;
		ResultSet rs = null;
		sta = (Statement) con.createStatement();
		ArrayList<Receipt> receipts = new ArrayList<Receipt>();
		rs = (ResultSet) sta.executeQuery("SELETC * FROM "+tablename+" WHERE TO_CHAR(time,'YYYY') = TO_CHAR('"+ year +"','YYYY')");
		while(rs.next()){
			Receipt u = new Receipt();
			u.setName(rs.getString("idNumber"));
			u.setValue(rs.getDouble("value"));
			u.setDate(rs.getDate("time"));
			receipts.add(u);
		}
		if(rs != null){
			rs.close();
		}
		Jdbc.close(sta, con);
		return receipts;
	}
}
