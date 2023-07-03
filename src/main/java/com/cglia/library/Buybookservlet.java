package com.cglia.library;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class buybookservlet
 */
@WebServlet("/buybook")
public class Buybookservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userid = Integer.parseInt(request.getParameter("userid"));
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		String bookname = request.getParameter("bookname");
		try {
		LoginDao.updatebookstatus(userid, bookid, "request",bookname);
		}catch(Exception e) {
			e.printStackTrace();
		}
        RequestDispatcher rd=request.getRequestDispatcher("Userhomepageservlet");  
        request.setAttribute("userid", userid);
        rd.include(request,response); 
	}


}
