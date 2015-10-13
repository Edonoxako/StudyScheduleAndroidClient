package com.edonoxako.studyscheduler.app.api;

import com.edonoxako.studyscheduler.app.model.Subject;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Евгений on 13.10.2015.
 */
public class SubjectApi {

    List<Subject> items;

    public SubjectApi() {
        items = new LinkedList<Subject>();
        items.add(new Subject("Math"));
        items.add(new Subject("Informatics"));
        items.add(new Subject("Physics"));
        items.add(new Subject("Programming"));
        items.add(new Subject("Complex Systems"));
    }

    public List fetchSubjects() {
        return items;
    }

    public Subject fetchOneSubject(int pos) {
        return items.get(pos);
    }
 }
