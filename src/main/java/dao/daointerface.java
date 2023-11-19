package dao;

import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxExpr.Array;

public interface daointerface<T> {
	
	public int insert(T t);
	
	public int update(T t);
	
	public int delete(T t);
	
	public ArrayList<T> selectALL();
	
	public T selectById(T t);
	
	public ArrayList<T> selectByCondition(String condition);
}
