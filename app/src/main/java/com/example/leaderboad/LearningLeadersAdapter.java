package com.example.leaderboad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.leaderboad.Model.Hours;

import java.util.List;

public class LearningLeadersAdapter extends RecyclerView.Adapter<LearningLeadersAdapter.MyViewHolder>

    {

        private List<Hours> myList;
        Context context;

    public LearningLeadersAdapter(Context context, List < Hours > topLerners) {
        this.context = context;
        this.myList = topLerners;
    }

        public void setTopList (List < Hours > movieList) {
        this.myList = movieList;
        notifyDataSetChanged();
    }


        @Override
        public MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.skill_iq_list, parent, false);

        return new MyViewHolder(itemView);
    }

        @Override
        public void onBindViewHolder (MyViewHolder holder,int position){
        Hours topLerner = myList.get(position);
        holder.name.setText(topLerner.getName());
        holder.hours.setText(topLerner.getHours().concat(" Learning hours ,"));
        holder.country.setText(topLerner.getCountry());

        Glide.with(context).load(myList.get(position)
                .getBadgeUrl()).apply(RequestOptions.centerCropTransform()).into(holder.imageTopLearner);

    }

        @Override
        public int getItemCount () {
        if (myList != null) {
            return myList.size();
        }
        return 0;

    }
        public static class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView name, hours, country;
            public ImageView imageTopLearner;

            public MyViewHolder(View view) {
                super(view);
                name = view.findViewById(R.id.txt_name);
                hours = view.findViewById(R.id.txt_progress);
                country = view.findViewById(R.id.txt_live);
                imageTopLearner = view.findViewById(R.id.topLeranerImage);
            }
        }
    }

