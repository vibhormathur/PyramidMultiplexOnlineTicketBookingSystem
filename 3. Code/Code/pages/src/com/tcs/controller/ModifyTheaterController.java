package com.tcs.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.utility.DbConnection;

/**
 * Servlet implementation class ModifyTheaterController
 */
public class ModifyTheaterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyTheaterController() {
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
		DbConnection dbconObj=new DbConnection();
		Connection con=null;
		Statement stmt=null;
		int seatcapacity=Integer.parseInt(request.getParameter("newseatcount"));
		int tid=Integer.parseInt(request.getParameter("tid"));
		System.out.println(tid);
		try{
			
			con=dbconObj.getDbConnection();
			stmt=con.createStatement();
			stmt.executeUpdate("Update g4_theater set seat_capacity="+seatcapacity+" where theater_id="+tid);
			
			request.setAttribute("yes", "yes");
			RequestDispatcher rd1 = request.getRequestDispatcher("/modifytheater.jsp");
			rd1.forward(request, response);
		}
		catch(Exception e)
		{
			System.out.println("error1:"+ e.getMessage());
		} 
	}

}
