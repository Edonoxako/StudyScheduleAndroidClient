package com.edonoxako.studyscheduler.app.api;

import com.edonoxako.studyscheduler.app.model.Group;
import com.edonoxako.studyscheduler.app.model.Lecturer;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by Евгений on 13.10.2015.
 */
public interface RetrofitLecturerApi {

    @GET("/lecturer/{lecturerId}")
    void findLecturer(@Path("lecturerId") long id, Callback<Lecturer> cb);

    @GET("/lecturer")
    void findAllLecturers(Callback<List<Lecturer>> cb);

    @POST("/lecturer")
    void createLecturer(@Body Lecturer lecturer, Callback<?> cb);
}
