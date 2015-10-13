package com.edonoxako.studyscheduler.app.subject.subjectlist;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.edonoxako.studyscheduler.app.R;
import com.edonoxako.studyscheduler.app.abstractions.BaseRootAdapter;
import com.edonoxako.studyscheduler.app.model.Subject;

/**
 * Created by Евгений on 13.10.2015.
 */
public class SubjectListAdapter extends BaseRootAdapter {
    public SubjectListAdapter(Context context) {
        super(context);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    protected View createItemView() {
        return inflater.inflate(R.layout.subject_list_item, null, false);
    }

    @Override
    protected View populateView(int position, View targetView) {
        Subject subject = (Subject) getItem(position);
        ((TextView) targetView.findViewById(R.id.subjectNameView)).setText(subject.getName());
        return targetView;
    }
}
