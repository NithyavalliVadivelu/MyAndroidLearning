package com.example.myandroidlearning;

import android.os.StrictMode;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myandroidlearning.util.SharedPrefUtils;

import java.util.List;
import java.util.Set;


public class EventFragViewModel extends ViewModel {

    public ObservableField<String> text=new ObservableField<>();
    public RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    SharedPrefUtils utils=new SharedPrefUtils();
    public String sharedPrefName="event_pref";
    public List<String> eventItemList=EventFrag.eventItemList;
    public EventFragViewModel() { }
    public EventFragViewModel(ObservableField<String> text) {
        this.text = text;
    }

    ItemTouchHelper.SimpleCallback itemTouchHelper= new ItemTouchHelper.SimpleCallback(ItemTouchHelper.ANIMATION_TYPE_DRAG,ItemTouchHelper.LEFT |  ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            eventItemList.remove(viewHolder.getAdapterPosition());
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

        eventItemList.add(text.get());
        myAdapter.notifyDataSetChanged();


    }

    public void saveData(){
        utils.setSharedPreferences(EventFrag.applicationContext,sharedPrefName);
        utils.putList(sharedPrefName,eventItemList);
        Toast.makeText(EventFrag.applicationContext,"Data Saved",Toast.LENGTH_SHORT).show();
    }

    public void setMandatoryDetails(){
        recyclerView=EventFrag.recyclerView;
        eventItemList=EventFrag.eventItemList;
        myAdapter= new EventAdapter(eventItemList);
        new ItemTouchHelper(itemTouchHelper).attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(myAdapter);

    }

    public void readData(){
        utils.setSharedPreferences(EventFrag.applicationContext,sharedPrefName);
        Set<String> data= utils.getDataObject(sharedPrefName);
        if(data.size()>0) {
            eventItemList.clear();
            for (String s : data) {
                eventItemList.add(s);
            }
        }
        myAdapter.notifyDataSetChanged();
    }




}
