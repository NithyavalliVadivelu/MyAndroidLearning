package com.example.myandroidlearning.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.example.myandroidlearning.Model.RegisterParamModel;
import com.example.myandroidlearning.activity.RegisterationSuccessActivity;
import com.example.myandroidlearning.activity.RegistrationActivity;
import com.example.myandroidlearning.providers.AccountProfileServiceProvider;
import com.example.myandroidlearning.services.AccountProfileServices;
import com.example.myandroidlearning.util.ResourceUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Response;

public class RegistrationViewModel extends ViewModel {

    public ObservableField<String> userName = new ObservableField<>("");
    public ObservableField<String> password = new ObservableField<>("");
    public ObservableField<String> confirmPassword = new ObservableField<>("");
    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> country = new ObservableField<>("");
    public ObservableField<Integer> visibility = new ObservableField<>(View.GONE);
    public ObservableField<Boolean> buttonvisibility = new ObservableField<>(false);
    Context context = ResourceUtil.getAppContext();
    boolean userNameFlag;
    boolean pwdFlag;
    boolean confirmPwdFlag;
    boolean countryFlag;
    boolean nameFlag;
    boolean passwordConfirmFlag = false;


    public RegistrationViewModel() {

    }

    public void onSelectItem(AdapterView<?> parent, View view, int pos, long id) {
        //pos                                 get selected item position
        //  get lable of selected item
        //parent.getAdapter().getItem(pos)    get item by pos
        //parent.getAdapter().getCount()      get item count
        //parent.getCount()                   get item count
        //parent.getSelectedItem()            get selected item
        //and other...
        country.set(parent.getSelectedItem().toString());
        checkValidity();

    }

    public void submitData() {
System.out.println("in submit data ---------------->"+passwordConfirmFlag);

        if (!passwordConfirmFlag)
            Toast.makeText(context, "Password mismatch found", Toast.LENGTH_LONG).show();
        else if (!userName.get().contains("@"))
            Toast.makeText(context, "Please enter the email id as username ", Toast.LENGTH_LONG).show();
        else {
            AccountProfileServices services = AccountProfileServiceProvider.getRetroInstance();
            services.register(new RegisterParamModel(name.get(), userName.get(), password.get(), country.get()))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<Response<ResponseBody>>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            visibility.set(View.VISIBLE);
                            RegistrationActivity.window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                        }

                        @Override
                        public void onNext(Response<ResponseBody> responseBodyResponse) {
                            System.out.println("network status======>" + responseBodyResponse.code());
                            visibility.set(View.GONE);
                            RegistrationActivity.window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                            if (responseBodyResponse.code() == 201) {

                                Intent intent = new Intent(context, RegisterationSuccessActivity.class);
                                context.startActivity(intent);
                            }else if (responseBodyResponse.code() == 500) {
                                Toast.makeText(context, "Something went wrong", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(context, "Something went wrong!! Please try again later", Toast.LENGTH_LONG).show();
                            }
                        }


                        @Override
                        public void onError(Throwable e) {
                            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
                            visibility.set(View.GONE);
                            RegistrationActivity.window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                        }

                        @Override
                        public void onComplete() {

                            visibility.set(View.GONE);
                            RegistrationActivity.window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                        }
                    });
        }

    }


    public void checkValidity() {

        System.out.println("came hereeeeeeeeeeeee");
        if (!userName.get().equalsIgnoreCase("")) {
            userNameFlag = true;
        } else userNameFlag = false;
        if (!password.get().equalsIgnoreCase("")) {
            pwdFlag = true;
        } else pwdFlag = false;
        if (!confirmPassword.get().equalsIgnoreCase("")) confirmPwdFlag = true;
        else confirmPwdFlag = false;
        if (!country.get().equalsIgnoreCase("") && !country.get().equalsIgnoreCase("Choose country"))
            countryFlag = true;
        else countryFlag = false;
        if (!name.get().equalsIgnoreCase("")) nameFlag = true;
        else nameFlag = false;

        System.out.println("pwdFlag && confirmPwdFlag===<"+pwdFlag +"__________"+ confirmPwdFlag+"---------------"+password.get()+"---------"+confirmPassword.get());
        if (pwdFlag && confirmPwdFlag) {
            if (password.get().equals(confirmPassword.get()) &&(!password.get().equalsIgnoreCase("") && !confirmPassword.get().equalsIgnoreCase(""))) {
                passwordConfirmFlag = true;
            } else passwordConfirmFlag = false;
        }
        System.out.println("userNameFlag && passwordConfirmFlag && countryFlag && nameFlag=======>" + userNameFlag + "====++>" + passwordConfirmFlag + "========>" + countryFlag + "=====>" + nameFlag);

        if (userNameFlag && pwdFlag && confirmPwdFlag && countryFlag && nameFlag) {
            buttonvisibility.set(true);

        } else {
            buttonvisibility.set(false);

        }

    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
        checkValidity();
    }

    public void afterTextChanged(Editable editable) {
        // check Fields For Empty Values
        checkValidity();
    }
}


