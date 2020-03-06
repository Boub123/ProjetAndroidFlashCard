package com.example.flashcard;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GameListAdapter extends RecyclerView.Adapter<GameListAdapter.ViewHolder> {


    private final List<FlashCard> cards;

    public GameListAdapter(List<FlashCard> cards) {
        this.cards = cards;
    }

     class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView flag;
        final TextView text;

         public ViewHolder(@NonNull View itemView) {
             super(itemView);
             flag = itemView.findViewById(R.id.FlagImageView);
             text = itemView.findViewById(R.id.ImageTextView);
         }
     }

    @NonNull
    @Override
    public GameListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_game, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GameListAdapter.ViewHolder holder, int position) {
    FlashCard card = cards.get(position);
    holder.flag.setImageResource(card.flagId);
    holder.text.setText(card.reponse.toString());
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }



}
