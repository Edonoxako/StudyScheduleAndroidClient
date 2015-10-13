package com.edonoxako.studyscheduler.app.lecturer.createlecturer;

import com.edonoxako.studyscheduler.app.ResultDataInvoker;
import com.edonoxako.studyscheduler.app.api.RetrofitGroupApi;
import com.edonoxako.studyscheduler.app.api.RetrofitLecturerApi;
import com.edonoxako.studyscheduler.app.model.Group;
import com.edonoxako.studyscheduler.app.model.Lecturer;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Евгений on 13.10.2015.
 */
public class LecturerCreatePresenter {

    private LecturerCreateFragment fragment;

    private RetrofitLecturerApi api;
    private ResultDataInvoker invoker;

    public LecturerCreatePresenter(RetrofitLecturerApi api, ResultDataInvoker invoker) {
        this.api = api;
        this.invoker = invoker;
    }

    public void bindFragment(LecturerCreateFragment fragment) {
        this.fragment = fragment;
    }

    public void saveChanges() {
        String firstName = fragment.getLecturerFirstName();
        String lastName = fragment.getLecturerLastName();
        String patronymic = fragment.getLecturerPatronymic();
        Lecturer lecturer = new Lecturer(firstName, lastName, patronymic);
        api.createLecturer(lecturer, new Callback() {
            @Override
            public void success(Object o, Response response) {
                invoker.dataChanged();
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
