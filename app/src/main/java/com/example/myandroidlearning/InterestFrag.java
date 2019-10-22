package com.example.myandroidlearning;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myandroidlearning.databinding.FragmentInterestFragBinding;

import java.util.ArrayList;
import java.util.List;


public class InterestFrag extends Fragment {

    public static RecyclerView recyclerView;
    public static RecyclerView.Adapter myAdapter;
    public RecyclerView.LayoutManager myLayoutManager;
    public static List<String> interestItemList=new ArrayList<>();
    public static Context applicationContext;
    public static  InterestFragViewModel viewModel=new InterestFragViewModel();
    public static View view;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentInterestFragBinding binding= DataBindingUtil.inflate(inflater,R.layout.fragment_interest_frag,container,false);
         view=binding.getRoot();

        recyclerView=view.findViewById(R.id.interest_recycle_view);
        myLayoutManager=new LinearLayoutManager(getContext());
        applicationContext=getContext();
        recyclerView.setLayoutManager(myLayoutManager);
        myAdapter= new InterestAdapter(interestItemList);
        recyclerView.setAdapter(myAdapter);
        viewModel.setMandatoryDetails();
        viewModel.readData();
        binding.setViewModel(viewModel);
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
