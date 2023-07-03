<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style>
div {
  background-color: skyblue;
  width: 150px;
  border: 10px solid pink;
  padding: 10px;
  margin: 20px;
}
</style>
<script type="text/javascript">
	function addBook() {
		document.forms.action = "AdminAddBook";
		document.forms.submit();
	}
	function bookList() {
		document.forms.action = "BookList";
		document.forms.submit();
	}
	function viewUser() {
		document.forms.action = "UserList";
		document.forms.submit();
	}
	function bookrequest() {
		document.forms.action = "bookrequest";
		document.forms.submit();
	}
</script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="Images/Admin.jpg">
<table width="100%">
<tr><td>
<jsp:include page="adminheader.jsp" />
</td></tr>
</table>
	<form name="forms">
		<table name="Admin" >
			<tr>
				<td><div onclick="addBook()" >AddBook</div></td>
				<td><div onclick="bookList()">BookList</div></td>
				<td><div  onclick="viewUser()">Users<c:out value="${usrcnt}"/> </div></td>
				<td><div onclick="bookrequest()">BookRequest<c:out value="${reqcunt}"/></div></td>
			</tr>
		</table>
	</form>
</body>
</html>