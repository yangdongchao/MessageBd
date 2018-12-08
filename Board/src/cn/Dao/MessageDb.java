package cn.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.db.CloseDb;
import cn.db.ConnectDb;
import cn.model.Message;

public class MessageDb {
	static Connection conn= null;
	static PreparedStatement pstmt=null;
	static ResultSet rs= null;
	
	public boolean addMessage(Message mg)
	{
		boolean bl = false;
		conn= ConnectDb.getConn();
		String sql = "insert into content(id,title,message) values(?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mg.getId());
			pstmt.setString(2, mg.getTitle());
			pstmt.setString(3, mg.getContent());
			int f = pstmt.executeUpdate();
			if(f>0)
			{
				bl =true;
			}
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
		   CloseDb.close(conn, pstmt);
		}
		return bl;
	}
	
	public ArrayList<Message> queryById(String id) {
		/**
		 * 根据id返回留言信息，应该是一个数组，一个人可以多次留言
		 */
		ArrayList<Message> ans= new ArrayList<Message>();
				
		conn = ConnectDb.getConn();
		String sql = "select * from content where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Message tmp=new Message();
				tmp.setContent(rs.getString("message"));
				tmp.setId(rs.getString("id"));
			    tmp.setTitle(rs.getString("title")); 
			    tmp.setDate(rs.getString("cdata"));
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
