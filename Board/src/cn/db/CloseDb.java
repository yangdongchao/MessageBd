package cn.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @ClassName:  CloseDb   
 * @Description:TODO(用于关闭数据库连接，主要包括两个方法)   
 * @author: ydc
 * @date:   2018年12月4日 上午11:12:02   
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
