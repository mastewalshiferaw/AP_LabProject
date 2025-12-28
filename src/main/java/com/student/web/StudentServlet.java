package com.student.web;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.student.dao.StudentDAO;
import com.student.model.Student;

// This annotation maps the servlet to the root URL and specific paths
@WebServlet("/")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDAO studentDAO;

    public void init() {
        studentDAO = new StudentDAO();
    }

    // Handles POST requests (like submitting the register form)
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        if (action.equals("/register")) {
            // 1. Get data from the form
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            int year = Integer.parseInt(request.getParameter("year"));

            // 2. Create student object
            Student newStudent = new Student(name, email, year);
            
            // 3. Insert into database
            studentDAO.insertStudent(newStudent);
            
            // 4. Redirect to the list view
            response.sendRedirect("show_all");
        } else {
            // Default fall-back
            doGet(request, response);
        }
    }

    // Handles GET requests (viewing pages)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
            case "/show_all":
                listStudents(request, response);
                break;
            default:
                // By default, show the registration form
                showRegisterForm(request, response);
                break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // 1. Get students from DB
        List<Student> listStudent = studentDAO.selectAllStudents();
        // 2. Attach students to the request object
        request.setAttribute("listStudent", listStudent);
        // 3. Send to the JSP page
        request.getRequestDispatcher("list-students.jsp").forward(request, response);
    }

    private void showRegisterForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }
}