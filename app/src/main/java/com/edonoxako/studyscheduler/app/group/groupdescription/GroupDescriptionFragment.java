package com.edonoxako.studyscheduler.app.group.groupdescription;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.edonoxako.studyscheduler.app.R;
import com.edonoxako.studyscheduler.app.abstractions.BaseFragment;
import com.edonoxako.studyscheduler.app.model.Group;

/**
 * Created by Евгений on 13.10.2015.
 */
public class GroupDescriptionFragment extends BaseFragment {

    private TextView groupInstView;
    private TextView groupNumberView;
    private TextView groupIdView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.group_description, null, false);

        groupNumberView = (TextView) view.findViewById(R.id.groupNameView);
        groupInstView = (TextView) view.findViewById(R.id.groupInstView);
        groupIdView = (TextView) view.findViewById(R.id.groupIdView);

        return view;
    }

    public void setData(Group group) {
        groupNumberView.setText(group.getNumber());
        groupInstView.setText(group.getInstitute());
        groupIdView.setText(group.getId() + "");
    }
}
