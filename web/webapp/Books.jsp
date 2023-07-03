<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
.button {
  background-color: blue; /* Green */
  border: none;
  color: white;
  padding: 10px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

.button1 {border-radius: 2px;}
.button2 {border-radius: 4px;}
.button3 {border-radius: 8px;}
.button4 {border-radius: 12px;}
.button5 {border-radius: 50%;}
</style>
<script type="text/javascript">
            function submiter() {
            	
            	var flag =validation();
            	
            	if (flag=='yes'){
                document.forms.action = "AddBook";
                document.forms.submit(); 
            }
            	else{
            		
            		document.getElementById("error").innerHTML="<font style='color:red;padding-left:100px'>"+flag+"</font>";
            	}
           }
            
            function validation(){
            	var flag='yes';
            	var BookName =document.getElementById("BookName").value;
            	var Author = document.getElementById("Author").value;
            	var yop = document.getElementById("Year_of_publication").value;
            	var price = document.getElementById("Price").value;
            	var BookStatus = document.getElementById("BookStatus").value;
            	
            	if(null != BookName && BookName ==""){
            		 flag = 'please Enter BookName';
            		 return flag;	
            	}
            	if( null != Author && Author == ""){
            		 flag = 'please Enter Author';
            		 return flag;
            	}
            	
            	if(null != yop  && yop == ""){
            		 flag = 'please Enter Year of publication';
            		 return flag;
            	}
            	
            	if(flag && null != price && price == ""){
            		 flag = 'please Enter price';
            		 return flag;
            	}
            	
            	if( null != BookStatus && BookStatus == ""){
            		 flag = 'please Enter BookStatus';
            		 return flag;
            	}
            	
            }
        </script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head><jsp:include page="adminheader.jsp" />
<body background="Images/reception.jpg">


<form name="forms" >
<table align="center">
<tr><td id="error"></td></tr>
<tr><td>&nbsp;</td></tr>
</table>
<table name="BookList" align="center" >

<tr >
<td ><font style="color:red ;"><b>Book Name:-</b></font></td>
<td ><input type="text" name="BookName" id="BookName"/></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr>
<td><font style="color:red"><b>Author:-</b></font></td>
<td><input type="text" name="Author" id="Author"/></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr>
<td><font style="color:red"><b>Year of publication:-</b></font></td>
<td><input type="number" name="Year_of_publication" id="Year_of_publication"/></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr>
<td><font style="color:red"><b>Price:-</b></font></td>
<td><input type="number" name="Price" id="Price"/></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr>
<td><font style="color:red"><b>Book Status:-</b></font></td>
<td><select name="BookStatus" id="BookStatus">
<option value="">Select</option>
<option value="Available">Available</option>
</select></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td width="15px">&nbsp;</td>
<td align="center"  class="button button2" onclick="submiter()">Add</td>
</tr>
</table>
</form>

</body>
</html>