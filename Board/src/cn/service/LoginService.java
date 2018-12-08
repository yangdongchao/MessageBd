package cn.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.management.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.Dao.LoginDb;
import cn.Dao.MessageDb;
import cn.control.LoginControl;
import cn.model.Message;
import cn.model.User;
import cn.tools.Help;
/**
 * 
 * @ClassName:  LoginService   
 * @Description:TODO(��¼����)   
 * @author: ydc
 * @date:   2018��12��4�� ����4:15:13   
 *     
 * @Copyright: 2018 ydc All rights reserved. 
 *
 */
public class LoginService extends HttpServlet {

	/**   
	 * @Fields serialVersionUID   
	 */   
	private static final long serialVersionUID = 1L;
	
	protected  void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		HttpSession session=req.getSession(); 
		User l = (User)session.getAttribute("login");
		String id = req.getParameter("id");
		String ps = req.getParameter("password");
		System.out.println(id);
		System.out.println(ps);
		String clientCheckcode = req.getParameter("validateCode");//���տͻ���������ύ��������֤��
        String serverCheckcode = (String) req.getSession().getAttribute("checkcode");//�ӷ������˵�session��ȡ����֤��
		if(l==null)
		{
			if(clientCheckcode.equals(serverCheckcode)) {
				System.out.println("��֤�ɹ�");
			l = LoginDb.LoginCheck(id, ps);
			}
			else {
				System.out.println("��֤ʧ��");
				req.setAttribute("errorValidCode", "��֤�����");
				req.getRequestDispatcher("/Login.jsp").forward(req, resp);
				return;
			}
		}
		if(ps.equals(l.getPassword())) //�ɹ�
		{
			MessageDb messageDb = new MessageDb();
			ArrayList<Message> list =messageDb.queryById(id);
			int times =0;
			if(list==null)
			{
				times=0;
			}
			else
			{
				times=list.size();
			}
		    System.out.println(times);
			String tm = String.valueOf(times);
			session.setAttribute("times", tm);
			req.setAttribute("times", tm);
			session.setAttribute("login", l);
			session.setAttribute("name", l.getName());
			System.out.println("111");
			req.getRequestDispatcher("/Message.jsp").forward(req, resp);
		}
		else
		{
			System.out.println("�������");
			req.setAttribute("errorPassword", "�˺Ż��������");
			System.out.println(req.getSession().getAttribute("errorPassword"));
			req.getRequestDispatcher("/Login.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
