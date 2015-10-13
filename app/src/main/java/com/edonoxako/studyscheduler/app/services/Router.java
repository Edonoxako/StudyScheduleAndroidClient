package com.edonoxako.studyscheduler.app.services;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.edonoxako.studyscheduler.app.Constants;
import com.edonoxako.studyscheduler.app.DescriptionActivity;

/**
 * Created by Евгений on 13.10.2015.
 */
public class Router {

    private AppCompatActivity activity;

    public Router(AppCompatActivity activity) {
        this.activity = activity;
    }

    private void performTransition(long id, int type) {
        Intent intent = new Intent(activity, DescriptionActivity.class);
        intent.putExtra(Constants.DESCRIPTION_TYPE, type);
        intent.putExtra(Constants.DESCRIPTION_ID_EXTRA, id);
        activity.startActivity(intent);
    }

    private void performTransactionWithResult(int requestCode, int type) {
        Intent intent = new Intent(activity, DescriptionActivity.class);
        intent.putExtra(Constants.DESCRIPTION_TYPE, type);
        activity.startActivityForResult(intent, requestCode);
    }

    public void goToGroupDescription(long id) {
        performTransition(id, Constants.GROUP_DESCRIPTION);
    }

    public void goToLecturerDescription(long id) {
        performTransition(id, Constants.LECTURER_DESCRIPTION);
    }

    public void goToGroupCreating() {
        performTransactionWithResult(Constants.CREATE_GROUP_REQUEST, Constants.GROUP_CREATING);
    }

    public void goToLecturerCreating() {
        performTransactionWithResult(Constants.CREATE_LECTURER_REQUEST, Constants.LECTURER_CREATING);
    }
}
