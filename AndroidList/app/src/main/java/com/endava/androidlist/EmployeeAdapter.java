package com.endava.androidlist;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amihaescu on 8/26/2016.
 */
public class EmployeeAdapter extends ArrayAdapter<Employee> {

    private LayoutInflater mInflater;

    public EmployeeAdapter(Context context, List<Employee> list) {
        super(context, R.layout.item_employee, list);
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_employee, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.iv_image);
            viewHolder.nameView = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.positionView = (TextView) convertView.findViewById(R.id.tv_position);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Employee employee = getItem(position);
        viewHolder.nameView.setText(employee.getName());
        viewHolder.positionView.setText(employee.getPosition());
        return convertView;
    }

    /**
     * A {@link ViewHolder} object stores each of the component views inside the tag field of the Layout,
     * so you can immediately access them without the need to look them up repeatedly.
     */
    static class ViewHolder {
        public ImageView imageView;
        public TextView nameView;
        public TextView positionView;
    }
}
