package com.example.myandroidlearning.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myandroidlearning.R;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {
    List<String> EventItemArray;
    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.help_item, parent, false);
        EventViewHolder HVH=new EventViewHolder(v);
        return HVH;
    }

    public EventAdapter(List<String> helpItemArray) {
        this.EventItemArray = helpItemArray;
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        String current_item=EventItemArray.get(position);
        holder.text.setText(current_item);

    }

    @Override
    public int getItemCount() {
        return EventItemArray.size();
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder{
        TextView text;

        public EventViewHolder(View view){
            super(view);
            this.text=view.findViewById(R.id.showText);
        }

    }
}
