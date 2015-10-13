package com.edonoxako.studyscheduler.app.factories;

import com.edonoxako.studyscheduler.app.Config;
import com.edonoxako.studyscheduler.app.ResultDataInvoker;
import com.edonoxako.studyscheduler.app.api.RetrofitGroupApi;
import com.edonoxako.studyscheduler.app.api.RetrofitLecturerApi;
import com.edonoxako.studyscheduler.app.group.groupcreate.GroupCreateFragment;
import com.edonoxako.studyscheduler.app.group.groupcreate.GroupCreatePresenter;
import com.edonoxako.studyscheduler.app.lecturer.createlecturer.LecturerCreateFragment;
import com.edonoxako.studyscheduler.app.lecturer.createlecturer.LecturerCreatePresenter;

import retrofit.RestAdapter;

/**
 * Created by Евгений on 13.10.2015.
 */
public class EditingFragmentFactory {

    private static RestAdapter createRestAdapter() {
        return new RestAdapter.Builder()
                .setEndpoint(Config.BASE_URL)
                .build();
    }

    public static GroupCreateFragment createGroupCreateFragment(ResultDataInvoker invoker) {

        GroupCreateFragment fragment = new GroupCreateFragment();

        RetrofitGroupApi groupApi = createRestAdapter().create(RetrofitGroupApi.class);
        GroupCreatePresenter presenter = new GroupCreatePresenter(groupApi, invoker);

        fragment.bindPresenter(presenter);
        presenter.bindFragment(fragment);

        return fragment;
    }

    public static LecturerCreateFragment createLecturerCreateFragment(ResultDataInvoker invoker) {

        LecturerCreateFragment fragment = new LecturerCreateFragment();

        RetrofitLecturerApi groupApi = createRestAdapter().create(RetrofitLecturerApi.class);
        LecturerCreatePresenter presenter = new LecturerCreatePresenter(groupApi, invoker);

        fragment.bindPresenter(presenter);
        presenter.bindFragment(fragment);

        return fragment;

    }

}
