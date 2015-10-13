package com.edonoxako.studyscheduler.app.services;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Евгений on 13.10.2015.
 */
public class Viewer {

    Context context;

    public Viewer(Context context) {
        this.context = context;
    }

    public void viewText(String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

}
