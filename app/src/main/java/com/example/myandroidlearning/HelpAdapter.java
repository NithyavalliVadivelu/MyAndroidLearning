package com.example.myandroidlearning;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HelpAdapter extends RecyclerView.Adapter<HelpAdapter.HelpViewHolder> {
    List<String> helpItemArray;
    @NonNull
    @Override
    public HelpViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.help_item, parent, false);
        HelpViewHolder HVH=new HelpViewHolder(v);
        return HVH;
    }

    public HelpAdapter(List<String> helpItemArray) {
        this.helpItemArray = helpItemArray;
    }

    @Override
    public void onBindViewHolder(@NonNull HelpViewHolder holder, int position) {
        String current_item=helpItemArray.get(position);
        holder.text.setText(current_item);

    }

    @Override
    public int getItemCount() {
        return helpItemArray.size();
    }

    public static class HelpViewHolder extends RecyclerView.ViewHolder{
        TextView text;

        public HelpViewHolder(View view){
            super(view);
            this.text=view.findViewById(R.id.showText);
        }

    }
}
