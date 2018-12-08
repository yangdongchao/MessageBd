package cn.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.Dao.MessageDb;
import cn.model.Message;
import cn.model.User;

/**
 * Servlet implementation class MessageService
 */
/**
 * 
 * @ClassName:  MessageService   
 * @Description:TODO(实现留言内容的插入，更新界面)   
 * @author: ydc
 * @date:   2018年12月7日 上午9:52:51   
 *     
 * @Copyright: 2018 ydc All rights reserved. 
 *
 */
@WebServlet("/MessageService")
public class MessageService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		User user = (User)request.getSession().getAttribute("login");
		//Message message = (Message)session.getAttribute("message");
		Message message = new Message(content,user.getId(),title);
		MessageDb messageDb = new MessageDb();
		boolean bl = messageDb.addMessage(message);
		if(bl==true)
		{
			//MessageDb messageDb = new MessageDb();
			ArrayList<Message> list =messageDb.queryById(user.getId());
			int times =0;
			if(list==null)
			{
				times=0;
			}
			else
			{
				times=list.size();
			}
		
			String tm = String.valueOf(times);
			session.setAttribute("times", tm);
			request.setAttribute("MessageSuc", "留言成功");
			request.getRequestDispatcher("/Message.jsp").forward(request, response);
			//response.sendRedirect(request.getContextPath()+"/Message.jsp");
		}
		else
		{
			request.setAttribute("MessageFail", "留言失败，请重试");
			request.getRequestDispatcher("/Message.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
