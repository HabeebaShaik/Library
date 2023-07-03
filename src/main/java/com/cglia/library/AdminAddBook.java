package com.cglia.library;
import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class AdminAddBook
 */
@SuppressWarnings("serial")
@WebServlet("/AdminAddBook")
public class AdminAddBook extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RequestDispatcher rd=request.getRequestDispatcher("Books.jsp");  
	        rd.include(request,response);
	}

}
