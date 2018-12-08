package cn.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.Dao.LoginDb;
import cn.model.User;

/**
 * 
 * @ClassName:  RegisterService   
 * @Description:TODO(为注册页面提供服务)   
 * @author: ydc
 * @date:   2018年12月5日 上午10:20:17   
 *     
 * @Copyright: 2018 ydc All rights reserved. 
 *
 */
public class RegisterService extends HttpServlet {

	/**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		System.out.println("hh");
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String sex = req.getParameter("sex");
		String password = req.getParameter("password");
		System.out.println(id);
		System.out.println(name);
		User tmp =LoginDb.queryById(id);
		System.out.println(tmp);
		if(id.equals(tmp.getId()))
		{
			//注册失败，重新注册
			req.setAttribute("phone", "抱歉，该电话号码已经被注册");
			req.getRequestDispatcher("/Register.jsp").forward(req, resp);
		}
		else
		{
			LoginDb.addUser(new User(id,name,sex,password));
			resp.sendRedirect(req.getContextPath()+"/Login.jsp");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}
