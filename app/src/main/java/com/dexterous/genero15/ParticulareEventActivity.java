package com.dexterous.genero15;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.dexterous.genero15.events.ParticularEventFragment;
import com.yalantis.contextmenu.lib.ContextMenuDialogFragment;
import com.yalantis.contextmenu.lib.MenuObject;
import com.yalantis.contextmenu.lib.MenuParams;
import com.yalantis.contextmenu.lib.interfaces.OnMenuItemClickListener;
import com.yalantis.contextmenu.lib.interfaces.OnMenuItemLongClickListener;

import java.util.ArrayList;
import java.util.List;


public class ParticulareEventActivity extends AppCompatActivity implements OnMenuItemClickListener,
        OnMenuItemLongClickListener {
    private android.support.v4.app.FragmentManager fragmentManager;
    private ContextMenuDialogFragment mMenuDialogFragment;
    int clubIndex;
    int eventIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_particulare_event);
        Bundle bundle = getIntent().getExtras();

        if (bundle == null) {
            return;
        }

        clubIndex = bundle.getInt(ClubActivity.CLUB_INDEX);
        eventIndex = bundle.getInt(EventActivity.EVENT_INDEX);

        fragmentManager = getSupportFragmentManager();

        initToolbar();
        initMenuFragment();
        addFragment(ParticularEventFragment.newInstance(clubIndex, eventIndex), true, R.id.container);

    }
//
//    /*private void sendData(String str) {
//        //FragmentManager fragmentManager1=getFragmentManager();
//        MainFragment b;
//        b = (MainFragment)fragmentManager.findFragmentById(R.id.fragment);
//        b.change(str);
//
//    }*/


    private void initMenuFragment() {
        MenuParams menuParams = new MenuParams();
        menuParams.setActionBarSize((int) getResources().getDimension(R.dimen.tool_bar_height));
        menuParams.setMenuObjects(getMenuObjects());
        menuParams.setClosableOutside(false);
        mMenuDialogFragment = ContextMenuDialogFragment.newInstance(menuParams);
    }

    private List<MenuObject> getMenuObjects() {
        List<MenuObject> menuObjects = new ArrayList<>();

        MenuObject close = new MenuObject();
        close.setResource(R.drawable.icn_close);

        MenuObject send = new MenuObject("Description");
        send.setResource(R.drawable.icn_1);

        MenuObject like = new MenuObject("Rules");
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.icn_2);
        like.setBitmap(b);

        MenuObject addFr = new MenuObject("Timing");
        BitmapDrawable bd = new BitmapDrawable(getResources(),
                BitmapFactory.decodeResource(getResources(), R.drawable.icn_3));
        addFr.setDrawable(bd);

        MenuObject addFav = new MenuObject("Venue");
        addFav.setResource(R.drawable.icn_4);

        MenuObject block = new MenuObject("Event Organizers");
        block.setResource(R.drawable.icn_5);

        menuObjects.add(close);
        menuObjects.add(send);
        menuObjects.add(like);
        menuObjects.add(addFr);
        menuObjects.add(addFav);
        menuObjects.add(block);
        return menuObjects;
    }

    private void addFragment(ParticularEventFragment mainFragment, boolean b, int containerId) {
        //     mainFragment.change(str);
        invalidateOptionsMenu();
        String backStackName = mainFragment.getClass().getName();
        boolean fragmentPopped = fragmentManager.popBackStackImmediate(backStackName, 0);
        if (!fragmentPopped) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(containerId, mainFragment, backStackName).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
            if (b)
                transaction.addToBackStack(backStackName);
            transaction.commit();
        }
    }

    private void initToolbar() {
        TextView mToolBarTextView = (TextView) findViewById(R.id.text_view_toolbar_title2);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mToolbar.setNavigationIcon(R.drawable.btn_back);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mToolBarTextView.setText(EventActivity.eventName[clubIndex][eventIndex]);
        mToolBarTextView.setTextColor(getResources().getColor(android.R.color.holo_blue_light));
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Audiowide_Regular.ttf");
        mToolBarTextView.setTypeface(font);
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_particular_event, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.context_menu:
                if (fragmentManager.findFragmentByTag(ContextMenuDialogFragment.TAG) == null) {
                    mMenuDialogFragment.show(fragmentManager, ContextMenuDialogFragment.TAG);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (mMenuDialogFragment != null && mMenuDialogFragment.isAdded()) {
            mMenuDialogFragment.dismiss();
        } else {
            finish();
        }
    }

    @Override
    public void onMenuItemClick(View clickedView, int position) {
        replaceFragementdata(position);
    }

    @Override
    public void onMenuItemLongClick(View clickedView, int position) {
        replaceFragementdata(position);
    }

    private void replaceFragementdata(int position) {
        ParticularEventFragment.repalce(position);
    }
}
