package com.edonoxako.studyscheduler.app.group.groupcreate;

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
public class GroupCreateFragment extends Fragment {

    private GroupCreatePresenter presenter;
    private EditText groupNumber;
    private EditText groupInst;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.group_create, null, false);

        groupNumber = (EditText) view.findViewById(R.id.groupNumberEdit);
        groupInst = (EditText) view.findViewById(R.id.groupInstEdit);
        Button buttonCreate = (Button) view.findViewById(R.id.buttonCreate);

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.saveChanges();
            }
        });

        return view;
    }

    public void bindPresenter(GroupCreatePresenter presenter) {
        this.presenter = presenter;
    }

    public String getGroupNumber() {
        return groupNumber.getText().toString();
    }

    public String getGroupInst() {
        return groupInst.getText().toString();
    }
}
