package com.example.myandroidlearning.viewmodel;

import android.os.StrictMode;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myandroidlearning.adapter.InterestAdapter;
import com.example.myandroidlearning.fragment.InterestFrag;
import com.example.myandroidlearning.util.SharedPrefUtils;

import java.util.List;
import java.util.Set;


public class InterestFragViewModel extends ViewModel {

    public ObservableField<String> text=new ObservableField<>();
    public RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    SharedPrefUtils utils=new SharedPrefUtils();
    public String sharedPrefName="interest_pref";
    public List<String> InterestItemList= InterestFrag.interestItemList;
    public InterestFragViewModel() { }
    public InterestFragViewModel(ObservableField<String> text) {
        this.text = text;
    }

    ItemTouchHelper.SimpleCallback itemTouchHelper= new ItemTouchHelper.SimpleCallback(ItemTouchHelper.ANIMATION_TYPE_DRAG,ItemTouchHelper.LEFT |  ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            InterestItemList.remove(viewHolder.getAdapterPosition());
            myAdapter.notifyDataSetChanged();

        }
    };

    public void addAndShowData(View view){
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        InterestItemList.add(text.get());
        myAdapter.notifyDataSetChanged();


    }

    public void saveData(){
        utils.setSharedPreferences(InterestFrag.applicationContext,sharedPrefName);
        utils.putList(sharedPrefName,InterestItemList);
        Toast.makeText(InterestFrag.applicationContext,"Data Saved",Toast.LENGTH_SHORT).show();
    }

    public void setMandatoryDetails(){
        recyclerView=InterestFrag.recyclerView;
        InterestItemList=InterestFrag.interestItemList;
        myAdapter= new InterestAdapter(InterestItemList);
        new ItemTouchHelper(itemTouchHelper).attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(myAdapter);

    }

    public void readData(){
        utils.setSharedPreferences(InterestFrag.applicationContext,sharedPrefName);
        Set<String> data= utils.getDataObject(sharedPrefName);
        if(data.size()>0) {
            InterestItemList.clear();
            for (String s : data) {
                InterestItemList.add(s);
            }
        }
        myAdapter.notifyDataSetChanged();
    }




}
