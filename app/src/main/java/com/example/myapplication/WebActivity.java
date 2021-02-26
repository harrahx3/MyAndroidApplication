package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_web);
        WebView myWebView = (WebView)findViewById(R.id.webview);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED) {
            // You can use the API that requires the permission.
            Log.d("permission", "INTERNET GRANTED");
           // WebView myWebView = new WebView(this);
            //setContentView(myWebView);
            myWebView.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);
            myWebView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return false;
                }
            });
            WebSettings webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webSettings.setDomStorageEnabled(true);
            myWebView.setVerticalScrollBarEnabled(true);
            myWebView.setWebViewClient(new WebViewClient());
            myWebView.getSettings().setLoadWithOverviewMode(true);
            myWebView.getSettings().setUseWideViewPort(true);
            myWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            myWebView.setWebChromeClient(new WebChromeClient());
            myWebView.loadUrl("http://192.168.1.31/home");
        } else {
            Log.d("permission", "INTERNET NOT GRANTED");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, 34567);
        }

      /*  if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            // You can use the API that requires the permission.
            Log.d("permission", "CAMERA GRANTED");
            //WebView myWebView = new WebView(this);
            //setContentView(myWebView);

            myWebView.loadUrl("developer.android.com");
        } else {
            Log.d("permission", "CAMERA NOT GRANTED");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 34569);
        }*/

    }

    // Register the permissions callback, which handles the user's response to the
    // system permissions dialog. Save the return value, an instance of
    // ActivityResultLauncher, as an instance variable.
    /*private ActivityResultLauncher<String> requestPermissionLauncher =
            registerForActivityResult(new RequestPermission(), isGranted -> {
                if (isGranted) {
                    // Permission is granted. Continue the action or workflow in your
                    // app.
                } else {
                    // Explain to the user that the feature is unavailable because the
                    // features requires a permission that the user has denied. At the
                    // same time, respect the user's decision. Don't link to system
                    // settings in an effort to convince the user to change their
                    // decision.
                }
            });
*/
}