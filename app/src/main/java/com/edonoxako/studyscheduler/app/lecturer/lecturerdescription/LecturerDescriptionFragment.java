package com.edonoxako.studyscheduler.app.lecturer.lecturerdescription;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.edonoxako.studyscheduler.app.R;
import com.edonoxako.studyscheduler.app.abstractions.BaseFragment;
import com.edonoxako.studyscheduler.app.model.Lecturer;

/**
 * Created by Евгений on 13.10.2015.
 */
public class LecturerDescriptionFragment extends BaseFragment {

    private TextView lastNameView;
    private TextView firstNameView;
    private TextView patronymicView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lecturer_description, null, false);

        lastNameView = (TextView) view.findViewById(R.id.lastNameView);
        firstNameView = (TextView) view.findViewById(R.id.firstNameView);
        patronymicView = (TextView) view.findViewById(R.id.patronymicView);

        return view;
    }

    public void setData(Lecturer lecturer) {

        Log.d("Lecturer", lecturer.toString());

        lastNameView.setText(lecturer.getLastName());
        firstNameView.setText(lecturer.getFirstName());
        patronymicView.setText(lecturer.getPatronymic());
    }
}
