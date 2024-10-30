package com.example.appreadstories;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ChapterViewHolder> {

    private ArrayList<Chapter> chapterList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Chapter chapter);
    }

    public ChapterAdapter(ArrayList<Chapter> chapterList, OnItemClickListener listener) {
        this.chapterList = chapterList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ChapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chapter, parent, false);
        return new ChapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChapterViewHolder holder, int position) {
        Chapter chapter = chapterList.get(position);
        holder.tenChapter.setText(chapter.getTenChapter());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(chapter);
            }
        });
    }

    @Override
    public int getItemCount() {
        return chapterList.size();
    }

    public class ChapterViewHolder extends RecyclerView.ViewHolder {

        TextView tenChapter;

        public ChapterViewHolder(@NonNull View itemView) {
            super(itemView);
            tenChapter = itemView.findViewById(R.id.tenChapter);
        }
    }
}
