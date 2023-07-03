package com.cglia.library;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddBook
 */
@SuppressWarnings("serial")
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String bookName = request.getParameter("BookName");
		String author = request.getParameter("Author");
		String yop = request.getParameter("Year_of_publication");
		String price = request.getParameter("Price");
		String bookStatus = request.getParameter("BookStatus");
        int max = 1000 ;
        int min = 9999;
        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
		Books book = new Books();
		book.setBookId(random_int);
		book.setBookName(bookName);
		book.setAuthor(author);
		book.setYear_of_publication(Integer.parseInt(yop));
		book.setPrice(Integer.parseInt(price));
		book.setBookstatus(bookStatus);
		int status = LoginDao.save(book);
		if (status > 0) {
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("Books.jsp").include(request, response);
		} else {
			out.println("Sorry! unable to save record");
		}

		out.close();
	}
}
