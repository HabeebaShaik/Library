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
 * Servlet implementation class Bookrequestinadmin
 */
@WebServlet("/bookrequest")
public class Bookrequestinadmin extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			List<Books> list=LoginDao.getrequestedbook();
			 RequestDispatcher rd=request.getRequestDispatcher("UserBookRequest.jsp"); 
			 request.setAttribute("reqbook", list);
		        rd.include(request,response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	

}
