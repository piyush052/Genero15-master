package com.dexterous.genero15;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.dexterous.genero15.events.CustomAdapterClubEvent;
import com.dexterous.genero15.events.CustomAdapterClubEventForOffLine;
import com.dexterous.genero15.util.Network;
import com.twotoasters.jazzylistview.JazzyListView;
import com.twotoasters.jazzylistview.effects.ReverseFlyEffect;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ClubActivity extends Activity implements ListView.OnItemClickListener {

    public static final String CLUB_INDEX = "com.dexterous.genero15.club_index";
    @Bind(R.id.listView)
    JazzyListView lv;
    Context context;
    @Bind(R.id.activity_club)
    RelativeLayout activity_club;

//    public static int[] prgmImages = {R.drawable.cultural, R.drawable.tech_ce, R.drawable.tech_ec,
//            R.drawable.literary, R.drawable.tech_me,
//            R.drawable.bob, R.drawable.tech_ce, R.drawable.dramatics, R.drawable.dramatics, R.drawable.dramatics};
//
//    public static String prgmImages[] = {
//            "http://s7.postimg.org/oq70lthzv/cultural.jpg",
//            "http://s7.postimg.org/5mdp5h55n/tech_ce.jpg",
//            "http://s7.postimg.org/4duexl2l7/tech_ec.jpg",
//            "http://s7.postimg.org/sqirbsxuj/literary.jpg",
//            "http://s7.postimg.org/bv3mcss4b/tech_me.jpg",
//            "http://s7.postimg.org/5mdp5h55n/tech_ce.jpg",
//            "http://s7.postimg.org/5mdp5h55n/tech_ce.jpg",
//            "http://s7.postimg.org/cutx8i7a3/dramatics.jpg",
//            "http://s7.postimg.org/cutx8i7a3/dramatics.jpg",
//            "http://s7.postimg.org/cutx8i7a3/dramatics.jpg",
//    };

    String clubArrayForXml[] = {"cultural", "cs", "ec", "literary", "me", "special", "ce",
            "informals", "drama", "gaming"};


    public static String clubs[] = {"CULTURAL", "TECH CS", "TECH EC", "LITERARY CLUB", "TECH ME", "SPECIAL ATTRACTION", "TECH CIVIL", "INFORMALS", "DRAMATICS", "E GAMING"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);
        ButterKnife.bind(this);
        if (Network.isNetworkAvailable(this)) {
            Toast.makeText(this, "Loading...", Toast.LENGTH_LONG).show();
            lv.setAdapter(new CustomAdapterClubEvent(this, clubs));
            lv.setOnItemClickListener(this);
        } else {
//            activity_club.setBackground(getResources().getDrawable(R.drawable.bg2));
            Toast.makeText(this, R.string.connect_to_internet, Toast.LENGTH_LONG).show();
            lv.setAdapter(new CustomAdapterClubEventForOffLine(this, clubs));
            lv.setOnItemClickListener(this);
        }
        lv.setSelector(R.drawable.listselector);
        lv.setTransitionEffect(new ReverseFlyEffect());
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getApplicationContext(), EventActivity.class);
        intent.putExtra(CLUB_INDEX, position);
        startActivity(intent);
    }
}
