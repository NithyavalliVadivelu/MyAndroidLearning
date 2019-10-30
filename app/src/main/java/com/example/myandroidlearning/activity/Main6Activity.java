package com.example.myandroidlearning.activity;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;

import com.example.myandroidlearning.ExampleAdapter;
import com.example.myandroidlearning.ExampleItem;
import com.example.myandroidlearning.Model.Main;
import com.example.myandroidlearning.Model.RetroPhoto;
import com.example.myandroidlearning.R;
import com.example.myandroidlearning.services.GetServices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main6Activity extends AppCompatActivity {

    private RecyclerView myRecyclerview;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.Adapter myNewAdapter;

    private RecyclerView.LayoutManager myLayoutManager;
    private Button checkButton;
    private CompositeDisposable compositeDisposable=new CompositeDisposable();

    ArrayList<ExampleItem> exampleItemArrayList= new ArrayList<>();

    ArrayList<Main> mainArraylist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


        List<String> textString= Arrays.asList(getResources().getStringArray(R.array.spinner_array));
        for (String text:textString
        ) {
            exampleItemArrayList.add(new ExampleItem(text));
        }
        myRecyclerview=findViewById(R.id.recyclerview);
        myRecyclerview.setHasFixedSize(true);
        myAdapter=new ExampleAdapter(exampleItemArrayList);
        myLayoutManager=new LinearLayoutManager(this);
        myRecyclerview.setAdapter(myAdapter);
        myRecyclerview.setLayoutManager(myLayoutManager);
        checkButton=findViewById(R.id.check_button);
       /* checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Observable<String> stringObservable=Observable.just("New line1gakjhdfglskdjg;JSG;sdgh;sdgh;sdlkghcccccccc","New Line2","New line3");

                Observable<ExampleItem> exampleItemObservable= Observable.create(new ObservableOnSubscribe<ExampleItem>() {
                    @Override
                    public void subscribe(ObservableEmitter<ExampleItem> emitter) throws Exception {
                        for (ExampleItem EI:exampleItemArrayList
                             ) {
                            if(!emitter.isDisposed()){
                                emitter.onNext(EI);
                            }
                        }

                        if(!emitter.isDisposed()){
                            emitter.onComplete();
                        }
                    }
                });


                DisposableObserver<ExampleItem> exampleItemObserver= new DisposableObserver<ExampleItem>() {


                    @Override
                    public void onNext(ExampleItem exampleItem) {
                        exampleItemArrayList.add(exampleItem);
                        myAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                };

                Observer<String> stringObserver= new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i("@Nithya","===onsubcribe==>"+d);
                    }

                    @Override
                    public void onNext(String s) {
                        Log.i("@Nithya","====onNext=>"+s);
                        exampleItemArrayList.add(new ExampleItem(s));
                        myAdapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("@Nithya","Error=====>"+e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.i("@Nithya","COmpleted");
                    }
                };
                compositeDisposable.add(exampleItemObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(exampleItemObserver));

                stringObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) throws Exception {
                        if(s.length()>20)
                        return true;
                        else return false;
                    }
                }).map(new Function<String, String>() {

                    @Override
                    public String apply(String s) throws Exception {
                        s=s.replace("c","@");
                        return s;
                    }
                }).subscribe(stringObserver);

                stringObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) throws Exception {
                        if(s.length()>20)
                            return true;
                        else return false;
                    }
                }).subscribe(stringObserver);
            }
        });
*/

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("hereeeeeeee===1111111111111=============>");
                Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com").addConverterFactory(GsonConverterFactory.create()).build();
                System.out.println("hereeeeeeee======122222==========>");
                GetServices services=retrofit.create(GetServices.class);
                System.out.println("hereeeeeeee========333333333========>");
                Call<List<RetroPhoto>> call=services.getAllPhotos();
                System.out.println("hereeeeeeee====44444444============>"+call);
               /* try {
                    System.out.println("going to execurteeeeeee");
                    Response<List<RetroPhoto>> details=  call.execute();
                    System.out.println("details=============>"+details.body().size());
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
                call.enqueue(new Callback<List<RetroPhoto>>() {
                    @Override
                    public void onResponse(Call<List<RetroPhoto>> call, Response<List<RetroPhoto>> response) {
                        if(!response.isSuccessful()){
                            System.out.println("in failurrrrrrrrrrrrrrrrrr");
                            exampleItemArrayList.removeAll(exampleItemArrayList);
                            exampleItemArrayList.add(new ExampleItem(response.code()+""));
                            myAdapter.notifyDataSetChanged();
                            return;
                        }
                        System.out.println("hewrwrwrwrwerwrwrrwrwrrwr");
                        List<RetroPhoto> weatherDetailsList=response.body();
                        exampleItemArrayList.removeAll(exampleItemArrayList);
                        for (RetroPhoto wd:weatherDetailsList){
                            exampleItemArrayList.add(new ExampleItem(wd.getTitle()+""));
                            myAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<RetroPhoto>> call, Throwable t) {
                        System.out.println("in Failure ==========================");
                    }
                });
            }
        });



    }




}
