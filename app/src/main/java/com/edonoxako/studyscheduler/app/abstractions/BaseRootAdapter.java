package com.edonoxako.studyscheduler.app.abstractions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.edonoxako.studyscheduler.app.R;

import java.util.List;
import java.util.Objects;

/**
 * Created by Евгений on 12.10.2015.
 */
public abstract class BaseRootAdapter extends BaseAdapter {

    protected List listData;
    protected LayoutInflater inflater;

    public BaseRootAdapter(Context context) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setListData(List listData) {
        this.listData = listData;
    }

    @Override
    public int getCount() {
        return (listData != null ? listData.size() : 0);
    }

    @Override
    public Object getItem(int position) {
        return (listData != null ? listData.get(position) : null);
    }

    @Override
    abstract public long getItemId(int position);

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view = convertView;
        if (view == null) {
            view = createItemView();
        }
        return populateView(position, view);
    };

    protected abstract View createItemView();

    protected abstract View populateView(int position, View targetView);
}
