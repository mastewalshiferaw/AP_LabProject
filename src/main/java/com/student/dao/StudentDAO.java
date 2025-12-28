package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.student.model.Student;
import com.student.util.DatabaseConnection;

public class StudentDAO {

    private static final String INSERT_STUDENT_SQL = "INSERT INTO students (name, email, year) VALUES (?, ?, ?);";
    private static final String SELECT_ALL_STUDENTS = "SELECT * FROM students;";

    // Method to insert a new student
    public void insertStudent(Student student) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {
            
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getYear());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get all students
    public List<Student> selectAllStudents() {
        List<Student> students = new ArrayList<>();
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS)) {
            
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int year = rs.getInt("year");
                
                students.add(new Student(id, name, email, year));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}