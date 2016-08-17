package com.dexterous.genero15.events;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.dexterous.genero15.R;
import com.dexterous.genero15.font.Audiowide_Regular;
import com.dexterous.genero15.util.GetResources;
import com.squareup.picasso.Picasso;

/**
 * Created by piyush on 9/23/15.
 */
public class CustomAdapterClubEvent extends BaseAdapter {

    Context context;
    String club[];
    private static LayoutInflater inflater = null;

    String clubArrayForXml[] = {"cultural", "cs", "ec", "literary", "me", "special", "ce",
            "informals", "drama", "gaming"};

    public CustomAdapterClubEvent(Context context, String club[]) {
        this.context = context;
        this.club = club;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return clubArrayForXml.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView = convertView;
        if (rowView == null) {
            rowView = inflater.inflate(R.layout.event_list, null);
        }
        holder.img = (ImageView) rowView.findViewById(R.id.imageView1);
        holder.textView = (Audiowide_Regular) rowView.findViewById(R.id.description);
//        holder.img.setImageResource(imageId[position]);
        Picasso.with(context).load(GetResources.getStringFromXml(context, "url_", clubArrayForXml[position])).into(holder.img);
        holder.textView.setText(club[position]);
        return rowView;
    }

    public class Holder {
        Audiowide_Regular textView;
        ImageView img;
    }


}

