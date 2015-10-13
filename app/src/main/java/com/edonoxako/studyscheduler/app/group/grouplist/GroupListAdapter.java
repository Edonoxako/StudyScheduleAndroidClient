package com.edonoxako.studyscheduler.app.group.grouplist;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.edonoxako.studyscheduler.app.abstractions.BaseRootAdapter;
import com.edonoxako.studyscheduler.app.R;
import com.edonoxako.studyscheduler.app.model.Group;

/**
 * Created by Евгений on 12.10.2015.
 */
public class GroupListAdapter extends BaseRootAdapter {

    public GroupListAdapter(Context context) {
        super(context);
    }

    @Override
    public long getItemId(int position) {
        return ((Group) getItem(position)).getId();
    }

    @Override
    protected View createItemView() {
        return inflater.inflate(R.layout.group_list_item, null, false);
    }

    @Override
    protected View populateView(int position, View targetView) {
        Group itemGroup = (Group) getItem(position);
        ((TextView) targetView.findViewById(R.id.groupNumberView)).setText(itemGroup.getNumber());
        ((TextView) targetView.findViewById(R.id.groupInstituteView)).setText(itemGroup.getInstitute());
        return targetView;
    }
}
