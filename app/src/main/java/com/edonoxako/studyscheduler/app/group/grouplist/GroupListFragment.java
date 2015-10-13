package com.edonoxako.studyscheduler.app.group.grouplist;

import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.edonoxako.studyscheduler.app.abstractions.BaseListFragment;

/**
 * Created by Евгений on 12.10.2015.
 */
public class GroupListFragment extends BaseListFragment {

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        ((GroupListPresenter) presenter).showDescription(id);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        ((GroupListPresenter) presenter).createNewGroup();
        return true;
    }
}
