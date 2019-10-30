package com.example.myandroidlearning;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myandroidlearning.adapter.HelpAdapter;
import com.example.myandroidlearning.databinding.FragmentHelpFragBinding;
import com.example.myandroidlearning.viewmodel.HelpFragViewModel;

import java.util.ArrayList;
import java.util.List;


public class HelpFrag extends Fragment {

    public static RecyclerView recyclerView;
    public static RecyclerView.Adapter myAdapter;
    public RecyclerView.LayoutManager myLayoutManager;
    public static List<String> helpItemList=new ArrayList<>();
    public static Context applicationContext;
    public static HelpFragViewModel viewModel=new HelpFragViewModel();
    public static View view;

    @Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentHelpFragBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_help_frag, container, false);
         view = binding.getRoot();


        recyclerView=view.findViewById(R.id.help_recycle_view);
        myAdapter=new HelpAdapter(helpItemList);
        myLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(myLayoutManager);
        applicationContext=getContext();
        viewModel.setMandatoryDetails();
        binding.setViewModel(viewModel);
        viewModel.readData();
        return view;
    }





}
