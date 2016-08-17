package com.dexterous.genero15;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;


public class Developers extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);
        Transformation transformation = new RoundedTransformationBuilder()
                .borderColor(Color.BLACK)
                .borderWidthDp(3)
                .cornerRadiusDp(30)
                .oval(true)
                .build();

        ImageView imageView = (ImageView) findViewById(R.id.imageView_KARTIK);
        Picasso.with(this)
                .load("http://s19.postimg.org/ice0yt37n/IMG_20150602_120707228.jpg")
                .fit()
                .transform(transformation)
                .into(imageView);
        ImageView imageView2 = (ImageView) findViewById(R.id.imageView_MAYANK);
        Picasso.with(this)
                .load("http://genero15.com/images/mm/team-5.png")
                .fit()
                .transform(transformation)
                .into(imageView2);
        ImageView imageView3 = (ImageView) findViewById(R.id.imageView_MUDIT);
        Picasso.with(this)
                .load("http://s19.postimg.org/6oxr9hi83/Ao_ATE4ii34z_Mc_TXhe92z_H1e_BMscg_Ny_RYMe_FBDWE02a_U.jpg")
                .fit()
                .transform(transformation)
                .into(imageView3);
        ImageView imageView4 = (ImageView) findViewById(R.id.imageView_PIYUSH);
        Picasso.with(this)
                .load("http://s19.postimg.org/kprdc2s8z/IMAG0628_4.jpg")
                .fit()
                .transform(transformation)
                .into(imageView4);
        ImageView imageView5 = (ImageView) findViewById(R.id.imageView_PRAKHAR);
        Picasso.with(this)
                .load("http://genero15.com/images/mm/team-7.jpg")
                .fit()
                .transform(transformation)
                .into(imageView5);

        ImageView kartik_fb = (ImageView) findViewById(R.id.kartik_fb);
        kartik_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.facebook.com/kartik.agarwal.01"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        ImageView mayank_fb = (ImageView) findViewById(R.id.mayank_fb);
        mayank_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.facebook.com/mayankbaiswar.3"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        ImageView mudit_fb = (ImageView) findViewById(R.id.mudit_fb);
        mudit_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.facebook.com/mani.gupta.927"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        ImageView piyush_fb = (ImageView) findViewById(R.id.piyush_fb);
        piyush_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.facebook.com/piyush052"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        ImageView prakhar_fb = (ImageView) findViewById(R.id.prakhar_fb);
        prakhar_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.facebook.com/prakhar.tiwari.9678"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }


}







