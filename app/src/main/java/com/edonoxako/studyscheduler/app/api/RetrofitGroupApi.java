package com.edonoxako.studyscheduler.app.api;

import com.edonoxako.studyscheduler.app.model.Group;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by Евгений on 13.10.2015.
 */
public interface RetrofitGroupApi {

    @GET("/group/{groupId}")
    void fetchGroup(@Path("groupId") long groupId, Callback<Group> cb);

    @GET("/group")
    void fetchAllGroups(Callback<List<Group>> cb);

    @POST("/group")
    void createGroup(@Body Group group, Callback<?> cb);
}
