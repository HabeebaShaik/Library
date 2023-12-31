package com.cglia.library;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deletebook
 */
@WebServlet("/deleteBooksId")
public class deletebook extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("deleteid"));
		LoginDao.deletebook(id);
		 RequestDispatcher rd=request.getRequestDispatcher("BookList");
        request.setAttribute("msg", "record deleted successfully");
        rd.forward(request,response); 

	}
}
