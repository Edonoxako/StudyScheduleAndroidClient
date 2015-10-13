package com.edonoxako.studyscheduler.app.lecturer.rootlist;

import com.edonoxako.studyscheduler.app.services.Router;
import com.edonoxako.studyscheduler.app.abstractions.BaseListFragment;
import com.edonoxako.studyscheduler.app.abstractions.ListPresenter;
import com.edonoxako.studyscheduler.app.api.RetrofitLecturerApi;
import com.edonoxako.studyscheduler.app.model.Lecturer;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Евгений on 12.10.2015.
 */
public class RootListPresenter implements ListPresenter {

    private RootListFragment fragment;

    private RetrofitLecturerApi api;
    private Router router;

    public RootListPresenter(RetrofitLecturerApi api, Router router) {
        this.api = api;
        this.router = router;
    }

    @Override
    public void init() {
        api.findAllLecturers(new Callback<List<Lecturer>>() {
            @Override
            public void success(List<Lecturer> lecturers, Response response) {
                fragment.setData(lecturers);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    @Override
    public void bindFragment(BaseListFragment fragment) {
        this.fragment = (RootListFragment) fragment;
    }

    public void showLecturerDescription(long id) {
        router.goToLecturerDescription(id);
    }

    public void createNewLecturer() {
        router.goToLecturerCreating();
    }

}
