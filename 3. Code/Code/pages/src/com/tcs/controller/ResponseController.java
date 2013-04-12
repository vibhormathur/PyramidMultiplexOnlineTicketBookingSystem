package com.tcs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import com.tcs.utility.*;
/**
 * Servlet implementation class ResponseController
 */
public class ResponseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseController() {
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
		DbConnection dbconObj=new DbConnection();
		Connection con=null;
		Statement stmt=null;
		int theaterid=Integer.parseInt(request.getParameter("tid"));
		int rate=Integer.parseInt(request.getParameter("rate"));
		try{
			
			con=dbconObj.getDbConnection();
			stmt=con.createStatement();
			stmt.executeUpdate("Update g4_theater set rating="+rate+" where theater_id="+theaterid);
			
			request.setAttribute("yes", "yes");
			RequestDispatcher rd1 = request.getRequestDispatcher("/theaterresponse.jsp");
			rd1.forward(request, response);
		}
		catch(Exception e)
		{
			System.out.println("error1:"+ e.getMessage());
		} 
	}

}
