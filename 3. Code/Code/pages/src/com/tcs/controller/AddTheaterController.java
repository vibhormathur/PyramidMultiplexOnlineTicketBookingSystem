package com.tcs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tcs.utility.*;
import com.tcs.bean.*;

/**
 * Servlet implementation class AddTheaterController
 */
public class AddTheaterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTheaterController() {
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
		String theater_Name=request.getParameter("theater_Name");
	
		Integer seat_Capacity=Integer.parseInt(request.getParameter("seat_Capacity"));
		Double price=250.0;
		int rating=0;
		
		Theater th=new Theater();
		th.setTheater_Name(theater_Name);
		
		th.setSeat_Capacity(seat_Capacity);
		th.setPrice(price);
		th.setRating(rating);
		
		
		try
		{
			InsertTheaterTable.insertTheaterTable(th);
			
			RequestDispatcher rd = request.getRequestDispatcher("/addTheater.jsp");
			
			
				rd.forward(request,response);
			
		}
		catch(Exception e)
		{
			System.out.println("error:"+e.getMessage());
		
			RequestDispatcher rd1 = request.getRequestDispatcher("/addTheater.jsp");
			rd1.forward(request, response);
		}
		
		

	}
	

}
