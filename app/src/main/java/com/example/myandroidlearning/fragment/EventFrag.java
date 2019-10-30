package com.example.myandroidlearning;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myandroidlearning.adapter.EventAdapter;
import com.example.myandroidlearning.databinding.FragmentEventFragBinding;
import com.example.myandroidlearning.viewmodel.EventFragViewModel;

import java.util.ArrayList;
import java.util.List;


public class EventFrag extends Fragment {


    public static RecyclerView recyclerView;
    public static RecyclerView.Adapter myAdapter;
    public RecyclerView.LayoutManager myLayoutManager;
    public static List<String> eventItemList=new ArrayList<>();
    public static Context applicationContext;
    public static EventFragViewModel viewModel=new EventFragViewModel();
    public static View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        FragmentEventFragBinding binding= DataBindingUtil.inflate(inflater,R.layout.fragment_event_frag,container,false);
         view=binding.getRoot();
        binding.setViewModel(viewModel);
        recyclerView=view.findViewById(R.id.frag_recycle_view);
        myAdapter=new EventAdapter(eventItemList);
        myLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(myLayoutManager);
        applicationContext=getContext();
        viewModel.setMandatoryDetails();
        viewModel.readData();
        return view;
    }

    public static void updateData(){
        System.out.println("came here");
        viewModel.addAndShowData(view);
    }
    public static void saveData(){
        System.out.println("came here");
        viewModel.saveData();
    }

}
