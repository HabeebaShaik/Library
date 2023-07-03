<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
            function update() {
                document.forms.action = "updatebook";
                document.forms.submit();
            }
        </script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="forms" method="post">
<table name="BookList" align="center">

<tr>
<td>Book Id:-</td>
<td><c:out value="${updatebook.bookId}"/></td>
<td><input type="hidden" name ="bookId" value='<c:out value="${updatebook.bookId}"/>'/></td>
</tr>
<tr>
<td>Book Name:-</td>
<td><input type="text" name="BookName" value="<c:out value="${updatebook.bookName}"/>"/></td>
</tr>
<tr>
<td>Author:-</td>
<td><input type="text" name="Author" value="<c:out value="${updatebook.author}"/>"/></td>
</tr>
<tr>
<td>Year of publication:-</td>
<td><input type="text" name="Year_of_publication" value="<c:out value="${updatebook.year_of_publication}"/>"/></td>
</tr>
<tr>
<td>Price:-</td>
<td><input type="text" name="Price" value="<c:out value="${updatebook.price}"/>"/></td>
</tr>
<tr>
<td>Book Status:-</td>
<td><select name="BookStatus">
<option value="">select</option>
<option value="Available" <c:if test="${updatebook.bookstatus eq  'Available' }"> selected</c:if> >Available</option>
<option value="Sold" <c:if test="${updatebook.bookstatus eq  'Sold' }"> selected</c:if>>Sold</option>
</select></td>
</tr>
<tr>
<td align="center"><input type="button" value="Edit&save" onclick="update()"/></td>
</tr>
</table>
</form>
</body>
</html>