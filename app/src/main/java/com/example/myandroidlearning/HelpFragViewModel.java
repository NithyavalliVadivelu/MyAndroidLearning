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

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;


public class HelpFragViewModel extends ViewModel {

    public ObservableField<String> text=new ObservableField<>();
    public RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    SharedPrefUtils utils=new SharedPrefUtils();
    public String sharedPrefName="help_pref";
    public List<String> helpItemList=HelpFrag.helpItemList;
    public HelpFragViewModel() { }
    public HelpFragViewModel(ObservableField<String> text) {
        this.text = text;
    }

    ItemTouchHelper.SimpleCallback itemTouchHelper= new ItemTouchHelper.SimpleCallback(ItemTouchHelper.ANIMATION_TYPE_DRAG,ItemTouchHelper.LEFT |  ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            helpItemList.remove(viewHolder.getAdapterPosition());
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

        helpItemList.add(text.get());
        myAdapter.notifyDataSetChanged();
       /* Observable<HelpItem> helpItemObservable = Observable.create(new ObservableOnSubscribe<HelpItem>() {
            @Override
            public void subscribe(ObservableEmitter<HelpItem> emitter) throws Exception {

                for(HelpItem HI:helpItemList){
                    emitter.onNext(HI);
                }
                if(!emitter.isDisposed()){
                    emitter.onComplete();
                }
            }
        });

        Observer<HelpItem> helpItemObserver=new Observer<HelpItem>() {
            @Override
            public void onSubscribe(Disposable d) {
            System.out.println("@Subcription   :  "+d);
            }

            @Override
            public void onNext(HelpItem helpItem) {
                System.out.println("=================>"+helpItem.getText());
                    helpItemList.add(helpItem);
                    myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable e) {
                Log.e("@Error",e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.i("@info","Completed");
            }
        };

        helpItemObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(helpItemObserver);*/

    }

    public void saveData(){
        utils.setSharedPreferences(HelpFrag.applicationContext,sharedPrefName);
        utils.putList(sharedPrefName,helpItemList);
        Toast.makeText(HelpFrag.applicationContext,"Data Saved",Toast.LENGTH_SHORT).show();
    }

    public void setMandatoryDetails(){
        recyclerView=HelpFrag.recyclerView;
        helpItemList=HelpFrag.helpItemList;
        myAdapter= new HelpAdapter(helpItemList);
        new ItemTouchHelper(itemTouchHelper).attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(myAdapter);

    }

    public void readData(){
        utils.setSharedPreferences(HelpFrag.applicationContext,sharedPrefName);
        Set<String> data= utils.getDataObject(sharedPrefName);
        if(data.size()>0) {
            helpItemList.clear();
            for (String s : data) {
                helpItemList.add(s);
            }
        }
        myAdapter.notifyDataSetChanged();
    }




}
