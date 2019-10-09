package com.example.crudtinydb;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.AnimeHolder> {

    private ArrayList<AnimeModel>animeModels;

    public AnimeAdapter(ArrayList<AnimeModel> animeModels) {
        this.animeModels = animeModels;
    }

    @NonNull
    @Override
    public AnimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new AnimeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeHolder holder, int position) {
        holder.bindData(animeModels.get(position),position);
    }

    @Override
    public int getItemCount() {
        return animeModels.size();
    }

    public class AnimeHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;
        LinearLayout linearLayout;
        public AnimeHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.tv_title_item);
            linearLayout = itemView.findViewById(R.id.linear_list);
        }
        void bindData(final AnimeModel animeModel, final int position){
            textViewTitle.setText(animeModel.getTitleAnime());
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(),DetailActivity.class);
                    intent.putExtra("TAG_MODEL",animeModel);
                    intent.putExtra("POSITION",position);
                    view.getContext().startActivity(intent);
                }
            });
        }
    }
}