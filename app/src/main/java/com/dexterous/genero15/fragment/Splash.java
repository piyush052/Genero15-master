package com.dexterous.genero15.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dexterous.genero15.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Splash extends Fragment {

    static Context _context;

    public Splash() {
        // Required empty public constructor
    }

    public static Splash instantiate(Context context) {
        Splash fragment = new Splash();
        _context = context;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_splash, container, false);

        return rootView;
    }

}
