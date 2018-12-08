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
 * @Description:TODO(Ϊע��ҳ���ṩ����)   
 * @author: ydc
 * @date:   2018��12��5�� ����10:20:17   
 *     
 * @Copyright: 2018 ydc All rights reserved. 
 *
 */
public class RegisterService extends HttpServlet {

	/**   
	 * @Fields serialVersionUID : TODO(��һ�仰�������������ʾʲô)   
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
			//ע��ʧ�ܣ�����ע��
			req.setAttribute("phone", "��Ǹ���õ绰�����Ѿ���ע��");
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
