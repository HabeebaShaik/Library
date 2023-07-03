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
 * Servlet implementation class EditBook
 */
@SuppressWarnings("serial")
@WebServlet("/EditBooksId")
public class EditBooksId extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=0;
		try {
			id=Integer.parseInt(request.getParameter("EditId"));
		List<Books> List = LoginDao.EditBooks(id) ;
		Books book= List.get(0);
		RequestDispatcher rd=request.getRequestDispatcher("EditBook.jsp");
		 request.setAttribute("updatebook", book);
        rd.forward(request,response);
       
		}catch(Exception e) {
			e.printStackTrace();
		}
			}



}
