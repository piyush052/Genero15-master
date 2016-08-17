package com.dexterous.genero15;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.dexterous.genero15.fragment.EnterCouponCode;
import com.dexterous.genero15.fragment.Splash;
import com.dexterous.genero15.util.SharedPreferencesProvider;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends FragmentActivity {

    private static final int SPLASH_SCREEN_DISPLAY_TIME = 1500;
    static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        updateFirstFragment(this);

    }

    private static void updateFirstFragment(Context context) {
        boolean firstRun = SharedPreferencesProvider.isFirstRun(context);
        if (firstRun) {
            ((FragmentManager) ((FragmentActivity) context).getSupportFragmentManager()).beginTransaction()
                    .replace(R.id.container, EnterCouponCode.instantiate(context))
                    .commit();
//            Timer t = new Timer();
//            t.schedule(new splash(), SPLASH_SCREEN_DISPLAY_TIME);
        } else {
            ((FragmentManager) ((FragmentActivity) context).getSupportFragmentManager()).beginTransaction()
                    .replace(R.id.container, Splash.instantiate(context))
                    .commit();
            Timer t = new Timer();
            t.schedule(new splash(), SPLASH_SCREEN_DISPLAY_TIME);
        }
    }

    static class splash extends TimerTask {
        @Override
        public void run() {
            Intent i = new Intent(context, DiscrollViewActivity.class);
            ((Activity) context).finish();
            context.startActivity(i);
        }
    }
}
