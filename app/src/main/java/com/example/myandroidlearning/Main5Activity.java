package com.example.myandroidlearning;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myandroidlearning.Model.Main;
import com.example.myandroidlearning.Model.Weather;
import com.example.myandroidlearning.Model.WeatherDetails;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main5Activity extends AppCompatActivity {

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


       /* List<String> textString= Arrays.asList(getResources().getStringArray(R.array.spinner_array));
        for (String text:textString
             ) {
            exampleItemArrayList.add(new ExampleItem(text));
        }*/
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
               exampleItemArrayList.clear();

               HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
               loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
               OkHttpClient okHttpClient=new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();
               Retrofit retrofit = new Retrofit.Builder().baseUrl("https://samples.openweathermap.org/").addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build();
               System.out.println("hereeeeeeee======122222==========>");
               GetServices services=retrofit.create(GetServices.class);
               System.out.println("hereeeeeeee========333333333========>");


               Call<WeatherDetails> call=services.getWeatherDetailsBasedOnCityName("India","b6907d289e10d714a6e88b30761fae22");
               System.out.println("hereeeeeeee====44444444============>"+call);

               call.enqueue(new Callback<WeatherDetails>() {
                   @Override
                   public void onResponse(Call<WeatherDetails> call, Response<WeatherDetails> response) {
                       if(!response.isSuccessful()){
                           System.out.println("in failurrrrrrrrrrrrrrrrrr");
                           exampleItemArrayList.removeAll(exampleItemArrayList);
                           exampleItemArrayList.add(new ExampleItem(response.code()+""));
                           myAdapter.notifyDataSetChanged();
                           return;
                       }
                       System.out.println("hewrwrwrwrwerwrwrrwrwrrwr");
                       WeatherDetails weatherDetailsList=response.body();

                           exampleItemArrayList.add(new ExampleItem("Temp : "+weatherDetailsList.getMain().getTemp()+"","Pressure : "+weatherDetailsList.getMain().getPressure()+" ","Humidity : "+weatherDetailsList.getMain().getHumidity(),"Temp_Min : "+weatherDetailsList.getMain().getTemp_min(),"Temp_Max : "+weatherDetailsList.getMain().getTemp_min()));
                           myAdapter.notifyDataSetChanged();

                   }

                   @Override
                   public void onFailure(Call<WeatherDetails> call, Throwable t) {
System.out.println("in Failure =========================="+t.getMessage());
                   }
               });
           }
       });



    }




}
