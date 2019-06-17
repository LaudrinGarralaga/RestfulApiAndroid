package com.example.restfulapiandroid.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.restfulapiandroid.R;
import com.example.restfulapiandroid.callbacks.OnMatchClickListener;
import com.example.restfulapiandroid.models.Match;

import java.util.List;

/**
 * Created by ixi.Dv on 10/11/2018.
 * Email : feedback.mrzero@gmail.com
 */
public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.PostHolder> {
    private LayoutInflater inflater;
    private List<Match> matches;
    private OnMatchClickListener onMatchClickListener;

    public MatchAdapter(List<Match> matches, OnMatchClickListener onMatchClickListener) {
        this.matches = matches;
        this.onMatchClickListener = onMatchClickListener;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        if (inflater == null)
            inflater = LayoutInflater.from(parent.getContext());
        return new PostHolder(inflater.inflate(R.layout.post_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {

        final Match item = matches.get(position);
        holder.title.setText(item.getRecipeName());
        holder.author.setText(item.getSourceDisplayName());
        //holder.date.setText(item.getIngredients().get(0));
        // load thumbnail
        Glide.with(holder.thumbnail)
                .load(item.getImageUrlsBySize().get_90())
                .into(holder.thumbnail);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (onMatchClickListener !=null)
                   onMatchClickListener.onPostClick(Integer.parseInt(item.getId()));
            }
        });

    }

    @Override
    public int getItemCount() {
        if (matches == null) // no matches found
            return 0;

        return matches.size();
    }

    class PostHolder extends RecyclerView.ViewHolder {
        TextView title, date, author;
        ImageView thumbnail;

        public PostHolder(@NonNull View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.post_title);
            //this.date = itemView.findViewById(R.id.post_date);
            this.author = itemView.findViewById(R.id.post_author);
            this.thumbnail = itemView.findViewById(R.id.post_thumbnail);

        }
    }
}
