package com.edonoxako.studyscheduler.app.group.grouplist;

import com.edonoxako.studyscheduler.app.services.Router;
import com.edonoxako.studyscheduler.app.abstractions.BaseListFragment;
import com.edonoxako.studyscheduler.app.abstractions.ListPresenter;
import com.edonoxako.studyscheduler.app.model.Group;
import com.edonoxako.studyscheduler.app.api.GroupApi;
import com.edonoxako.studyscheduler.app.api.RetrofitGroupApi;
import com.edonoxako.studyscheduler.app.services.Viewer;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Евгений on 12.10.2015.
 */
public class GroupListPresenter implements ListPresenter {

    private GroupListFragment fragment;

    private GroupApi api;
    private Viewer viewer;
    private RetrofitGroupApi retrofitGroupApi;
    private Router router;

    public GroupListPresenter(Viewer viewer, GroupApi api, RetrofitGroupApi retrofitGroupApi, Router router) {
        this.api = api;
        this.viewer = viewer;
        this.retrofitGroupApi = retrofitGroupApi;
        this.router = router;
    }

    @Override
    public void init() {

        retrofitGroupApi.fetchAllGroups(new Callback<List<Group>>() {
            @Override
            public void success(List<Group> groups, Response response) {
                fragment.setData(groups);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });

    }

    @Override
    public void bindFragment(BaseListFragment fragment) {
        this.fragment = (GroupListFragment) fragment;
    }

    public void showGroups(long id) {
        retrofitGroupApi.fetchGroup(id, new Callback<Group>() {
            @Override
            public void success(Group group, Response response) {
                viewer.viewText(group.toString());
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    public void showDescription(long id) {
        router.goToGroupDescription(id);
    }

    public void createNewGroup() {
        router.goToGroupCreating();
    }
}
