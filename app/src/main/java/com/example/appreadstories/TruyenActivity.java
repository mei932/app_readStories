package com.example.appreadstories;

import android.os.Bundle;
import android.widget.ImageButton;

public class TruyenActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content); // Set layout trước

        setupHomeButton(); // Sau khi set layout
    }

}

