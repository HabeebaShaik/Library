<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
         
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script>
function addbook(){
	document.form.action="AdminAddBook";
	document.form.submit();
}
function viewbooks(){
	document.form.action="BookList";
	document.form.submit();
}
function home(){
	document.form.action="logout";
	document.form.submit();
}
</script>
</head>
<body ><form name="form">
<table width="100%">
<tr  ><td>
<tr><td style="color:orange;" width="70%"><h3>Welcome to Library</h3></td><td onclick="addbook()" align="left"><font style="color:orange">Add Book</font></td><td align="left" onclick="viewbooks()"><font style="color:orange">View Books</font></td><td onclick="home()"><font style="color:orange">Logout</font></td><td width="10%" align="left" class="glyphicon glyphicon-user"><font style="color:orange" ><c:out value="${username}"/></font></td></tr>

</table></form>
</body>
</html>