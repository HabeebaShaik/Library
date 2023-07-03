
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!-- Website - www.codingnepalweb.com -->
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form Validation in HTML | CodingNepal</title>
    <link rel="stylesheet" href="style.css">
    <!-- Fontawesome CDN Link For Icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
   <script type="text/javascript">
            function save() {
				 var flag =validation();
            	
            	if (flag=='yes'){
                document.forms.action = "SecondServlet";
                document.forms.submit();
				}
				 else{
            		
            		document.getElementById("error").innerHTML="<font style='color:red;padding-left:100px'>"+flag+"</font>";
            	}
            }
			
			function validation(){
            	var flag='yes';
            	var usename =document.getElementById("username").value;
            	var email = document.getElementById("email").value;
            	var gender = document.getElementById("gender").value;
            	var state = document.getElementById("state").value;
            	var city = document.getElementById("city").value;
				var password = document.getElementById("password").value;
            	
            	if(null != usename && usename ==""){
            		 flag = 'please Enter User Name';
            		 return flag;	
            	}
            	if( null != email && email == ""){
            		 flag = 'please Enter email';
            		 return flag;
            	}
            	
            	if(null != gender  && gender == ""){
            		 flag = 'please select  Gender';
            		 return flag;
            	}
            	
            	if(null != state && state == ""){
            		 flag = 'please select state';
            		 return flag;
            	}
            	
            	if( null != city && city == ""){
            		 flag = 'please select city';
            		 return flag;
            	}
				 if( null != password && password == ""){
            		 flag = 'please Enter password';
            		 return flag;
            	}
            	
            }
        </script>
   
    <style>
    @import url('https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;500;600;700&display=swap');

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Open Sans', sans-serif;
}

body {
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 0 10px;
  min-height: 80vh;
}

form {
  padding: 25px;
  background: #1BB295;
  max-width: 350px;
  width: 100%;
  border-radius: 7px;
  box-shadow: 0 10px 15px rgba(0, 0, 0, 0.05);
}

form h2 {
  color: white;
  border: none;
  height: auto;
  font-size: 16px;
  padding: 8px 0;
  border-radius: 5px;
  cursor: pointer;
  font-weight: 500;
  text-align: center;
  background: skyblue;
  transition: 0.2s ease;
}

form .form-group {
  margin-bottom: 0px;
  position: relative;
}

form label {
  display: block;
  font-size: 15px;
  margin-bottom: 1px;
  font-color:red;
}

form input,
form select {
  height: 45px;
  padding: 10px;
  width: 100%;
  font-size: 15px;
  outline: none;
  background: #fff;
  border-radius: 3px;
  border: 1px solid #bfbfbf;
}

form input:focus,
form select:focus {
  border-color: #9a9a9a;
}

form input.error,
form select.error {
  border-color: #f91919;
  background: #f9f0f1;
}

form small {
  font-size: 14px;
  margin-top: 5px;
  display: block;
  color: #f91919;
}

form .password i {
  position: absolute;
  right: 0px;
  height: 45px;
  top: 28px;
  font-size: 13px;
  line-height: 45px;
  width: 45px;
  cursor: pointer;
  color: #939393;
  text-align: center;
}

.submit-btn {
  margin-top: 30px;
}

.submit-btn input {
  color: white;
  border: none;
  height: auto;
  font-size: 16px;
  padding: 13px 0;
  border-radius: 5px;
  cursor: pointer;
  font-weight: 500;
  text-align: center;
  background: #1BB295;
  transition: 0.2s ease;
}

.submit-btn input:hover {
  background: #179b81;
}
    </style>
  </head>
  <body background="Images/library1.jpg">
  <div style="padding-right:300px"><h1><font style="color:orange">Welcome to Library</font></h1></div>
    <form name="forms">
    <table align="center">
<tr><td id="error"></td></tr>
<tr><td>&nbsp;</td></tr>
</table>
    <div >
      <h2>Register</h2>
      <div></div>
      <div class="form-group fullname">
        <label for="fullname">Full Name</label>
        <input type="text" id="fullname" name="username" placeholder="Enter your full name">
      </div>
      <div class="form-group email">
        <label for="email">Email Address</label>
        <input type="text" name ="email" id="email" placeholder="Enter your email address">
      </div>

      <div class="form-group gender">
        <label for="gender">Gender</label>
        <select id="gender" name="gender">
          <option value="" selected disabled>Select your gender</option>
          <option value="Male">Male</option>
          <option value="Female">Female</option>
          <option value="Other">Other</option>
        </select>
      </div>
            <div class="form-group date">
        <label for="city">State</label>
        <select name="state">
<option value="">select State</option>
<option value="Andhra pradesh">Andhra pradesh</option>
<option value="Telangana">Telangana</option>
<option value="Maharastra">Maharastra</option>
<option value="Karnataka">Karnataka</option>
<option value="Tamilnadu">Tamilnadu</option>
</select>
        </div>
      <div class="form-group date">
        <label for="city">City</label>
        <select name="city">
<option value="">select City</option>
<option value="Nellore">Nellore</option>
<option value="Hyderabad">Hyderabad</option>
<option value="Pune">Pune</option>
<option value="Banglore">Banglore</option>
<option value="Chennai">Chennai</option>
</select>
      </div>
            <div class="form-group password">
        <label for="password">Password</label>
        <input type="password" name="password" id="password" placeholder="Enter your password">
        <i id="pass-toggle-btn" class="fa-solid fa-eye"></i>
      </div>
      <div class="form-group submit-btn">
        <input type="submit" value="Submit" onclick="save()">
      </div>
      </div>
    </form>

    <script src="script.js"></script>
  </body>
</html>