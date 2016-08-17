package com.dexterous.genero15.about;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.desarrollodroide.twopanels.RightFragment;
import com.dexterous.genero15.R;
import com.squareup.picasso.Picasso;

public class MyRightFragment extends RightFragment {


    ImageView unrevel_the_egmia;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        LinearLayout linear = new LinearLayout(getActivity());
        LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rootView = layoutInflater.inflate(R.layout.myright_fragment, linear, true);
        unrevel_the_egmia = (ImageView) rootView.findViewById(R.id.unrevel_the_egmia);
        LinearLayout linearInParent = (LinearLayout) mContainer.findViewById(R.id.linearRight);
        linearInParent.addView(linear);
        Picasso.with(getActivity()).load("http://s19.postimg.org/ofs74y4xv/unravel_the_ebigma.jpg").into(unrevel_the_egmia);
        return this.mContainer;
    }
}
