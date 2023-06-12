<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>SignUp</title>
</head>
<body>
	
	<h4 align="center">Register Yourself and Be Our Family</h4>
	<!--<h4 align="center" style="color: red;">${sessionScope.book.msg}</h4>  -->
	<div class="row" style="width : 800px;margin : 100px;">
	<form action="address.jsp" method="post" align=center>
  <div class="form-group">
    <label for="first_name" class="col-sm-2 col-form-label">First Name</label>
    <input type="text" class="form-control" name="fname" }>
  </div><br>
  
  <div class="mb-3">
    <label for="last_name" class="form-label">Last Name</label>
    <input type="text" class="form-control" name="lname" aria-describedby="">
  </div><br>
  
  <div class="mb-3">
    <label for="age" class="form-label">Age</label>
    <input type="number" class="form-control" name="age" aria-describedby="">
  </div><br>
  
  <div class="mb-3">
    <label for="contact" class="form-label">Phone Number</label>
    <input type="text" class="form-control" name="contact" aria-describedby="">
  </div><br>
  
  <div class="mb-3">
    <label for="email" class="form-label">Email</label>
    <input type="text" class="form-control" name="email" aria-describedby="">
  </div><br>
  
  <div class="mb-3">
    <label for="" class="form-label">Password</label>
    <input type="text" class="form-control" name="email" aria-describedby="">
  </div><br>
  
  <button type="submit" class="btn btn-primary" onsubmit="/signup">Submit</button>
</form>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>