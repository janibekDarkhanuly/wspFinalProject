package models;

import java.io.Serializable;

public class Student extends User {
    private String id = "23B031270";
    private int maxCredit = 21;
    private static final long serialVersionUID = 1L;


    public Student(String username, String password) {
        super(username, password);
    }
    public Student(String username, String password, String firstName, String lastName) {
        super(username, password, firstName, lastName);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;

    }

}