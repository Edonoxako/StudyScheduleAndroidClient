package com.edonoxako.studyscheduler.app.lecturer.lecturerdescription;

import com.edonoxako.studyscheduler.app.abstractions.BaseFragment;
import com.edonoxako.studyscheduler.app.abstractions.SimplePresenter;
import com.edonoxako.studyscheduler.app.api.RetrofitLecturerApi;
import com.edonoxako.studyscheduler.app.model.Lecturer;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Евгений on 13.10.2015.
 */
public class LecturerDescriptionPresenter implements SimplePresenter {

    private long id;

    private LecturerDescriptionFragment fragment;

    private RetrofitLecturerApi api;

    public LecturerDescriptionPresenter(long id, RetrofitLecturerApi api) {
        this.api = api;
        this.id = id;
    }

    @Override
    public void bindFragment(BaseFragment fragment) {
        this.fragment = (LecturerDescriptionFragment) fragment;
    }

    @Override
    public void init() {
        api.findLecturer(id, new Callback<Lecturer>() {
            @Override
            public void success(Lecturer lecturer, Response response) {
                fragment.setData(lecturer);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
