/*
package com.example.appreadstories;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TruyenAdapter truyenAdapter;
    private TruyenRepository truyenRepository;
    private DatabaseHelper databaseHelper;
    private ImageButton btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Khởi tạo DatabaseHelper
        databaseHelper = new DatabaseHelper(this);
        truyenRepository = new TruyenRepository(this);

        // Thêm dữ liệu vào cơ sở dữ liệu
        addSampleData();

        ArrayList<Truyen> truyenList = truyenRepository.getAllTruyen();

        truyenAdapter = new TruyenAdapter(truyenList, new TruyenAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Truyen truyen) {
                Intent intent = new Intent(MainActivity.this, ChapterActivity.class);
                intent.putExtra("idTruyen", truyen.getId());
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(truyenAdapter);

        // Thiết lập sự kiện cho nút Home
        btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Quay lại MainActivity
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });
    }

    private void addSampleData() {
        // Thêm dữ liệu vào bảng Truyen và Chapter
        Truyen truyen1 = new Truyen(0, "Truyện Kiếm Hiệp", "https://th.bing.com/th/id/OIP.2ypBd-zd11jYI88557aIgwHaQD?rs=1&pid=ImgDetMain", "Một câu chuyện đầy rẫy các cuộc phiêu lưu kiếm hiệp.");
        databaseHelper.addTruyen(truyen1);

        Truyen truyen2 = new Truyen(0, "Truyện Ngôn Tình", "https://th.bing.com/th/id/OIP.2ypBd-zd11jYI88557aIgwHaQD?rs=1&pid=ImgDetMain", "Câu chuyện tình yêu lãng mạn giữa hai nhân vật chính.");
        databaseHelper.addTruyen(truyen2);

        Truyen truyen3 = new Truyen(0, "Truyện Khoa Học Viễn Tưởng", "https://th.bing.com/th/id/OIP.2ypBd-zd11jYI88557aIgwHaQD?rs=1&pid=ImgDetMain", "Khám phá những thế giới ngoài hành tinh và tương lai xa.");
        databaseHelper.addTruyen(truyen3);

        Chapter chapter1 = new Chapter(1, "Kiếm Hiệp - Chương 1", "https://truyenchufull.org/63037e0b458c02619c6ed8a4");
        databaseHelper.addChapter(chapter1);

        Chapter chapter2 = new Chapter(1, "Kiếm Hiệp - Chương 2", "https://truyenchufull.org/63037e0b458c02619c6ed8a4");
        databaseHelper.addChapter(chapter2);

        Chapter chapter3 = new Chapter(2, "Ngôn Tình - Chương 1", "https://truyenchufull.org/63037e0b458c02619c6ed8a4");
        databaseHelper.addChapter(chapter3);

        Chapter chapter4 = new Chapter(3, "Khoa Học Viễn Tưởng - Chương 1", "https://truyenchufull.org/63037e0b458c02619c6ed8a4");
        databaseHelper.addChapter(chapter4);

        Chapter chapter5 = new Chapter(3, "Khoa Học Viễn Tưởng - Chương 2", "https://truyenchufull.org/63037e0b458c02619c6ed8a4");
        databaseHelper.addChapter(chapter5);
    }
}
*/

// MainActivity.java
package com.example.appreadstories;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private TruyenAdapter truyenAdapter;
    private TruyenRepository truyenRepository;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Gọi phương thức thiết lập nút Home từ lớp cơ sở
        setupHomeButton();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Khởi tạo DatabaseHelper
        databaseHelper = new DatabaseHelper(this);
        truyenRepository = new TruyenRepository(this);

        // Thêm dữ liệu vào cơ sở dữ liệu
        addSampleData();

        ArrayList<Truyen> truyenList = truyenRepository.getAllTruyen();

        truyenAdapter = new TruyenAdapter(truyenList, new TruyenAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Truyen truyen) {
                Intent intent = new Intent(MainActivity.this, ChapterActivity.class);
                intent.putExtra("idTruyen", truyen.getId());
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(truyenAdapter);
    }

    private void addSampleData() {
        // Thêm dữ liệu vào bảng Truyen và Chapter
        Truyen truyen1 = new Truyen(0, "Truyện Kiếm Hiệp", "https://th.bing.com/th/id/OIP.2ypBd-zd11jYI88557aIgwHaQD?rs=1&pid=ImgDetMain", "Một câu chuyện đầy rẫy các cuộc phiêu lưu kiếm hiệp.");
        databaseHelper.addTruyen(truyen1);

        Truyen truyen2 = new Truyen(0, "Truyện Ngôn Tình", "https://th.bing.com/th/id/OIP.2ypBd-zd11jYI88557aIgwHaQD?rs=1&pid=ImgDetMain", "Câu chuyện tình yêu lãng mạn giữa hai nhân vật chính.");
        databaseHelper.addTruyen(truyen2);

        Truyen truyen3 = new Truyen(0, "Truyện Khoa Học Viễn Tưởng", "https://th.bing.com/th/id/OIP.2ypBd-zd11jYI88557aIgwHaQD?rs=1&pid=ImgDetMain", "Khám phá những thế giới ngoài hành tinh và tương lai xa.");
        databaseHelper.addTruyen(truyen3);

        Chapter chapter1 = new Chapter(1, "Kiếm Hiệp - Chương 1", "https://truyenchufull.org/63037e0b458c02619c6ed8a4");
        databaseHelper.addChapter(chapter1);

        Chapter chapter2 = new Chapter(1, "Kiếm Hiệp - Chương 2", "https://truyenchufull.org/63037e0b458c02619c6ed8a4");
        databaseHelper.addChapter(chapter2);

        Chapter chapter3 = new Chapter(2, "Ngôn Tình - Chương 1", "https://truyenchufull.org/63037e0b458c02619c6ed8a4");
        databaseHelper.addChapter(chapter3);

        Chapter chapter4 = new Chapter(3, "Khoa Học Viễn Tưởng - Chương 1", "https://truyenchufull.org/63037e0b458c02619c6ed8a4");
        databaseHelper.addChapter(chapter4);

        Chapter chapter5 = new Chapter(3, "Khoa Học Viễn Tưởng - Chương 2", "https://truyenchufull.org/63037e0b458c02619c6ed8a4");
        databaseHelper.addChapter(chapter5);
    }
}

