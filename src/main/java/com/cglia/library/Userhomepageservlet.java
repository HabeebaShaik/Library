package com.cglia.library;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Userhomepageservlet
 */
@WebServlet("/Userhomepageservlet")
public class Userhomepageservlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Books> list=LoginDao.getAllBooks();
		RequestDispatcher rd=request.getRequestDispatcher("customerhome.jsp");
		request.setAttribute("viewBooks", list);  
		
		rd.forward(request, response);
	}
}



