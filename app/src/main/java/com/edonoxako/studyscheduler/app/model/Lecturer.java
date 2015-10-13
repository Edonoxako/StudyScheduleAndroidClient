package com.edonoxako.studyscheduler.app.model;

/**
 * Created by Евгений on 13.10.2015.
 */
public class Lecturer {

    private long id;

    private String firstName;
    private String lastName;
    private String patronymic;

    public Lecturer() {
    }

    public Lecturer(String firstName, String lastName, String patronymic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + patronymic;
    }
}
