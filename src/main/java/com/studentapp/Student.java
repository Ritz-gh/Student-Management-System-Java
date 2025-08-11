package com.studentapp;

public class Student {

    private int id;
    private String name;
    private String email;
    private String major;
    private String phoneNumber;


    public Student(int id, String name, String email, String major, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.major = major;
        this.phoneNumber = phoneNumber;
    }

 
    public Student(String name, String email, String major, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.major = major;
        this.phoneNumber = phoneNumber;
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

  
    @Override
    public String toString() {
        return "Student [ID=" + id + ", Name=" + name + ", Email=" + email + 
               ", Major=" + major + ", Phone=" + phoneNumber + "]";
    }
}