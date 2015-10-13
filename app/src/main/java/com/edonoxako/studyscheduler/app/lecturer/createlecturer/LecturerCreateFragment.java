package com.edonoxako.studyscheduler.app.lecturer.createlecturer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.edonoxako.studyscheduler.app.R;

/**
 * Created by Евгений on 13.10.2015.
 */
public class LecturerCreateFragment extends Fragment{

    private LecturerCreatePresenter presenter;
    private EditText lecturerFirstName;
    private EditText lecturerLastName;
    private EditText lecturerPatronymic;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lecturer_create, null, false);

        lecturerFirstName = (EditText) view.findViewById(R.id.lecturerFrirstNameEdit);
        lecturerLastName = (EditText) view.findViewById(R.id.lecturerLastNameEdit);
        lecturerPatronymic = (EditText) view.findViewById(R.id.lecturerPatronymicEdit);

        Button saveLecturerBtn = (Button) view.findViewById(R.id.saveLecturerBtn);

        saveLecturerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.saveChanges();
            }
        });

        return view;
    }

    public void bindPresenter(LecturerCreatePresenter presenter) {
        this.presenter = presenter;
    }

    public String getLecturerFirstName() {
        return lecturerFirstName.getText().toString();
    }

    public String getLecturerLastName() {
        return lecturerLastName.getText().toString();
    }

    public String getLecturerPatronymic() {
        return lecturerPatronymic.getText().toString();
    }
}
