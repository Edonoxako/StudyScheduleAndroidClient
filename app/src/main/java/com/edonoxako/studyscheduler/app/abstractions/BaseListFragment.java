package com.edonoxako.studyscheduler.app.abstractions;


import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.edonoxako.studyscheduler.app.R;

import java.util.List;

/**
 * Created by Евгений on 13.10.2015.
 */
public abstract class BaseListFragment extends ListFragment {

    protected BasePresenter presenter;
    protected BaseRootAdapter adapter;

    public void bindPresenter(BasePresenter presenter) {
        this.presenter = presenter;
    }

    public void setAdapter(BaseRootAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(adapter);
        presenter.init();
    }

    public void setData(List items) {
        adapter.setListData(items);
        adapter.notifyDataSetChanged();
    }

    public void updateData() {
        presenter.init();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_base, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    abstract public boolean onOptionsItemSelected(MenuItem item);
}
