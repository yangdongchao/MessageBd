package cn.db;
import java.util.*;
import java.sql.*;
import java.io.*;
/**
 * 
 * @ClassName:  ConnectDb   
 * @Description:TODO(�����������ݿ⣬����һ������ʵ��Connection)   
 * @author: ydc
 * @date:   2018��12��4�� ����11:09:43   
 *     
 * @Copyright: 2018 ydc All rights reserved. 
 *
 */
public class ConnectDb {
	public static Connection getConn() {
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("�ɹ�����mysql");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("û���ҵ�mysql����");
			e.printStackTrace();
		}
		String url ="jdbc:mysql://localhost:3306/messegaboard?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
		Connection conn=null;
		try 
		{
			conn = DriverManager.getConnection(url, "root", "ASDWydc123");
		}
		catch(SQLException e) {
			System.out.println("����ʧ��");
			e.printStackTrace();
		}
		return conn;
	}
}
