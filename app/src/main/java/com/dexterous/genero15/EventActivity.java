package com.dexterous.genero15;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dexterous.genero15.events.CustomAdapterEventsOffLine;
import com.dexterous.genero15.font.Audiowide_Regular;
import com.dexterous.genero15.util.GetResources;
import com.dexterous.genero15.util.Network;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelSlideListener;
import com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;


public class EventActivity extends Activity implements ListView.OnItemClickListener {

    private final String TAG = getClass().getSimpleName();

    private SlidingUpPanelLayout mLayout;

    public static int[] CS = {};
    public static int[] EC = {};
    public static int[] ME = {};

    final static String eventName[][] = {
            {"SOLO SINGING", "SOLO DANCE", "GROUP DANCE", "INSTRUMENTAL", "FACE-OFF"},              //CULTURAL
            {"Myths-n-Code", "Quizzie", "INNOVATIA", "CODEZONE", "CODEBREAKER", "Language Quiz","DRISHTI"},   //
            {"Aquiziam", "RoboSoccer", "Line Follower", "RoboRace", "RoboWar", "MicroController", "Edge Follower", "Real Time NFS"},
            {"English debate", "Hindi debate", "Crucible Quiz", "SRT", "Poetry", "Triathlon"},   //Literary
            {"Kryptos(Mystery of Words)", "BUOYANT", "NEED FOR WAVES (BOAT RACE)", "Fate the aviate(Cheers to air)", "Technical Presentation", "Schrottplatz"},//TECH ME
            {"BATTLE OF BANDS", "LIVE CONCERT", "DALAL STREET", "THEATRE"}, //Specical attraction
            {"BOB THE BUILDER", "BEAT-D-EUCLID", "ARCHIPEDIA (PRESENTATION)","EXHIBITION",  "CARTE DE PALAIS", "TERRAMIND"}, //TECH CE
            {"Treasure Hunt", "Roadies", "Tug of war", "Face Painting", "Rangoli", "Sketching", "Dart game"}, //Informals
            {"NUKKAD NATAK", "RANGMANCH", "MANMARZI", "AD MAD SHOW", "YE KARKE DIKHA"}, //Drama
            {"CALL OF DUTY", "CRICKET'07", "Counter Strike 1.6", "FIFA", "Need for Speed", "TEKKEN"}};    //E_Gaming

    String clubArray[] = {"CULTURAL", "TECH CS", "TECH EC", "LITERARY CLUB", "TECH ME", "SPECIAL ATTRACTION",
            "TECH CIVIL", "ELIXIR(Informals)", "DRAMATICS", "E GAMING"};

    public final static String clubArrayForXml[] = {"cultural", "cs", "ec", "literary", "me", "special", "ce",
            "informals", "drama", "gami`ng"};

    int clubIndex;
    public static final String EVENT_INDEX = "com.dexterous.genero15.event_index";

    @Bind(R.id.aboutDesc)
    TextView aboutDesc;
    @Bind(R.id.aboutImage)
    ImageView aboutImage;
    @Bind(R.id.eventList)
    ListView listView;
    @Bind(R.id.event)
    Audiowide_Regular event;
//    @Bind(R.id.main_toolbar)
//    android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        ButterKnife.bind(this);
//        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            return;
        }

        clubIndex = bundle.getInt(ClubActivity.CLUB_INDEX);

        if (Network.isNetworkAvailable(this)) {
            Toast.makeText(this, "Loading...", Toast.LENGTH_LONG).show();
//            listView.setAdapter(new CustomAdapterEvents(this, ME));
            listView.setAdapter(new CustomAdapterEventsOffLine(this, eventName[clubIndex]));
            Picasso.with(this).load(GetResources.getStringFromXml(this, "url_", clubArrayForXml[clubIndex])).into(aboutImage);
            aboutDesc.setText(GetResources.getStringFromXml(this, "about_", clubArrayForXml[clubIndex]));
            event.setText(clubArray[clubIndex]);
        } else {
            Toast.makeText(this, R.string.connect_to_internet, Toast.LENGTH_LONG).show();
            listView.setAdapter(new CustomAdapterEventsOffLine(this, eventName[clubIndex]));
            aboutDesc.setText(GetResources.getStringFromXml(this, "about_", clubArrayForXml[clubIndex]));
            event.setText(clubArray[clubIndex]);
        }


        mLayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        mLayout.setPanelSlideListener(new PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                Log.i(TAG, "onPanelSlide, offset " + slideOffset);
            }

            @Override
            public void onPanelExpanded(View panel) {
                Log.i(TAG, "onPanelExpanded");
            }

            @Override
            public void onPanelCollapsed(View panel) {
                Log.i(TAG, "onPanelCollapsed");
            }

            @Override
            public void onPanelAnchored(View panel) {
                Log.i(TAG, "onPanelAnchored");
            }

            @Override
            public void onPanelHidden(View panel) {
                Log.i(TAG, "onPanelHidden");
            }
        });
        listView.setOnItemClickListener(this);
        mLayout.setAnchorPoint(0.7f);
    }

    @Override
    public void onBackPressed() {
        if (mLayout != null &&
                (mLayout.getPanelState() == PanelState.EXPANDED || mLayout.getPanelState() == PanelState.ANCHORED)) {
            mLayout.setPanelState(PanelState.COLLAPSED);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getApplicationContext(), ParticulareEventActivity.class);
        intent.putExtra(ClubActivity.CLUB_INDEX, clubIndex);
        intent.putExtra(EventActivity.EVENT_INDEX, position);
        startActivity(intent);
    }
}