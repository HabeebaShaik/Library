package com.cglia.library;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class updatebooks
 */
@SuppressWarnings("serial")
@WebServlet("/updatebook")
public class updatebooks extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("bookId"));
		String name = request.getParameter("BookName");
		String status = request.getParameter("BookStatus");
		String author = request.getParameter("Author");
		int year = Integer.parseInt(request.getParameter("Year_of_publication"));
		int price = Integer.parseInt(request.getParameter("Price"));
		
		Books book = new Books();
		book.setBookId(id);
		book.setBookName(name);
		book.setAuthor(author);
		book.setYear_of_publication(year);
		book.setPrice(price);
		book.setBookstatus(status);
		int Status = LoginDao.update(book);
		if (Status > 0) {
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("Books.jsp").include(request, response);
		} else {
			out.println("Sorry! unable to save record");
		}
		 RequestDispatcher rd=request.getRequestDispatcher("BookList.jsp");
		 rd.include(request,response);
	}

}
