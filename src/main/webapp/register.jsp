<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Registration</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        .container { max-width: 400px; margin: auto; padding: 20px; border: 1px solid #ddd; border-radius: 5px; }
        input[type=text], input[type=email], input[type=number] { width: 100%; padding: 10px; margin: 8px 0; box-sizing: border-box; }
        input[type=submit] { background-color: #4CAF50; color: white; padding: 10px 15px; border: none; cursor: pointer; width: 100%; }
        input[type=submit]:hover { background-color: #45a049; }
        h2 { text-align: center; }
        .link { text-align: center; margin-top: 10px; }
    </style>
</head>
<body>

<div class="container">
    <h2>Register Student</h2>
    
    <!-- This form submits data to the Servlet at the /register path -->
    <form action="register" method="post">
        
        <label for="name">Student Name</label>
        <input type="text" id="name" name="name" required placeholder="Enter full name">

        <label for="email">Email</label>
        <input type="email" id="email" name="email" required placeholder="Enter email">

        <label for="year">Year</label>
        <input type="number" id="year" name="year" required placeholder="Enter year (e.g. 2)" min="1" max="6">

        <input type="submit" value="Register">
    </form>
    
    <div class="link">
        <a href="show_all">View All Students</a>
    </div>
</div>

</body>
</html>