package com.cglia.library;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class EditServletUser
 */
@SuppressWarnings("serial")
@WebServlet("/EditServletUser")
public class EditServletUser extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();   
		try {
		String	UserName=request.getParameter("UserName");
		int Age=Integer.parseInt(request.getParameter("age"));
		String	Gender=request.getParameter("gender");
		String	Email=request.getParameter("email");
		String	State=request.getParameter("State");
		String	City=request.getParameter("city");
		String	Password=request.getParameter("password"); 
			User user=new User();
			user.setUserName(UserName);
			user.setAge(Age);
			user.setGender(Gender);
			user.setEmail(Email);
			user.setState(State);
			user.setCity(City);
			user.setPassword(Password);
			
		 int status=LoginDao.update(user);  
        if(status>0){  
            response.sendRedirect("UserList");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close(); 
	}catch(Exception e) {
		e.printStackTrace();
	}

}
}
