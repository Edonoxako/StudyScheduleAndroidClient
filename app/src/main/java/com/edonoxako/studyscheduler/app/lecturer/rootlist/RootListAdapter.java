package com.edonoxako.studyscheduler.app.lecturer.rootlist;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.edonoxako.studyscheduler.app.abstractions.BaseRootAdapter;
import com.edonoxako.studyscheduler.app.R;
import com.edonoxako.studyscheduler.app.model.Lecturer;

/**
 * Created by Евгений on 12.10.2015.
 */
public class RootListAdapter extends BaseRootAdapter {

    public RootListAdapter(Context context) {
        super(context);
    }

    @Override
    public long getItemId(int position) {
        return ((Lecturer) getItem(position)).getId();
    }

    @Override
    protected View createItemView() {
        return inflater.inflate(R.layout.root_list_item, null, false);
    }

    @Override
    protected View populateView(int position, View targetView) {
        Lecturer lecturer = (Lecturer) getItem(position);
        ((TextView) targetView.findViewById(R.id.lastNameItemView)).setText(lecturer.getLastName());
        return targetView;
    }

}
