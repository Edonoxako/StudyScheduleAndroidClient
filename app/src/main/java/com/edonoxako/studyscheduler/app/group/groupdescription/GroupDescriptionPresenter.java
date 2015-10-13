package com.edonoxako.studyscheduler.app.group.groupdescription;

import android.util.Log;

import com.edonoxako.studyscheduler.app.abstractions.BaseFragment;
import com.edonoxako.studyscheduler.app.abstractions.SimplePresenter;
import com.edonoxako.studyscheduler.app.model.Group;
import com.edonoxako.studyscheduler.app.api.RetrofitGroupApi;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Евгений on 13.10.2015.
 */
public class GroupDescriptionPresenter implements SimplePresenter {

    private GroupDescriptionFragment fragment;

    private long id;

    private RetrofitGroupApi api;

    public GroupDescriptionPresenter(long id, RetrofitGroupApi api) {
        this.id = id;
        this.api = api;
    }

    @Override
    public void init() {
        api.fetchGroup(id, new Callback<Group>() {
            @Override
            public void success(Group group, Response response) {
                Log.d("Dsc fragment", group.toString());
                fragment.setData(group);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    @Override
    public void bindFragment(BaseFragment fragment) {
        this.fragment = (GroupDescriptionFragment) fragment;
    }

}
