package com.cglia.library;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookList
 */
@SuppressWarnings("serial")
@WebServlet("/BookList")
public class BookList extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();
          
        List<Books> list=LoginDao.getAllBooks();
        RequestDispatcher rd=request.getRequestDispatcher("BookList.jsp");  
        request.setAttribute("viewBooks", list);
        rd.include(request,response); 
          
        out.close();   
	}

}
