package connectionsql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class connection_JDBC1 {
	public static Connection getConnection() {
		Connection c=null;
		try {
			//dang ki driver voi drivermanager
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			//cac thong so
			String url = "jdbc:mySQL://localhost:3307/jdbc";
			String username = "root";
			String password = "hanh121120";
			//tao ket noi
			c = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	public static void closeconnection(Connection c) {
		try {
			if(c!=null) {
				c.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void printInfor(Connection c) {
		try {
			if(c!=null) {
				DatabaseMetaData mtdt = c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}