package com.edonoxako.studyscheduler.app.group.groupcreate;

import com.edonoxako.studyscheduler.app.ResultDataInvoker;
import com.edonoxako.studyscheduler.app.api.RetrofitGroupApi;
import com.edonoxako.studyscheduler.app.model.Group;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Евгений on 13.10.2015.
 */
public class GroupCreatePresenter {

    private GroupCreateFragment fragment;

    private RetrofitGroupApi api;
    private ResultDataInvoker invoker;

    public GroupCreatePresenter(RetrofitGroupApi api, ResultDataInvoker invoker) {
        this.api = api;
        this.invoker = invoker;
    }

    public void bindFragment(GroupCreateFragment fragment) {
        this.fragment = fragment;
    }

    public void saveChanges() {
        String groupNumber = fragment.getGroupNumber();
        String groupInst = fragment.getGroupInst();
        Group group = new Group(groupNumber, groupInst);
        api.createGroup(group, new Callback() {
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
