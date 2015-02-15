<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>


<div class="container-fluid">
<div  class="col-md-6 center-block">
<form method="POST" action="userRegistration.do">
	<div class="form-group">
    	<label>Email address</label>
    	<input type="email" class="form-control" name="newEmail" placeholder="Enter email">
	</div>
	<div class="form-group">
    	<label>Username</label>
    	<input type="text" class="form-control" name="newUsername" placeholder="Enter username">
  	</div>
  	<div class="form-group">
    	<label for="inputPassword">Password</label>
    	<input type="password" class="form-control" name="newPassword" placeholder="Password">
  	</div>
	<button type="submit" class="btn btn-default">Submit</button>
</form>
</div>
</div>
</body>
</html>