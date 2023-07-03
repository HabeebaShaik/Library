<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="BookIssue" method="post">
<table name="Issue Book" align="center">
<tr>
<td>Book Id:-</td>
<td><input type="number" name="BookId"/></td>
</tr><br/><br/>
<tr>
<td>User Id:-</td>
<td><input type="number" name="UserId"/></td>
</tr>
<tr>
<td>Book Name:-</td>
<td><input type="text" name="BookName"/></td>
</tr>
<tr>
<td>User Name:-</td>
<td><input type="text" name="UserName"/></td>
</tr>
<tr>
<td>Price:-</td>
<td><input type="number" name="price"/></td>
</tr>
<tr>
<td>Book Status:-</td>
<td><select name="BookStatus">
<option value="Available">Available</option>
<option value="Sold">Sold</option>
</select></td>
</tr>
<tr>
<td align="center"><input type="button" value="Update"/></td>
</tr>
</table>
</form>
</body>
</html>
