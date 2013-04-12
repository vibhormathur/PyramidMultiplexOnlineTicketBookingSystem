package com.tcs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tcs.utility.*;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class BookTicketController
 */
public class BookTicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookTicketController() {
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
		String movie=request.getParameter("movie");
		Integer price=250;
		String date=request.getParameter("testinput");
		String slot=request.getParameter("group1");
		Integer no=Integer.parseInt(request.getParameter("person"));
		InsertMovieTable mm=new InsertMovieTable();
		boolean status=mm.checkMovie(movie);
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		if(status==true)
		{
			ModelTicket mt=new ModelTicket();
			int ticket=mt.insertTicket(price,username,date,slot,no,movie);
			if(ticket!=0)
			{
			request.setAttribute("msgmovie", "yes");
			request.setAttribute("ticket", ""+ticket);
			RequestDispatcher dispatcher = 
				  getServletContext().getRequestDispatcher("/bookticket.jsp");
				dispatcher.forward(request, response);
			}
			else
			{
				request.setAttribute("msgmovie", "The movie doesn't exist");
				RequestDispatcher dispatcher = 
					  getServletContext().getRequestDispatcher("/bookticket.jsp");
					dispatcher.forward(request, response);
			}
		}
		else
		{
			request.setAttribute("msgmovie", "The movie doesn't exist");
			RequestDispatcher dispatcher = 
				  getServletContext().getRequestDispatcher("/bookticket.jsp");
				dispatcher.forward(request, response);
		}
		}
	}


