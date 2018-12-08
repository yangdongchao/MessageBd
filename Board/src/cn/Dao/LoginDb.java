package cn.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.jws.soap.SOAPBinding.Use;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import cn.db.CloseDb;
import cn.db.ConnectDb;
import cn.model.*;
/**
 * 
 * @ClassName:  LoginDb   
 * @Description:TODO(将新用户质料加入数据库)   
 * @author: ydc
 * @date:   2018年12月4日 上午11:37:53   
 *     
 * @Copyright: 2018 ydc All rights reserved. 
 *
 */
public class LoginDb {
	public static Connection conn = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null;
	public static  boolean addUser(User user) {
		boolean tm = false;
		conn = ConnectDb.getConn();
		String sql = "insert into user(id,name,sex,password) values(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getSex());
			pstmt.setString(4, user.getPassword());
			int f = pstmt.executeUpdate();
			if(f>0)
			{
				tm = true;
			}
		}
		catch (SQLException e) {
			// TODO: handle exception
		    e.printStackTrace();
		}
		finally {
			CloseDb.close(conn, pstmt);
		}
		return tm;
	}
	 
	public  boolean updateUser(User user)  {
		boolean bm = false;
		conn = ConnectDb.getConn();
		String sql = "update user set name=? ,sex=?, password=? where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getSex());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getId());
			int f  = pstmt.executeUpdate();
			if(f>0)
			{
				bm = true;
			}
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			CloseDb.close(conn, pstmt);
		}
		return bm;
	}
	
	public static  User queryById(String id)
	{
		User ans = new User();
		conn = ConnectDb.getConn();
		String sql ="select * from user where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				System.out.println(id);
				ans.setId(id);
				System.out.println(rs.getString("name"));
			    ans.setName(rs.getString("name"));
				ans.setPassword(rs.getString("password"));
				ans.setSex(rs.getString("sex"));
			}
		}
		catch (SQLException e) {
		    e.printStackTrace();
		}
		finally {
			CloseDb.allClose(conn, pstmt, rs);
		}
		return ans;
	}
	public static  User LoginCheck(String id,String ps)
	{
		User ans = new User();
		conn = ConnectDb.getConn();
		String sql ="select * from user where id=? and password=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, ps);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				ans.setId(id);
			    ans.setName(rs.getString("name"));
				ans.setPassword(rs.getString("password"));
				ans.setSex(rs.getString("sex"));
			}
		}
		catch (SQLException e) {
		    e.printStackTrace();
		}
		finally {
			CloseDb.allClose(conn, pstmt, rs);
		}
		return ans;
	}
	public  ArrayList<User> queryAll()
	{
		ArrayList<User> ans = new ArrayList<User>();
		conn = ConnectDb.getConn();
		String sql ="select * from user";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				User tmp =new User() ;
				tmp.setId(rs.getString("id"));
				tmp.setName(rs.getString("name"));
				tmp.setPassword(rs.getString("password"));
				tmp.setSex(rs.getString("sex"));
				ans.add(tmp);
			}
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			CloseDb.allClose(conn, pstmt, rs);
		}
		return ans;
	}
}
