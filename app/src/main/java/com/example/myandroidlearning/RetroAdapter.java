package com.example.myandroidlearning;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myandroidlearning.Model.Main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class RetroAdapter extends RecyclerView.Adapter<RetroAdapter.myViewHolder>{

    public ArrayList<Main> main= new ArrayList<>();
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        myViewHolder ev=new myViewHolder(v);
        return ev;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
Main currentItem=main.get(position);
holder.textView.setText(currentItem.getTemp()+"");
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class myViewHolder extends  RecyclerView.ViewHolder{
       /* public float temp;
        private int pressure;
        private int humidity;



        private float temp_min;


        private float temp_max;


        private int sea_level;


        private int grnd_level;*/

       public  TextView textView;

        public myViewHolder (View view){

            super(view);
            TextView textView;
            textView = view.findViewById(R.id.text1);
        }

    }
}
