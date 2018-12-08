package cn.db;
import java.util.*;
import java.sql.*;
import java.io.*;
/**
 * 
 * @ClassName:  ConnectDb   
 * @Description:TODO(用于连接数据库，返回一个连接实体Connection)   
 * @author: ydc
 * @date:   2018年12月4日 上午11:09:43   
 *     
 * @Copyright: 2018 ydc All rights reserved. 
 *
 */
public class ConnectDb {
	public static Connection getConn() {
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("成功加载mysql");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("没有找到mysql驱动");
			e.printStackTrace();
		}
		String url ="jdbc:mysql://localhost:3306/messegaboard?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
		Connection conn=null;
		try 
		{
			conn = DriverManager.getConnection(url, "root", "ASDWydc123");
		}
		catch(SQLException e) {
			System.out.println("连接失败");
			e.printStackTrace();
		}
		return conn;
	}
}
