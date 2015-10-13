package com.edonoxako.studyscheduler.app;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.edonoxako.studyscheduler.app.abstractions.BaseListFragment;
import com.edonoxako.studyscheduler.app.factories.FragmentFactory;

/**
 * Created by Евгений on 12.10.2015.
 */
public class BasePagerAdapter extends FragmentStatePagerAdapter {

    private AppCompatActivity activity;

    public BasePagerAdapter( AppCompatActivity activity, FragmentManager fm) {
        super(fm);
        this.activity = activity;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return FragmentFactory.createRootListFragment(activity);
        } else if (position == 1) {
            return FragmentFactory.createGroupListFragment(activity);
        } else {
            return FragmentFactory.createSubjectListFragment(activity);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    public void onDataChanged() {
        for (int i = 0; i < getCount(); i++) {
            ((BaseListFragment) getItem(i)).updateData();
        }
    }
}
