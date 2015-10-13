package com.edonoxako.studyscheduler.app.factories;

import android.content.Context;

import com.edonoxako.studyscheduler.app.Config;
import com.edonoxako.studyscheduler.app.abstractions.BaseFragment;
import com.edonoxako.studyscheduler.app.api.RetrofitGroupApi;
import com.edonoxako.studyscheduler.app.api.RetrofitLecturerApi;
import com.edonoxako.studyscheduler.app.group.groupdescription.GroupDescriptionFragment;
import com.edonoxako.studyscheduler.app.group.groupdescription.GroupDescriptionPresenter;
import com.edonoxako.studyscheduler.app.lecturer.lecturerdescription.LecturerDescriptionFragment;
import com.edonoxako.studyscheduler.app.lecturer.lecturerdescription.LecturerDescriptionPresenter;

import retrofit.RestAdapter;

/**
 * Created by Евгений on 13.10.2015.
 */
public class DescriptionFragmentFactory {

    public static BaseFragment createGroupDescriptionFragment(Context context, long id) {
        GroupDescriptionFragment fragment = new GroupDescriptionFragment();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Config.BASE_URL)
                .build();

        RetrofitGroupApi groupApi = restAdapter.create(RetrofitGroupApi.class);
        GroupDescriptionPresenter presenter = new GroupDescriptionPresenter(id, groupApi);

        presenter.bindFragment(fragment);
        fragment.bindPresenter(presenter);

        return fragment;
    }

    public static BaseFragment createLecturerDescriptionFragment(Context context, long id) {
        LecturerDescriptionFragment fragment = new LecturerDescriptionFragment();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Config.BASE_URL)
                .build();

        RetrofitLecturerApi lecturerApi = restAdapter.create(RetrofitLecturerApi.class);
        LecturerDescriptionPresenter presenter = new LecturerDescriptionPresenter(id, lecturerApi);

        fragment.bindPresenter(presenter);
        presenter.bindFragment(fragment);

        return fragment;
    }

}
