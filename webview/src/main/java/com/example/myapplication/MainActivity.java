package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    EditText edturl;
    Button btgo, btback;
    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edturl = (EditText) findViewById(R.id.editurl);
        btgo = (Button) findViewById(R.id.btgo);
        btback = (Button) findViewById(R.id.btback);
        web = (WebView) findViewById(R.id.web);

        web.setWebViewClient(new Cookwebviewclient());
        WebSettings webset = web.getSettings();
        webset.setBuiltInZoomControls(true);

        btgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String seturl = edturl.getText().toString();
                if (!seturl.startsWith("www.") && !seturl.startsWith("http://")) {
                    seturl = "www." + seturl;
                }
                if (!seturl.startsWith("http://")) {
                    seturl = "http://" + seturl;
                }
                web.loadUrl(seturl);
            }
        });

        btback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web.goBack();
            }
        });
    }

    class Cookwebviewclient extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            //return super.shouldOverrideUrlLoading(view, url);
            return false;
        }
        public void onPageFinished(WebView view, String url)
        {
            super.onPageFinished(view, url);
            edturl.setText(url);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
