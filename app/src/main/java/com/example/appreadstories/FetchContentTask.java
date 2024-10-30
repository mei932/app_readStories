package com.example.appreadstories;

import android.os.AsyncTask;
import android.webkit.WebView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;

public class FetchContentTask extends AsyncTask<Void, Void, String> {
    private WebView contentWebView;
    private String chapterLink;

    public FetchContentTask(WebView contentWebView, String chapterLink) {
        this.contentWebView = contentWebView;
        this.chapterLink = chapterLink;
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            Document doc = Jsoup.connect(chapterLink).get();
            Element contentDiv = doc.selectFirst("div.blog-post-body");

            if (contentDiv != null) {
                return contentDiv.html();
            } else {
                return "Không tìm thấy nội dung.";
            }

        } catch (IOException e) {
            e.printStackTrace();
            return "Lỗi khi tải trang.";
        }
    }

    @Override
    protected void onPostExecute(String result) {
        contentWebView.loadData(result, "text/html", "UTF-8");
    }
}
