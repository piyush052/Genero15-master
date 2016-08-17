package com.dexterous.genero15;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.dexterous.genero15.font.Roboto_Medium;
import com.dexterous.genero15.util.SharedPreferencesProvider;
import com.github.clans.fab.FloatingActionButton;

import net.steamcrafted.loadtoast.LoadToast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GeneroAppReferrals extends Activity {

    @Bind(R.id.refcode)
    Roboto_Medium refcode;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    //    @Bind(R.id.tc)
//    FloatingActionButton tc;
    @Bind(R.id.refcount)
    Roboto_Medium refcount;
    @Bind(R.id.UID)
    Roboto_Medium UID;
    @Bind(R.id.userName)
    Roboto_Medium userName;

    LoadToast loadToast;
    private String urlToRef = "http://www.genero15.com/app_handle/devil.php";
    private String TAG = getClass().getSimpleName();
    int text = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genero_app_referrals);
        ButterKnife.bind(this);

        loadToast = new LoadToast(this);
        text = SharedPreferencesProvider.getRefCode(getApplicationContext());
        refcode.setText("" + text);
        userName.setText("" + SharedPreferencesProvider.getUserName(this));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text2 = "Download ABES Techno-Cultural Genero15 Android App and earn FREEBIES https://play.google.com/store/apps/details?id=com.dexterous.genero15 Enter coupon code " + text + "";

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, text2);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

//        tc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder alert = new AlertDialog.Builder(getApplicationContext());
//                alert.setCancelable(false)
//                        .setTitle("Terms & Conditions")
//                        .setMessage(getString(R.string.tnc))
//                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
////                        finish();
//                            }
//                        });
//                AlertDialog alertDialog = alert.create();
//                alertDialog.show();
//            }
//        });
        UID.setText(SharedPreferencesProvider.getUIDCode(getApplicationContext()));
        getYourRefCount();
    }

    public void getYourRefCount() {
        new SendData().execute();
    }

    class SendData extends AsyncTask<String, Void, String> {
        HttpEntity httpEntity;
        InputStream inputStream;
        String getContent = "", getResponse = "";
        HttpResponse httpResponse = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            String UID = SharedPreferencesProvider.getUIDCode(getApplicationContext());
            String username = SharedPreferencesProvider.getUserName(getApplicationContext());
            loadToast.setText("Getting referral code...");
            loadToast.setTranslationY(200);
            loadToast.show();
            urlToRef = urlToRef + "?";
            username = username.replaceAll(" ", "%20");
            urlToRef = urlToRef + "user=" + username;
            urlToRef = urlToRef + "&device_id=" + UID;
        }

        @Override
        protected String doInBackground(String... strings) {
            Log.i(TAG, urlToRef);
            Log.i(TAG, "starting doInBackground");
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(urlToRef);
            try {
                httpResponse = httpClient.execute(httpGet);
                Log.i(TAG, httpResponse.toString());
            } catch (IOException e) {
                e.printStackTrace();
                Log.i(TAG, e.toString());
            }
            StatusLine statusLine = httpResponse.getStatusLine();
            if (statusLine.getStatusCode() == 200) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        loadToast.success();
                    }
                });
                httpEntity = httpResponse.getEntity();
                try {
                    inputStream = httpEntity.getContent();
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.i(TAG, e.toString());
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                try {
                    while ((getResponse = bufferedReader.readLine()) != null) {
                        getContent = getContent + getResponse;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.i(TAG, e.toString());
                }
            } else {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        loadToast.error();
                    }
                });
            }
            Log.i(TAG, "leaving doin: " + getContent);
            return getContent;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.i(TAG, s);
            if (s.isEmpty()) {
                refcount.setText("Can't fetch right now.");
            } else {
                String[] RESPONSE = s.split(",");
                SharedPreferencesProvider.saveUserData(getApplicationContext(), RESPONSE[3]);
                refcount.setText(RESPONSE[3]);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button.
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
