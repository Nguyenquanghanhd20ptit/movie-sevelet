package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import connectionsql.connection_JDBC1;
import controller.user1;

public class user_dao1 implements daointerface<controller.user1> {
	
	public static user_dao1 getInstance() {
		return new user_dao1();
	}

	@Override
	public int insert(user1 t) {
		int kq=0;
		try {
			
			//b1 tao ket noi den sql
			Connection connection = connection_JDBC1.getConnection();
			
			//b2 tao ra doi tuong statememt
			Statement statement = connection.createStatement();
			
			//b3: thuc thi cau lenh sql
			String sql = "INSERT INTO user (username, password, hoten) "+
					" VALUES ('"+t.getUsername()+"' , '"+t.getPassword()+"' , '"+ t.getHoten()+"')";
			
		   kq = statement.executeUpdate(sql);
			//b4: tra ve kq
			System.out.println("ban da thuc thi: "+sql);
			System.out.println("co "+kq+" dong bi thay doi");
			
			//b5: ngat connection
			connection_JDBC1.closeconnection(connection);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return kq;
	}

	@Override
	public int update(user1 t) {
		int kq=0;
		try {
			
			//b1 tao ket noi den sql
			Connection connection = connection_JDBC1.getConnection();
			
			//b2 tao ra doi tuong statememt
			Statement statement = connection.createStatement();
			
			//b3: thuc thi cau lenh sql
			String sql = "update user "
					    +" set "
					    +"username = '"+t.getUsername()+"'"
					    +",password = "+t.getPassword()+""
					    +",hoten ='"+t.getHoten()+"'"
					    +"where password='"+t.getPassword()+"\'";
		   kq = statement.executeUpdate(sql);
			//b4: tra ve kq
			System.out.println("ban da thuc thi: "+sql);
			System.out.println("co "+kq+" dong bi thay doi");
			
			//b5: ngat connection
			connection_JDBC1.closeconnection(connection);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return kq;
	}

	@Override
	public int delete(user1 t) {
		int kq=0;
		try {
			//b1 tao ket noi den sql
			Connection connection = connection_JDBC1.getConnection();
			
			//b2 tao ra doi tuong statememt
			Statement statement = connection.createStatement();
			
			//b3: thuc thi cau lenh sql
			String sql = "delete from user "
					    +"where username='"+t.getUsername()+"'";
		   kq = statement.executeUpdate(sql);
			//b4: tra ve kq
			System.out.println("ban da thuc thi: "+sql);
			System.out.println("co "+kq+" dong bi thay doi");
			
			//b5: ngat connection
			connection_JDBC1.closeconnection(connection);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return kq;
	}

	@Override
	public ArrayList<user1> selectALL() {
		ArrayList<user1> kq = new ArrayList<user1>();
		try {
			//b1 tao ket noi den sql
			Connection connection = connection_JDBC1.getConnection();
			
			//b2 tao ra doi tuong statememt
			Statement statement = connection.createStatement();
			
			//b3: thuc thi cau lenh sql
			String sql = "select *from user";
		    ResultSet resultSet = statement.executeQuery(sql);//lay du lieu 
		    while(resultSet.next()) {
		    	String username = resultSet.getString("username");
		    	String password = resultSet.getString("password");
		    	String  hoten = resultSet.getString("hoten");
		    	
		    	user1 user = new user1(username, password, hoten);
		    	kq.add(user);
		    }
		    
			//b5: ngat connection
			connection_JDBC1.closeconnection(connection);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public user1 selectById(user1 t) {
		user1 kq=null;
		try {
			//b1 tao ket noi den sql
			Connection connection = connection_JDBC1.getConnection();
			
			//b2 tao ra doi tuong statememt
			String sql = "select *from user where username=? and password=?";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			
			//b3: thuc thi cau lenh sql
			pStatement.setString(1, t.getUsername());
			pStatement.setString(2, t.getPassword());
		    ResultSet resultSet = pStatement.executeQuery();//lay du lieu 
		    while(resultSet.next()) {
		    	String username = resultSet.getString("username");
		    	String password = resultSet.getString("password");
		    	String  hoten = resultSet.getString("hoten");
		    	
		    	
		    	kq = new user1(username, password, hoten);
		    }
		    
			//b5: ngat connection
			connection_JDBC1.closeconnection(connection);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kq;
	}


	@Override
	public ArrayList<user1> selectByCondition(String condition) {
		return null;
		
	}

}
