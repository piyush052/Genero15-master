package com.dexterous.genero15.fragment;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dexterous.genero15.DiscrollViewActivity;
import com.dexterous.genero15.R;
import com.dexterous.genero15.util.SharedPreferencesProvider;
import com.material.widget.FloatingEditText;

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

/**
 * A simple {@link Fragment} subclass.
 */
public class EnterCouponCode extends Fragment {

    private static String url = "http://www.genero15.com/app_handle/devil.php";
    private String TAG = getClass().getSimpleName();
    String referenceCode, _username, reply;

    static Context _context;
    @Bind(R.id.reference_code)

    FloatingEditText reference_code;
    @Bind(R.id.Submit)
    Button Submit;
    @Bind(R.id.username)
    FloatingEditText username;
    @Bind(R.id.textView)
    TextView tv;
    LoadToast loader;

    public EnterCouponCode() {
        // Required empty public constructor
    }

    public static EnterCouponCode instantiate(Context context) {
        EnterCouponCode fragment = new EnterCouponCode();
        _context = context;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_enter_coupon_code, container, false);
        ButterKnife.bind(this, rootView);
        loader = new LoadToast(getActivity());
        Log.i(TAG, getDeviceId());
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(_context,"Genero is over now referral code will not work.click submit to view app",Toast.LENGTH_LONG).show();
                openDiscrollViewActivity(_context);

                /*

                _username = username.getText().toString();
                referenceCode = reference_code.getText().toString();
                if (referenceCode == null || referenceCode.isEmpty()) {
                   // SharedPreferencesProvider.setFirstRun(_context, false);
                    if (_username.isEmpty()) {
                        openDiscrollViewActivity(_context);
                    } else {
                        if (checkConnection(getActivity())) {
                            new SendData().execute(url);
                        } else {
                            Toast.makeText(getContext(), "Connect To Internet.", Toast.LENGTH_LONG).show();
                        }
                    }
                } else {
                    //TODO make network call
                    if (_username.isEmpty()) {
                        Toast.makeText(getActivity(), "Please enter any username.", Toast.LENGTH_LONG).show();
                    } else {
                        if (checkConnection(getContext())) {
                         //   SharedPreferencesProvider.setFirstRun(_context, false);
                            new SendData().execute(url);
                        } else {
                            Toast.makeText(getContext(), "Connect To Internet.", Toast.LENGTH_LONG).show();
                        }
                    }
                }*/
            }
        });
        Log.i(TAG, "reply: " + reply);
//        if (!reply.equals("failure")) {
//            String[] server_reply = reply.split(",");
//            Log.i(TAG, "" + server_reply.length);
//
//        }
//        openDiscrollViewActivity(_context);
//        if(reply == null) {
//            return rootView;
//        }
        return rootView;
    }

    protected boolean checkConnection(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
        }
        return false;
    }

    //    ****Sending Data*****
    class SendData extends AsyncTask<String, Void, String> {
        HttpEntity httpEntity;
        InputStream inputStream;
        String getContent = "", getResponse = "";
        HttpResponse httpResponse = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            String UID = getDeviceId();
            loader.setText("Getting referral code...");
            loader.setTranslationY(200);
            loader.show();
            url = url + "?";
            if (!_username.isEmpty()) {
                _username = _username.replaceAll(" ", "%20");
                url = url + "user=" + _username;
            }
            if (!referenceCode.isEmpty()) {
                url = url + "&ref_code=" + referenceCode;
            }
            url = url + "&device_id=" + UID;
        }

        @Override
        protected String doInBackground(String... strings) {
            Log.i(TAG, url);
            Log.i(TAG, "starting doInBackground");
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            try {
                httpResponse = httpClient.execute(httpGet);
                Log.i(TAG, httpResponse.toString());
            } catch (IOException e) {
                e.printStackTrace();
                Log.i(TAG, e.toString());
            }
            StatusLine statusLine = httpResponse.getStatusLine();
            if (statusLine.getStatusCode() == 200) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        loader.success();
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
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        loader.error();
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
            reply = s;
            String[] RESPONSE = s.split(",");
            if (RESPONSE[0].equals("failure")) {
                Toast.makeText(_context, "Invalid Coupon Code OR Device All ready registered!!!", Toast.LENGTH_LONG).show();
            } else {
                SharedPreferencesProvider.saveUser(_context, RESPONSE[0], RESPONSE[1], RESPONSE[2]);
                openDiscrollViewActivity(_context);
            }
        }
    }

    private String getDeviceId() {
        return Settings.Secure.getString(getActivity().getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    static public void openDiscrollViewActivity(Context _context) {
        SharedPreferencesProvider.setFirstRun(_context, false);

        Intent discrollView = new Intent(_context, DiscrollViewActivity.class);
        discrollView.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        _context.startActivity(discrollView);
    }
}

