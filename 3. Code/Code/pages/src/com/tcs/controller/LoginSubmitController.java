package com.tcs.controller;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.tcs.utility.*;


/**
 * Servlet implementation class LoginSubmitController
 */
public class LoginSubmitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSubmitController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		LoginCheck lm=new LoginCheck();
		ArrayList<Object> arr=new ArrayList<Object>();
		arr=lm.isValidUser(username,password);
		Boolean status=(Boolean)arr.get(0);
		String type=(String)arr.get(1);
		System.out.println(status+"");
		System.out.println(type);
		if(status==true )
		{
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			session.setAttribute("type", type);
			/*RequestDispatcher dispatcher = 
				  getServletContext().getRequestDispatcher("/home.jsp");
				dispatcher.forward(request, response);*/
			response.sendRedirect("home.jsp");
		}
		else
		{
			request.setAttribute("message", "Invalid Login Id/Password");
			RequestDispatcher dispatcher = 
				  getServletContext().getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
			//response.sendRedirect("login.jsp");
		}
			
	}

}