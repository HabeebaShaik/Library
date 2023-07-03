<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
            function EditBook(id) {
            	
            	document.getElementById("EditId").value=id;
                document.forms.action = "EditBooksId";
                document.forms.submit();
            }
            function DeleteBook(id) {
            	
            	document.getElementById("deleteid").value=id;
                document.forms.action = "deleteBooksId";
                document.forms.submit();
            }
        </script>
        <style>
        .th {
        color:skyblue;
        }
        </style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="Images/listbooks.jpeg">
<table width="100%">
<tr><td>
<jsp:include page="header.jsp" />
</td></tr>
</table>
<form name="forms">
<table border='1' border-color="white" width='100%'>
 <tr>
 <th><font style="color:violet">BookId</font></th>
 <th><font style="color:violet">BookName</font></th>
 <th><font style="color:violet">Author</font></th>
 <th><font style="color:violet">Price</font></th>
 <th><font style="color:violet">BookStatus</font></th>
</tr><c:forEach var="BookEdit" items="${viewBooks}">
<tr>
<td><font style="color:white"><c:out value="${BookEdit.bookId}"/></font></td>
<td><font style="color:white"><c:out value="${BookEdit.bookName}"/></font></td>
<td><font style="color:white"><c:out value="${BookEdit.author}"/></font></td>
<td><font style="color:white"><c:out value="${BookEdit.price}"/></font></td>
<td><font style="color:white"><c:out value="${BookEdit.bookstatus}"/></font></td>
<td><a href="#" onclick="EditBook('<c:out value="${BookEdit.bookId}"/>')"><font style="color:white">update</font></a></td>
<td><a href="#" onclick="DeleteBook('<c:out value="${BookEdit.bookId}"/>')"><font style="color:white">Delete</font></a></td>
<td></td>
</tr></c:forEach>
</table>
<input type="hidden" value="" id="EditId" name="EditId"/> 
<input type="hidden" value="" id="deleteid" name="deleteid"/> 
</form> 
</body>
</html>