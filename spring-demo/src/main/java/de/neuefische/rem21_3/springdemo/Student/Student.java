package de.neuefische.rem21_3.springdemo.Student;

import java.util.List;

public class Student {

    private String firstname;
    private String surname;

    public Student(String firstname, String surname) {
        this.firstname = firstname;
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}


