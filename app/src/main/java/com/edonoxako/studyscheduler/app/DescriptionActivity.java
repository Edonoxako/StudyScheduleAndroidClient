package com.edonoxako.studyscheduler.app;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.edonoxako.studyscheduler.app.abstractions.BaseFragment;
import com.edonoxako.studyscheduler.app.factories.DescriptionFragmentFactory;
import com.edonoxako.studyscheduler.app.factories.EditingFragmentFactory;

import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by Евгений on 13.10.2015.
 */
public class DescriptionActivity extends AppCompatActivity implements ResultDataInvoker {

    public static final String DESCRIPTION = "DescriptionActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descritpion);

        Intent intent = getIntent();
        Fragment fragment = null;

        int type = intent.getIntExtra(Constants.DESCRIPTION_TYPE, -1);
        long id = intent.getLongExtra(Constants.DESCRIPTION_ID_EXTRA, -1);

        if (type == Constants.GROUP_DESCRIPTION) {
            fragment = DescriptionFragmentFactory.createGroupDescriptionFragment(this, id);
        } else if (type == Constants.LECTURER_DESCRIPTION) {
            fragment = DescriptionFragmentFactory.createLecturerDescriptionFragment(this, id);
        } else if (type == Constants.GROUP_CREATING) {
            fragment = EditingFragmentFactory.createGroupCreateFragment(this);
        } else if (type == Constants.LECTURER_CREATING) {
            fragment = EditingFragmentFactory.createLecturerCreateFragment(this);
        }

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentContainer, fragment)
                .commit();
    }


    @Override
    public void dataChanged() {
        setResult(Constants.RESULT_CHANGED);
        finish();
    }

    @Override
    public void dataNotChanged() {
        setResult(Constants.RESULT_NOT_CHANGED);
        finish();
    }
}
