package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import connectionsql.connection_JDBC1;
import model.Category;

public class category_dao implements daointerface<Category>{
	public static category_dao getInstance() {
		return new category_dao();
	}
	

	@Override
	public ArrayList<Category> selectALL() {
		ArrayList<Category> kq = new ArrayList<Category>();
		try {
			//b1 tao ket noi den sql
			Connection connection = connection_JDBC1.getConnection();
			
			//b2 tao ra doi tuong statememt
			Statement statement = connection.createStatement();
			
			//b3: thuc thi cau lenh sql
			String sql = "select *from category";
		    ResultSet resultSet = statement.executeQuery(sql);//lay du lieu 
		    while(resultSet.next()) {
		    	int id = resultSet.getInt("id");
		    	String name = resultSet.getString("name");
		    	String type = resultSet.getString("type");
		    	double  price = resultSet.getDouble("price");
		    	String image = resultSet.getString("image");
		    	Category category = new Category(id,name,type,price , image);
		    	kq.add(category);
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
	public int insert(Category t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Category t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Category t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Category selectById(Category t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Category> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}



}
