package com.tcs.controller;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tcs.utility.*;
import com.tcs.bean.*;

public class AddMovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddMovieController() {
        super();
    }
        // TODO Auto-generated constructor stub

	//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String movie_Name=request.getParameter("name");
		String movie_Director = request.getParameter("director");
		String movie_Language = request.getParameter("language");
		//String movie_ClosingDate = request.getParameter("closingdate");
		int movie_theater_id = Integer.parseInt(request.getParameter("theater_id"));
		int res = 0;
        Movie m = new Movie();
        m.setMovie_Name(movie_Name);
        m.setDirector(movie_Director);
        m.setLanguage(movie_Language);
      //  m.setClosing_Date(movie_ClosingDate);
        m.setTheater_ID(movie_theater_id);
        m.setResponse(res);
        InsertMovieTable imt = new InsertMovieTable();
		try
		{
			imt.insertMovie(m);
			System.out.println("Hello");
			/*RequestDispatcher rd = request.getRequestDispatcher("/addTheater.jsp");
			rd.forward(request,response);	*/
			response.sendRedirect("mysettings.jsp");
		}
		catch(Exception e)
		{
			System.out.println("error:"+e.getMessage());
		
			/*RequestDispatcher rd1 = request.getRequestDispatcher("/addTheater.jsp");
			rd1.forward(request, response);*/
		}
	}
}