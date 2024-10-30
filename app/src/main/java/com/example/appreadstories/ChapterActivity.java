package com.example.appreadstories;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ChapterActivity extends AppCompatActivity {

    private RecyclerView recyclerViewChapters;
    private ChapterAdapter chapterAdapter;
    private ChapterRepository chapterRepository;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);

        recyclerViewChapters = findViewById(R.id.recyclerViewChapters);
        recyclerViewChapters.setLayoutManager(new LinearLayoutManager(this));

        int idTruyen = getIntent().getIntExtra("idTruyen", -1);

        // Cung cấp context vào constructor
        chapterRepository = new ChapterRepository(this);

        ArrayList<Chapter> chapterList = chapterRepository.getChaptersByTruyenId(idTruyen);

        chapterAdapter = new ChapterAdapter(chapterList, new ChapterAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Chapter chapter) {
                Intent intent = new Intent(ChapterActivity.this, ContentActivity.class);
                intent.putExtra("chapterLink", chapter.getLinkChapter());
                startActivity(intent);
            }
        });

        recyclerViewChapters.setAdapter(chapterAdapter);
    }

}
