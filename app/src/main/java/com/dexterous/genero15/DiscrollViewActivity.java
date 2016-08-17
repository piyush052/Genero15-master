package com.dexterous.genero15;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dexterous.genero15.DiscrollView.DiscrollvablePathLayout;
import com.dexterous.genero15.DiscrollView.DiscrollvablePathLayoutCoreTeam;
import com.dexterous.genero15.DiscrollView.DiscrollvablePathLayoutReferAndEarn;
import com.dexterous.genero15.font.Audiowide_Regular;
import com.dexterous.genero15.util.Network;
import com.dexterous.genero15.util.SharedPreferencesProvider;

import butterknife.Bind;
import butterknife.ButterKnife;


public class DiscrollViewActivity extends Activity implements View.OnClickListener {

    //    private ArrayList<GameEntity> mData = new ArrayList<>(0);
//    private CoverFlowAdapter mAdapter;
//    private FeatureCoverFlow mCoverFlow;


//    @Bind(R.id.slider)
//    SliderLayout mDemoSlider;
//    @Bind(R.id.title)
//    TextSwitcher mTitle;

    private final String LAUNCHCODE = "appvirality.sampleapp.launchmode";
    private final int REQUEST_CODE = 5000;
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;


    @Bind(R.id.events)
    ImageView events;
    @Bind(R.id.about_click)
    DiscrollvablePathLayout about;
    @Bind(R.id.coreteam)
    DiscrollvablePathLayoutCoreTeam coreteam;

    //    @Bind(R.id.facebook)
//    ImageView facebook;
    @Bind(R.id.events_text)
    Audiowide_Regular events_text;

//    @Bind(R.id.refer_app)
//    TextView refer_app;

    @Bind(R.id.contact_us)
    Audiowide_Regular contact_us;

    @Bind(R.id.developers)
    Audiowide_Regular developers;


    @Bind(R.id.spl2)
    TextView fs;

    @Bind(R.id.spl1)
    TextView bob;

    @Bind(R.id.spl3)
    TextView spl3;

    @Bind(R.id.spl4)
    TextView spl4;


    @Bind(R.id.refrErn)
    DiscrollvablePathLayoutReferAndEarn refrErn;

    @Bind(R.id.webView)
    Audiowide_Regular web_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discroll_view);
        ButterKnife.bind(this);

        //   setUpCarousel(this);

        /*
        mData.add(new GameEntity(R.drawable.tech_ce, R.string.title1));
        mData.add(new GameEntity(R.drawable.tech_ec, R.string.title1));
        mData.add(new GameEntity(R.drawable.tech_me, R.string.title1));
        mData.add(new GameEntity(R.drawable.bob, R.string.title1));
        mData.add(new GameEntity(R.drawable.genero_all, R.string.title1));
        mData.add(new GameEntity(R.drawable.literary, R.string.title1));
        mData.add(new GameEntity(R.drawable.dramatics, R.string.title1));
        mData.add(new GameEntity(R.drawable.cultural, R.string.title1));

        // mTitle = (TextSwitcher) findViewById(R.id.title);
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(DiscrollViewActivity.this);
                TextView textView = (TextView) inflater.inflate(R.layout.item_title, null);
                return textView;
            }
        });
        Animation in = AnimationUtils.loadAnimation(this, R.anim.slide_in_top);
        Animation out = AnimationUtils.loadAnimation(this, R.anim.slide_out_bottom);
        mTitle.setInAnimation(in);
        mTitle.setOutAnimation(out);

        mAdapter = new CoverFlowAdapter(this);
        mAdapter.setData(mData);
        mCoverFlow = (FeatureCoverFlow) findViewById(R.id.coverflow);
        mCoverFlow.setAdapter(mAdapter);*/
        //   mCoverFlow.set
/*
//TODO Debug IndexOutOfBoudsException
        mCoverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        getResources().getString(mData.get(position).titleResId),
                        Toast.LENGTH_SHORT).show();
            }
        });
*/
        /*
        mCoverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(getResources().getString(mData.get(position).titleResId));
            }

            @Override
            public void onScrolling() {
                mTitle.setText("");
            }
        });
        */
        events.setOnClickListener(this);
        about.setOnClickListener(this);
        coreteam.setOnClickListener(this);
//        facebook.setOnClickListener(this);
//        refer_app.setOnClickListener(this);
        events_text.setOnClickListener(this);
        contact_us.setOnClickListener(this);
        fs.setOnClickListener(this);
        bob.setOnClickListener(this);
        spl3.setOnClickListener(this);
        spl4.setOnClickListener(this);
        developers.setOnClickListener(this);
        refrErn.setOnClickListener(this);
        web_view.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.about_click:
                Intent about = new Intent(this, AboutActivity.class);
                startActivity(about);
                break;
            case R.id.events:
                Intent events = new Intent(this, ClubActivity.class);
                startActivity(events);
                break;
            case R.id.events_text:
                Intent spclEvents = new Intent(this, EventActivity.class);
                spclEvents.putExtra(ClubActivity.CLUB_INDEX, 5);
                startActivity(spclEvents);
                break;
            case R.id.coreteam:
                Intent coreTeam = new Intent(this, CoreTeam.class);
                startActivity(coreTeam);
                break;
//            case R.id.facebook:
//                Intent facebook = new Intent(this, FacebookActivity.class);
//                startActivity(facebook);
//                break;
//            case R.id.refer_app:
//                AppviralityUI.showGrowthHack(DiscrollViewActivity.this, AppviralityUI.GH.Word_of_Mouth);
//                break;
            case R.id.contact_us:
                Intent contactUs = new Intent(this, ContactUs.class);
                startActivity(contactUs);
                break;
            case R.id.spl2:
                Intent fs = new Intent(this, ParticulareEventActivity.class);
                fs.putExtra(ClubActivity.CLUB_INDEX, 5);
                fs.putExtra(EventActivity.EVENT_INDEX, 1);
                startActivity(fs);
                break;
            case R.id.spl1:
                Intent bob = new Intent(this, ParticulareEventActivity.class);
                bob.putExtra(ClubActivity.CLUB_INDEX, 5);
                bob.putExtra(EventActivity.EVENT_INDEX, 0);
                startActivity(bob);
                break;
            case R.id.spl3:
                Intent spl3 = new Intent(this, ParticulareEventActivity.class);
                spl3.putExtra(ClubActivity.CLUB_INDEX, 5);
                spl3.putExtra(EventActivity.EVENT_INDEX, 2);
                startActivity(spl3);
                break;
            case R.id.spl4:
                Intent spl4 = new Intent(this, ParticulareEventActivity.class);
                spl4.putExtra(ClubActivity.CLUB_INDEX, 5);
                spl4.putExtra(EventActivity.EVENT_INDEX, 3);
                startActivity(spl4);
                break;
            case R.id.developers:
                Intent developers = new Intent(this, Developers.class);
                startActivity(developers);
                break;
            case R.id.refrErn:
                /*if (SharedPreferencesProvider.getRefCode(this) != 0) {
                    if (Network.isNetworkAvailable(this)) {
                        Intent ref = new Intent(this, GeneroAppReferrals.class);
                        startActivity(ref);
                    } else {
                        Toast.makeText(getApplicationContext(), "Connect To Internet Please...", Toast.LENGTH_LONG).show();
                        Network.turnOnDataAccess(this);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "You are not registered!!!", Toast.LENGTH_LONG).show();
                }*/
                Toast.makeText(getApplicationContext(), " Genero is over now Refer and Earn will not work!!!", Toast.LENGTH_LONG).show();
                break;
            case R.id.webView:
                if (Network.isNetworkAvailable(this)) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://genero15.com/store.php"));
                    startActivity(browserIntent);
                } else {
                    Toast.makeText(this, R.string.connect_to_internet, Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
