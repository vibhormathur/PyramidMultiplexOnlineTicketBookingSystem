package com.tcs.controller;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tcs.utility.ModelCustomer;
import com.tcs.bean.Customer;
/**
 * Servlet implementation class RegisterSubmit
 */
public class RegisterSubmitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterSubmitController() {
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
		
		
		String name=request.getParameter("name");
		Integer age=Integer.parseInt(request.getParameter("age"));
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		String phone=request.getParameter("txtPhone");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		Customer cust=new Customer();
		cust.setName(name);
		cust.setAge(age);
		cust.setUsername(username);
		cust.setPassword(password);
		cust.setGender(gender);
		cust.setAddress(address);
		cust.setPhoneNo(phone);
		
		ModelCustomer insert=new ModelCustomer();
		Boolean status=insert.checkAvailability(username);
		if(status==true)
		{
			request.setAttribute("msg", "Username not available!!!");
			RequestDispatcher rd1 = request.getRequestDispatcher("/Register.jsp");
			rd1.forward(request, response);
		}
		else
		{
			try
			{
				insert.insertCustomer(cust);
				RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
				
					rd.forward(request,response);
					
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				RequestDispatcher rd1 = request.getRequestDispatcher("/Register.jsp");
				rd1.forward(request, response);
			}
		}
		
			
		

	}

}
