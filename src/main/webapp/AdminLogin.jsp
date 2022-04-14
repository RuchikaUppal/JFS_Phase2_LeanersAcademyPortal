<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
 <link type="text/css" rel="stylesheet" href="css/login1.css"> 
</head>
<body style="background-image: url('css/background.jpg');">
<center> <h1>Welcome To Learners Academy </h1> </center> 
  <center> <h2> Admin Login </h2> </center>   
    <form action="AdminServlet" method="POST">  
        <div class="container">   
        	<input type="hidden" name="command" value="LOGIN" />
            <label>User Name : </label>   
            <br/>
            <input type="text" placeholder="Enter Username" name="userName" required>  
            <br/>
            <label>Password : </label>   
            <br/>
            <input type="password" placeholder="Enter Password" name="password" required>  
            <br/>
            <button type="submit">Login</button>   
            <br/>             
        </div>   
    </form> 
    </br>
    <center><footer>Developed By : Ruchika Uppal</footer></center>    
</body>
</html>