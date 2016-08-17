package com.dexterous.genero15.events;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.dexterous.genero15.R;

/**
 * Created by mayank on 9/23/15.
 */
public class CustomAdapterEvents extends BaseAdapter {

    Activity context;
    int[] imageId;
    private static LayoutInflater inflater = null;

    public CustomAdapterEvents(Activity eventList, int[] prgmImages) {
        context = eventList;
        imageId = prgmImages;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return imageId.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder {
        ImageView img;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView = convertView;
        if (rowView == null) {
            rowView = inflater.inflate(R.layout.event_list_row, null);
        }
        holder.img = (ImageView) rowView.findViewById(R.id.imageView1);
        holder.img.setImageResource(imageId[position]);
        return rowView;
    }
}

