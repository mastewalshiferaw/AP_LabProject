<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.student.model.Student" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student List</title>
    <style>
        body { font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif; margin: 40px; background-color: #f9f9f9; }
        h2 { text-align: center; color: #333; }
        table { border-collapse: collapse; width: 80%; margin: 20px auto; background-color: white; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
        th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }
        th { background-color: #4CAF50; color: white; }
        tr:nth-child(even) { background-color: #f2f2f2; }
        tr:hover { background-color: #ddd; }
        .btn-container { text-align: center; margin-top: 20px; }
        .btn { text-decoration: none; background-color: #2196F3; color: white; padding: 10px 20px; border-radius: 5px; }
        .btn:hover { background-color: #0b7dda; }
    </style>
</head>
<body>

    <h2>Registered Students</h2>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Year</th>
            </tr>
        </thead>
        <tbody>
            <%
                // Retrieve the list of students sent by the Servlet
                List<Student> listStudent = (List<Student>) request.getAttribute("listStudent");
                
                if (listStudent != null && !listStudent.isEmpty()) {
                    for (Student student : listStudent) {
            %>
            <tr>
                <td><%= student.getId() %></td>
                <td><%= student.getName() %></td>
                <td><%= student.getEmail() %></td>
                <td><%= student.getYear() %></td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="4" style="text-align:center;">No students found in database.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>

    <div class="btn-container">
        <a href="register.jsp" class="btn">Add New Student</a>
    </div>

</body>
</html>