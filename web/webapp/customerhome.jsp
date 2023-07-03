<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
function buybook(bookname,bookid){
	
	document.getElementById("bookid").value=bookid;
	document.getElementById("bookname").value=bookname;
	document.forms.action ="buybook";
	document.forms.submit();
}
</script>
</head>
<body>
<jsp:include page="header.jsp" />
<form name="forms">
<input type="hidden" name="userid" id="userid" value="<c:out value="${userid}"/>"/>
<input type="hidden" name="bookid" id ="bookid" value=""/>
<input type="hidden" name="bookname" id ="bookname" value=""/>

<table border='1' width='100%'>
 <tr>
 <th>BookId</th>
 <th>BookName</th>
 <th>Author</th>
 <th>Price</th>
 <th>BookStatus</th>
</tr><c:forEach var="BookEdit" items="${viewBooks}">
<tr>
<td><c:out value="${BookEdit.bookId}"/></td>
<td><c:out value="${BookEdit.bookName}"/></td>
<td><c:out value="${BookEdit.author}"/></td>
<td><c:out value="${BookEdit.price}"/></td>

<td><c:choose >
<c:when test="${BookEdit.bookstatus  eq 'Sold'}" >
Sold
</c:when>
<c:when test="${BookEdit.bookstatus  eq 'requested'}" >
requested
</c:when>
<c:otherwise>
<a href="#" onclick="buybook('<c:out value="${BookEdit.bookName}"/>','<c:out value="${BookEdit.bookId}"/>')">Buy</a>
</c:otherwise>

</c:choose>
</td>

</tr></c:forEach>
</table>
<input type="hidden" value="" id="EditId" name="EditId"/> 
</form>
</body>
</html>