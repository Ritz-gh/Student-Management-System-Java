package com.studentapp;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class StudentDAO {

    public void addStudent(Student student) {
        String sql = "INSERT INTO students (name, email, major, phone_number) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getEmail());
            pstmt.setString(3, student.getMajor());
            pstmt.setString(4, student.getPhoneNumber());

            pstmt.executeUpdate();
            System.out.println("Student '" + student.getName() + "' added successfully!");

        } catch (SQLException e) {
            System.err.println("Error adding student: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM studentdb.students";

        try (Connection conn = DatabaseConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
            
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String major = rs.getString("major");
                String phoneNumber = rs.getString("phone_number");

                Student student = new Student(id, name, email, major, phoneNumber);
                
             
                students.add(student);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching students: " + e.getMessage());
            e.printStackTrace();
        }
        
        return students;
    }

    public boolean updateStudentMajor(int studentId, String newMajor) {
        String sql = "UPDATE studentdb.students SET major = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {


            pstmt.setString(1, newMajor);

            pstmt.setInt(2, studentId);


            int rowsAffected = pstmt.executeUpdate();


            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error updating student major: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteStudent(int studentId) {
        String sql = "DELETE FROM studentdb.students WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {


            pstmt.setInt(1, studentId);

            int rowsAffected = pstmt.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error deleting student: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
        }
    

