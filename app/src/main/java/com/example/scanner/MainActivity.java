package com.example.scanner;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.CAMERA}, PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);

        webView = findViewById(R.id.webviewid);
        webView.loadUrl("http://107.12.107.68:5000/login");
        webView.setWebViewClient(new WebViewClient() {


            public void onPageFinished(WebView view, String url) {
                if(webView.getUrl().equals("http://107.12.107.68:5000/getAndPostUpc")) {
                    Intent myIntent = new Intent(view.getContext(), Scan.class);
                    startActivityForResult(myIntent, 0);
                }
            }
        });
    }

}