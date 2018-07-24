package com.chain.volleyapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

//to bind our row with list view
public class SuggestionRecyclerAdapter extends RecyclerView.Adapter<SuggestionRecyclerAdapter.ViewHolder>{

    private Context context;
    private List<Suggestion> suggestionList;

    public SuggestionRecyclerAdapter(Context context, List<Suggestion> suggestionList) {
        this.context = context;
        this.suggestionList = suggestionList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.suggestion_row,parent,false);
        return new ViewHolder(view ,context);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //where views are bind to data
        Suggestion suggestion = suggestionList.get(position);
        String imageurl = null;

        holder.title.setText(suggestion.getTitle());
        holder.description.setText(suggestion.getDescription());


        //format the date ie April 17 2017
        java.text.DateFormat dateFormat = java.text.DateFormat.getDateInstance();
        String formattedDate = dateFormat.format(new Date
                (Long.valueOf(suggestion.getTimestamp())).getTime());
        holder.time.setText(formattedDate);
        imageurl = suggestion.getImage();

        //user picasso to load iamges

    }

    @Override
    public int getItemCount() {
        return suggestionList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //get the suggestion view
        public TextView title;
        public TextView description;
        public TextView time;
        public ImageView imageView;
        String userid;

        public ViewHolder(View view, Context ctx) {
            super(view);
            context = ctx;
            title = view.findViewById(R.id.titlelist);
            description = view.findViewById(R.id.details);
            time = view.findViewById(R.id.timeCreated);
            imageView = view.findViewById(R.id.imagelist);
            userid =null;

            //set all views to onclick
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //go to next activity
                }
            });


        }
    }
}
