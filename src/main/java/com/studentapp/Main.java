package com.studentapp;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();

        System.out.println("--- Current list of students ---");
        List<Student> students = studentDAO.getAllStudents();
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("\n--- Deleting student with ID 2 ---");
        boolean success = studentDAO.deleteStudent(2);
        if (success) {
            System.out.println("Student with ID 2 was deleted successfully.");
        } else {
            System.out.println("Deletion failed. Student with ID 2 may not exist.");
        }

        System.out.println("\n--- Final list of students ---");
        List<Student> finalStudents = studentDAO.getAllStudents();
        for (Student student : finalStudents) {
            System.out.println(student);
        }

        System.out.println("\n--- Program Finished ---");
    }
}