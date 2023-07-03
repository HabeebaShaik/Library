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

function home(){
	document.form.action="Servlet2";
	document.form.submit();
}
</script>
</head>
<body ><form name="form">
<table width="100%">
<tr  ><td>
<tr><td style="color:orange;" width="70%"><h3>Welcome to Library</h3></td><td width="10%" onclick="addbook()" align="right"><font style="color:orange">Add Book</font></td><td width="10%" onclick="home()" align="right"><font style="color:orange">Home</font></td><td width="10%" align="right"><c:out value="${username}"/></td><td width="2%"class="glyphicon glyphicon-user">user</td></tr>

</table></form>
</body>
</html>