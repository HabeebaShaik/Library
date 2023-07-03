<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<script>
function acceptbook(id){
	document.getElementById("bookid").value=id;
    document.forms.action = "acceptbook";
    document.forms.submit();
}
</script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table width="100%">
<tr><td>
<jsp:include page="header.jsp" />
</td></tr>
</table>
<form name="forms">
<table border='1' width='100%'>
 <tr>
 <th><font style="color:blue" align="left">BookId</font></th>
 <th><font style="color:blue">UserId</font></th>
 <th><font style="color:blue">BookAuthor</font></th>
 <th><font style="color:blue">BookStatus</font></th>
</tr>
<c:forEach var="BookEdit" items="${reqbook}">
<tr>
<td><c:out value="${BookEdit.bookId}"/></td>
<td><c:out value="${BookEdit.userid}"/></td>
<td><c:out value="${BookEdit.bookName}"/></td>
<td><c:out value="${BookEdit.bookstatus}"/></td>
<td><a href="#" onclick="acceptbook('<c:out value="${BookEdit.bookId}"/>')">Accept</a></td>
</tr></c:forEach>
</table>
<input type="hidden" value="" id="EditId" name="EditId"/> 
<input type="hidden" value="" id="bookid" name="bookid"/> 
<input type="hidden" value="<c:out value="${BookEdit.userid}"/>" id="userid" name="userid"/> 
<input type="hidden" value="<c:out value="${BookEdit.bookName}"/>" id="bookname" name="bookname"/> 
 
</form> 
</body>
</html>