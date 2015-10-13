package com.edonoxako.studyscheduler.app.subject.subjectlist;

import com.edonoxako.studyscheduler.app.abstractions.BaseListFragment;
import com.edonoxako.studyscheduler.app.abstractions.ListPresenter;
import com.edonoxako.studyscheduler.app.api.SubjectApi;
import com.edonoxako.studyscheduler.app.services.Viewer;

import java.util.List;

/**
 * Created by Евгений on 13.10.2015.
 */
public class SubjectListPresenter implements ListPresenter {

    private SubjectListFragment fragment;

    private SubjectApi api;
    private Viewer viewer;

    public SubjectListPresenter(SubjectApi api, Viewer viewer) {
        this.api = api;
        this.viewer = viewer;
    }

    @Override
    public void init() {
        List items = api.fetchSubjects();
        fragment.setData(items);
    }

    @Override
    public void bindFragment(BaseListFragment fragment) {
        this.fragment = (SubjectListFragment) fragment;
    }
}
