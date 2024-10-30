package com.example.appreadstories;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class TruyenAdapter extends RecyclerView.Adapter<TruyenAdapter.TruyenViewHolder> {

    private ArrayList<Truyen> truyenList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Truyen truyen);
    }

    public TruyenAdapter(ArrayList<Truyen> truyenList, OnItemClickListener listener) {
        this.truyenList = truyenList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TruyenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_truyen, parent, false);
        return new TruyenViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TruyenViewHolder holder, int position) {
        Truyen truyen = truyenList.get(position);
        holder.tenTruyen.setText(truyen.getTenTruyen());
        Picasso.get().load(truyen.getPosterURL()).into(holder.posterImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(truyen);
            }
        });
    }

    @Override
    public int getItemCount() {
        return truyenList.size();
    }

    public class TruyenViewHolder extends RecyclerView.ViewHolder {

        TextView tenTruyen;
        ImageView posterImageView;

        public TruyenViewHolder(@NonNull View itemView) {
            super(itemView);
            tenTruyen = itemView.findViewById(R.id.tenTruyen);
            posterImageView = itemView.findViewById(R.id.posterImageView);
        }
    }
}
