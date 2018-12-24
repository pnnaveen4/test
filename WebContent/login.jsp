<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
#form{
position:relative;
left-margin:500px;
}

</style>
</head>
<body>
<div id="form">
<form action="http://localhost/Login/log" method="post">
<h1>Enter log in deatils</h1>
            <label>Enter UserName: </label><input type="text" name="uname" required><br>
            <label>Enter Password: </label><input type="password" name="upass" required><br>
            <input type="submit" value="Login">
        </form>
</div>
        
</body>
</html>