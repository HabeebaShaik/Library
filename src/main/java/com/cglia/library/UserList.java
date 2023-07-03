package com.cglia.library;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserList
 */
@SuppressWarnings("serial")
@WebServlet("/UserList")
public class UserList extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();
        out.println("<a href='SignUp.jsp'>Add New User</a>\n"); 
        out.println("<a href='index.html'>Search User</a>");
        out.println("<h1>User List</h1>");  
          
        List<User> list=LoginDao.getAllUsers();
        
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>UserId</th><th>UserName</th><th>Age</th><th>Gender</th><th>state</th><th>City</th><th>Password</th><th>Edit</th><th>Delete</th></tr>");  
        for(User user:list){  
         out.print("<tr><td>"+user.getUserId()+"</td><td>"+user.getUserName()+"</td><td>"+user.getAge()+"</td><td>"+user.getGender()+"</td><td>"+user.getState()+"</td><td>"+user.getCity()+"</td><td>"+user.getPassword()+"</td><td><a href='EditServlet?userId="+user.getUserId()+"'>update</a></td>  <td><a href='DeleteServlet?userId="+user.getUserId()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();   
	}

}
