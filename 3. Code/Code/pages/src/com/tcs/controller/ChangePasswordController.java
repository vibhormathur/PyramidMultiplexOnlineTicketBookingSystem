package com.tcs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.tcs.utility.*;

/**
 * Servlet implementation class ChangePasswordController
 */
public class ChangePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private ServletRequest request;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiii");
		String old_Password=request.getParameter("old_Password");
		String new_Password=request.getParameter("new_Password");
		String confirmed_Password=request.getParameter("confirm_Password");
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		String password=(String)session.getAttribute("password");
	
		
		
		
		CheckChangePassword ccp=new CheckChangePassword();
		try
		{ 
			Boolean status=ccp.passwordchanger(username,password);
			System.out.println(status);
			if(status==true)
			{ 
				if((password.equals(old_Password)) )
				{ 
					if (new_Password.equals(confirmed_Password))
					{
						ccp.updatepass(username,new_Password);
						request.setAttribute("msgchangepwd","Password changed successfully !");
						RequestDispatcher rd = request.getRequestDispatcher("/changepassword.jsp");
						System.out.println("right doing");
						rd.forward(request,response);
					}
					else{
						request.setAttribute("msgchangepwd","New Passwords doesn't match !");
						RequestDispatcher rd = request.getRequestDispatcher("/changepassword.jsp");
						
						
						rd.forward(request,response);
					}
					
				}
				else{
					request.setAttribute("msgchangepwd","Invalid password entry !");
					RequestDispatcher rd = request.getRequestDispatcher("/changepassword.jsp");
					
					
					rd.forward(request,response);
				}
			}
		
			
			
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		
			RequestDispatcher rd1 = request.getRequestDispatcher("/changepassword.jsp");
			System.out.println("wrong doing");
			rd1.forward(request, response);
		}
		
		
	}

}