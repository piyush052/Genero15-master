package com.dexterous.genero15.events;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.dexterous.genero15.R;
import com.dexterous.genero15.font.Audiowide_Regular;

/**
 * Created by mayank on 9/23/15.
 */
public class CustomAdapterEventsOffLine extends BaseAdapter {

    Context context;
    String[] imageId;
    private static LayoutInflater inflater = null;

    public CustomAdapterEventsOffLine(Context context, String[] prgmImages) {
        this.context = context;
        imageId = prgmImages;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return imageId.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder = new Holder();
        View rowView = view;
        if (rowView == null) {
            rowView = inflater.inflate(R.layout.event_list_off_line, null);
        }
        holder.eventName = (Audiowide_Regular) rowView.findViewById(R.id.club_name);
        holder.eventName.setText(imageId[i]);
        return rowView;
    }

    public class Holder {

        Audiowide_Regular eventName;
    }


}

