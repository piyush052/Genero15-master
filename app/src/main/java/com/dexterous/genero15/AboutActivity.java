package com.dexterous.genero15;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.desarrollodroide.twopanels.TwoPanelsBaseActivity;

import com.dexterous.genero15.about.MyLeftFragment;
import com.dexterous.genero15.about.MyRightFragment;


public class AboutActivity extends TwoPanelsBaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseOrientation(LinearLayout.HORIZONTAL);
        MyRightFragment mRightFragment = new MyRightFragment();
        MyLeftFragment mLeftFragment = new MyLeftFragment();
        getFragmentManager().beginTransaction().add(R.id.right, mRightFragment).commit();
        getFragmentManager().beginTransaction().add(R.id.left, mLeftFragment).commit();
    }

}
