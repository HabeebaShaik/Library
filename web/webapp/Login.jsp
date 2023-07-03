 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<%--<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="Images/reception.jpg">
<form  method="post">
<table  align="center" >
<tr>
<td><%
String login_msg=(String)request.getAttribute("error");  
if(login_msg!=null)
out.println("<font color=red size=4px>"+login_msg+"</font>");
%></td>
</tr>
</table>
<table name="Login" align="center">
<tr  height="30%">
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;</td></tr><tr><td>&nbsp;</td></tr><tr><td>&nbsp;</td></tr><tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;</td></tr><tr><td>&nbsp;</td></tr>
<td><font color="blue" >User Id:-</font><font color="red">*</font></td>
<td><input type="text" name="userId" /></td>
</tr><br/><br/>
<tr>
<td><font color="blue" >Password:-</font><font color="red">*</font></td>
<td><input type="text" name="password"/></td>
</tr>
<tr>
<td><input type="submit" value="Login" onclick="Login()"/></td>
<td><input type="submit" value="signup" onclick="callServlet()"/></td>
</tr>
</table>
</form>
</body>
</html>
 --%>
<!DOCTYPE html>
<html lang="en">
  <head>
  <script type="text/javascript">
            function callServlet() {
                document.forms.action = "RegisterServlet";
                document.forms.submit();
            }
            function Login() {
                document.forms.action = "FirstServlet";
                document.forms.submit();
            }
        </script>
  <style>
  
  *{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

.login_form_container{
    position: relative;
    width: 400px;
    height: 470px;
    max-width: 400px;
    max-height: 470px;
    background: #040717;
    border-radius: 50px 5px;
    display: flex;
    align-items: center;
    justify-content: center;
    overflow: hidden;
    margin-top: 70px;
}
.login_form_container::before{
    
    position: absolute;
    width: 170%;
    height: 170%;
    content: '';
    background-image: conic-gradient(transparent, transparent, transparent, #ee00ff);
    animation: rotate_border 6s linear infinite;

}
.login_form_container::after{
    
    position: absolute;
    width: 170%;
    height: 170%;
    content: '';
    background-image: conic-gradient(transparent, transparent, transparent, #00ccff);
    animation: rotate_border 6s linear infinite;
    animation-delay: -3s;
}
@keyframes rotate_border{
    0%{
        transform: rotate(0deg);
    }
    100%{
        transform: rotate(360deg);
    }
}
.login_form{
    position: absolute;
    content: '';
    background-color: #0c1022;
    border-radius: 50px 5px;
    inset: 5px;
    padding: 50px 40px;
    z-index: 10;
    color: #00ccff;

} 
h2{
    font-size: 40px;
    font-weight: 600;
    text-align: center;
}
.input_group{
    margin-top: 40px;
    position:relative;
    display:flex;
    align-items: center;
    justify-content: start;
}
.input_text{
    width: 95%;
    height: 30px;
    background: transparent;
    border: none;
    outline: none;
    border-bottom: 1px solid #00ccff;
    font-size: 20px;
    padding-left: 10px;
    color: #00ccff;

}
::placeholder{
    font-size: 15px;
    color: #00ccff52;
    letter-spacing: 1px;

}
.fa{
    font-size: 20px;

}
#login_button{
    position: relative;
    width: 300px;
    height: 40px;
    transition: 1s;
    margin-top: 30px;


}
#login_button a{
    position: absolute;
    width: 100%;
    height: 100%;
    text-decoration: none;
    z-index: 10;
    cursor: pointer;
    font-size: 22px;
    letter-spacing: 2px;
    border: 1px solid #00ccff;
    border-radius: 50px;
    background-color: #0c1022;
    display: flex;
    justify-content: center;
    align-items: center;
}
.fotter {
    margin-top: 30px;
    display: flex;
    justify-content: space-between;

}
.fotter a{
    text-decoration: none;
    cursor: pointer;
    font-size: 18px;
}
.glowIcon {
    text-shadow: 0 0 10px #00ccff;

}
  </style>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Animated Login From</title>
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
    />

    <link rel="stylesheet" href="login.css" />
  </head>
  <body background="Images/receptions.jpg">
  <table align="center"><tr><td id="error"><font style="color="red"><c:out value="${error}"/></font></td></tr></table>
  <form name="forms" >
  <div ><h1><font style="color:orange">Welcome to Library</font></h1></div>
  <div align="center">
  <c:out value="${error}"/>
  </div>
  <div style="padding-left:500px">
    <div class="login_form_container">
      <div class="login_form">
        <h2>Login</h2>
        <div class="input_group">
          <i class="fa fa-user"></i>
          <input
            type="text"
            placeholder="User Id"
            class="input_text"
            autocomplete="off" name="userId"
          />
        </div>
        <div class="input_group">
          <i class="fa fa-unlock-alt"></i>
          <input
            type="password"
            name="password"
            placeholder="Password"
            class="input_text"
            autocomplete="off"
          />
        </div>
        <div class="button_group" id="login_button">
          <a  onclick="Login()">Submit</a>
        </div>
        <div>&nbsp;</div>
        <div>if you are new user please SignUp</div>
        <div class="button_group" id="login_button">
          <a onclick="callServlet()">SingUp</a>
        </div>
      </div>
    </div>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="login.js"></script></div></form>
  </body>
</html>