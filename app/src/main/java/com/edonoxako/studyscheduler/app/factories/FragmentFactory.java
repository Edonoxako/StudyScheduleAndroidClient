package com.edonoxako.studyscheduler.app.factories;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.edonoxako.studyscheduler.app.Config;
import com.edonoxako.studyscheduler.app.services.Router;
import com.edonoxako.studyscheduler.app.abstractions.BaseListFragment;
import com.edonoxako.studyscheduler.app.api.GroupApi;
import com.edonoxako.studyscheduler.app.api.RetrofitGroupApi;
import com.edonoxako.studyscheduler.app.api.RetrofitLecturerApi;
import com.edonoxako.studyscheduler.app.api.SubjectApi;
import com.edonoxako.studyscheduler.app.services.Viewer;
import com.edonoxako.studyscheduler.app.group.grouplist.GroupListAdapter;
import com.edonoxako.studyscheduler.app.group.grouplist.GroupListFragment;
import com.edonoxako.studyscheduler.app.group.grouplist.GroupListPresenter;
import com.edonoxako.studyscheduler.app.lecturer.rootlist.RootListAdapter;
import com.edonoxako.studyscheduler.app.lecturer.rootlist.RootListFragment;
import com.edonoxako.studyscheduler.app.lecturer.rootlist.RootListPresenter;
import com.edonoxako.studyscheduler.app.subject.subjectlist.SubjectListAdapter;
import com.edonoxako.studyscheduler.app.subject.subjectlist.SubjectListFragment;
import com.edonoxako.studyscheduler.app.subject.subjectlist.SubjectListPresenter;

import retrofit.RestAdapter;

/**
 * Created by Евгений on 13.10.2015.
 */
public class FragmentFactory {

    public static BaseListFragment createRootListFragment(AppCompatActivity activity) {
        RootListFragment fragment = new RootListFragment();
        RootListAdapter adapter = new RootListAdapter(activity);
        fragment.setAdapter(adapter);

        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(Config.BASE_URL).build();
        RetrofitLecturerApi api = restAdapter.create(RetrofitLecturerApi.class);
        Router router = new Router(activity);

        RootListPresenter presenter = new RootListPresenter(api, router);

        fragment.bindPresenter(presenter);
        presenter.bindFragment(fragment);

        return fragment;
    }

    public static BaseListFragment createGroupListFragment(AppCompatActivity activity) {
        GroupListFragment fragment = new GroupListFragment();
        GroupListAdapter adapter = new GroupListAdapter(activity);
        fragment.setAdapter(adapter);

        GroupApi api = new GroupApi();
        Viewer viewer = new Viewer(activity);
        Router router = new Router(activity);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Config.BASE_URL)
                .build();

        RetrofitGroupApi groupApi = restAdapter.create(RetrofitGroupApi.class);
        GroupListPresenter presenter = new GroupListPresenter(viewer, api, groupApi, router);

        fragment.bindPresenter(presenter);
        presenter.bindFragment(fragment);

        return fragment;
    }

    public static BaseListFragment createSubjectListFragment(Context context) {
        SubjectListFragment fragment = new SubjectListFragment();
        SubjectListAdapter adapter = new SubjectListAdapter(context);
        fragment.setAdapter(adapter);

        SubjectApi api = new SubjectApi();
        Viewer viewer = new Viewer(context);
        SubjectListPresenter presenter = new SubjectListPresenter(api, viewer);

        fragment.bindPresenter(presenter);
        presenter.bindFragment(fragment);

        return fragment;
    }

}
