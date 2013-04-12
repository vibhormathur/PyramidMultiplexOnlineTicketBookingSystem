package com.tcs.controller;

import java.io.IOException;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.bean.Select_movie_bean;
import com.tcs.utility.*;

/**
 * Servlet implementation class Select_movie
 */
public class Select_movie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Select_movie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String abc=request.getParameter("testinput");
		//String date=null;
		
	    Select_movie_bean smb = new Select_movie_bean();
	    smb.setDate(abc);
	    
	    Select_Movie_action sma = new Select_Movie_action();
	    try
	    {
	   ArrayList data = null; 
		   data = (ArrayList)sma.check(smb);
	    request.setAttribute("arr", data);
	    System.out.println("check1");
	    request.setAttribute("success", "success");
	    RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
	    rd.forward(request,response);
	    }catch(Exception e)
	    {}
	    
	}

}
