package com.edonoxako.studyscheduler.app.abstractions;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.View;

import java.util.List;

/**
 * Created by Евгений on 12.10.2015.
 */
public abstract class BaseFragment extends Fragment {

    protected SimplePresenter presenter;

    public void bindPresenter(SimplePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.init();
    }
}
