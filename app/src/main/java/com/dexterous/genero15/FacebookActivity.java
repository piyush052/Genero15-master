package com.dexterous.genero15;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.dexterous.genero15.facebook.MyWebViewClient;

import butterknife.Bind;
import butterknife.ButterKnife;


public class FacebookActivity extends Activity {

    @Bind(R.id.webView)
    WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);
        ButterKnife.bind(this);
        myWebView.setWebViewClient(new MyWebViewClient());
        myWebView.loadUrl("http://genero15.com/m_store.php");


        //  myWebView.setWebViewClient(new WebViewKeep());
        myWebView.setInitialScale(1); // Set the initial zoom scale
//        myWebView.getSettings().setBuiltInZoomControls(true); // Initialize zoom controls for your WebView component
        myWebView.getSettings().setUseWideViewPort(true);


        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
//        webSettings.setUserAgentString(Locale.getDefault().getLanguage());

    }
}
