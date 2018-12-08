package cn.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @ClassName:  CloseDb   
 * @Description:TODO(���ڹر����ݿ����ӣ���Ҫ������������)   
 * @author: ydc
 * @date:   2018��12��4�� ����11:12:02   
 *     
 * @Copyright: 2018 ydc All rights reserved. 
 *
 */
public class CloseDb {
	public static void allClose(Connection conn,PreparedStatement pstmt,ResultSet rs) {
		try {
			if(rs!=null)
			{
				rs.close();
			}
		}
		catch (SQLException e) {
		    e.printStackTrace();
		}
		try
		{
			if(pstmt!=null)
			{
				pstmt.close();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn!=null)
			{
				conn.close();
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public static void close(Connection conn,PreparedStatement pstmt) {
		try
		{
			if(pstmt!=null)
			{
				pstmt.close();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn!=null)
			{
				conn.close();
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
