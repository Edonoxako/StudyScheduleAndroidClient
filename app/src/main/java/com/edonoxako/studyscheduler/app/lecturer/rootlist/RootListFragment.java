package com.edonoxako.studyscheduler.app.lecturer.rootlist;

import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.edonoxako.studyscheduler.app.abstractions.BaseListFragment;

/**
 * Created by Евгений on 12.10.2015.
 */
public class RootListFragment extends BaseListFragment {

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if (presenter != null) {
            ((RootListPresenter) presenter).showLecturerDescription(id);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        ((RootListPresenter) presenter).createNewLecturer();
        return false;
    }
}
