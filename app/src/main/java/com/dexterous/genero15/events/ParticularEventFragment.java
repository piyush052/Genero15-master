package com.dexterous.genero15.events;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dexterous.genero15.EventActivity;
import com.dexterous.genero15.R;
import com.dexterous.genero15.font.Roboto_Light;
import com.dexterous.genero15.util.GetResources;

/**
 * Created by piyush on 9/23/15.
 */
public class ParticularEventFragment extends android.support.v4.app.Fragment {


    static int clubIndex;
    static int eventIndex;

    public static ParticularEventFragment newInstance(int clubIndex, int eventIndex) {
        ParticularEventFragment.clubIndex = clubIndex;
        ParticularEventFragment.eventIndex = eventIndex;
        return new ParticularEventFragment();
    }


    String data;
    static Roboto_Light event_detais;
    static Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_partcular_event, container, false);
        event_detais = (Roboto_Light) rootView.findViewById(R.id.event_detais);
        context = getActivity();
        repalce(0);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String p = "phot";
        String image = p + data;
//        ImageView img = (ImageView) getActivity().findViewById(R.id.imageView);
//        int resId = getResources().getIdentifier(image, "drawable", "genero.dexterous.com.contextmenu1");
//        img.setImageResource(resId);
    }

    //TODO
    static public void repalce(int id) {
        String data[] = GetResources.getStringArrayFromXml(context, EventActivity.clubArrayForXml[clubIndex] + "_", Integer.toString(eventIndex + 1));
        event_detais.setText("");
        event_detais.setText(data[id]);
    }
}
