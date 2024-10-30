package com.example.appreadstories;

import android.os.Bundle;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

public class ContentActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        webView = findViewById(R.id.webView);
        String chapterLink = getIntent().getStringExtra("chapterLink");

        FetchContentTask fetchContentTask = new FetchContentTask(webView, chapterLink);
        fetchContentTask.execute();
    }
}
