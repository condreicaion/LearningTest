package testcases;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestDBConn {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		List<String> values1 = new ArrayList<String>();
		DbManager.setMysqlDbConnection();
//		System.out.println(DbManager.getMysqlQuery("select tutorial_author from selenium where tutorial_id = 2"));
//		System.out.println(DbManager.getMysqlQuery("select * from selenium"));
		values1=DbManager.getMysqlQuery("select * from selenium");
		
		System.out.println(values1);

//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/24thaug2019", "root", "David2269");
//		// here sonoo is database name, root is username and password
//		try {
////			Class.forName("com.mysql.jdbc.Driver");  
//
//			Statement stmt = con.createStatement();
//			// ResultSet rs = stmt.executeQuery("select tutorial_author from selenium where
//			// tutorial_id = 2");
//			ResultSet rs = stmt.executeQuery("select * from selenium");
//			while (rs.next())
//				System.out
//						.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + " " + rs.getDate(4));
//			// System.out.println(rs.getString(1));
//		} catch (Exception e) {
//			System.out.println(e);
//		} finally {
//			con.close();
//		}
	}
}
