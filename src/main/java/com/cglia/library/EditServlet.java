package com.cglia.library;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class EditServlet
 */
@SuppressWarnings("serial")
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        out.println("<h1>Update User</h1>");  
	        String sid=request.getParameter("userId");  
	        int userId=Integer.parseInt(sid);  
	          
	        User user=LoginDao.getUserById(userId);  
	          
	        out.print("<form action='EditServletUser' method='post'>");  
	        out.print("<table>");  
	        out.print("<tr><td>User Id:</td><td>"+user.getUserId()+"</td></tr>");  
	        out.print("<tr><td>User Name:</td><td><input type='text' name='UserName' value='"+user.getUserName()+"'/></td></tr>");  
	        out.print("<tr><td>Age:</td><td><input type='radio' name='age' value='"+user.getAge()+"'/> 17 Years</td></tr>"); 
	        out.print("<tr><td>Age:</td><td><input type='radio' name='age' value='"+user.getAge()+"'/> Above 17 Years</td></tr>"); 
	        out.print("<tr><td>Gender:</td><td><input type='checkbox' name='gender' value='"+user.getGender()+"'/>Male</td>");
	        out.print("<td><input type='checkbox' name='gender' value='"+user.getGender()+"'/>Female</td></tr>"); 
	        out.print("<tr><td>Email:</td><td><input type='text' name='email' value='"+user.getEmail()+"'/></td></tr>"); 
	        out.print("<tr><td>State:</td><td>");  
	        out.print("<select name='State' style='width:150px'>");  
	        out.print("<option value='' >Select</option>"); 
	        out.print("<option value='AndhraPradesh'>AndhraPradesh</option>");  
	        out.print("<option value='Telangana'>Telangana</option>");  
	        out.print("<option value='maharastra'>maharastra</option>");  
	        out.print("<option value='Karnataka'>Karnataka</option>");  
	        out.print("<option value='Tamilnadu'>Tamilnadu</option>");
	        out.print("</select>");  
	        out.print("</td></tr>"); 
	        out.print("<tr><td>City:</td><td>");  
	        out.print("<select name='city' style='width:150px'>");  
	        out.print("<option value='' >Select</option>"); 
	        out.print("<option value='Nellore'>Nellore</option>");  
	        out.print("<option value='Hyderabad'>Hyderabad</option>");  
	        out.print("<option value='pune'>pune</option>");  
	        out.print("<option value='Banglore'>Banglore</option>");  
	        out.print("<option value='Chennai'> Chennai</option>");
	        out.print("</select>");  
	        out.print("</td></tr>"); 
	        out.print("<tr><td>Password:</td><td><input type='text' name='password' value='"+user.getPassword()+"'/></td></tr>");   
	        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
	        out.print("</table>");  
	        out.print("</form>");  
	          
	        out.close();  
	}

}
