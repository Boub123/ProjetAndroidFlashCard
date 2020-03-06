package com.example.flashcard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardClassAdapter extends RecyclerView.Adapter<CardClassAdapter.ViewHolder> {
    private final List<CardClass> cards;

    public CardClassAdapter(List<CardClass> cards)
    {
        this.cards = cards;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        final ImageView imageId;
        final TextView gameName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageId = itemView.findViewById(R.id.imageIdImageView);
            gameName = itemView.findViewById(R.id.gameNameTextView);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cardclass, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CardClass card = cards.get(position);

        holder.imageId.setImageResource(card.imageId);
        holder.gameName.setText(card.answer);
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }
}