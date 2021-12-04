package com.example.tasklist;

public class User {

    String name, subject, date, meetTime, description;


    public User(String name, String subject, String date, String meetTime, String description) {
        this.name = name;
        this.subject = subject;
        this.date = date;
        this.meetTime = meetTime;
        this.description = description;

    }

    public String getName() {
        return this.name;
    }

}
