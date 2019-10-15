package com.example.myandroidlearning;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    public ArrayList<ExampleItem> exItem;
    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        ExampleViewHolder ev=new ExampleViewHolder(v);
        return ev;
    }

    public ExampleAdapter(ArrayList<ExampleItem> itemArrayList) {
        exItem=itemArrayList;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
ExampleItem currentItem=exItem.get(position);
holder.textView1.setText(currentItem.getText1());
holder.textView2.setText(currentItem.getText2());
holder.textView3.setText(currentItem.getText3());
        holder.textView4.setText(currentItem.getText4());
        holder.textView5.setText(currentItem.getText5());


    }

    @Override
    public int getItemCount() {
        return exItem.size();
    }

    public  static class ExampleViewHolder extends RecyclerView.ViewHolder{
    public TextView textView1;
    public TextView textView2;
    public TextView textView3;
        public TextView textView4;
        public TextView textView5;

        public ExampleViewHolder(View itemView ){
    super(itemView);
    textView1=itemView.findViewById(R.id.text1);
    textView2=itemView.findViewById(R.id.text2);
    textView3=itemView.findViewById(R.id.text3);
            textView4=itemView.findViewById(R.id.text4);
            textView5=itemView.findViewById(R.id.text5);

        }


    }



}
