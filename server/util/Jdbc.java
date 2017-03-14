package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {
	public static Connection connect()throws SQLException, ClassNotFoundException{
	    String driver= "dm.jdbc.driver.DmDriver";
		String url= "jdbc:dm://localhost:12345/dbname";
		String username="username";
		String password="password";
		Connection con = null;
		try {
			// 加载JDBC驱动程序
			Class.forName(driver);
		} catch (java.lang.ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			// 数据库连接
			con = DriverManager.getConnection(url, username, password);
			return con;
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
		return null;
	}
	
	public static void close(Statement stat, Connection conn) throws SQLException{
		if(stat != null){
			stat.close();
		}
		if(conn != null){
			conn.close();
		}
	}
}
