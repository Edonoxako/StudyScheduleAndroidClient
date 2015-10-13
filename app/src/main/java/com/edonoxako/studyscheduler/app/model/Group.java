package com.edonoxako.studyscheduler.app.model;

/**
 * Created by Евгений on 12.10.2015.
 */
public class Group {

    private int id;
    private String number;
    private String institute;

    public Group() {
    }

    public Group(String number, String institute) {
        this.number = number;
        this.institute = institute;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getInstitute() {
        return institute;
    }

    public String getNumber() {
        return number;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Number: " + number + "\nInstitute: " + institute;
    }

}
