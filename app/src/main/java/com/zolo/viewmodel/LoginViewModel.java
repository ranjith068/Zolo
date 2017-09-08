package com.zolo.viewmodel;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.Observable;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.zolo.MainActivity;
import com.zolo.MyApplication;
import com.zolo.R;
import com.zolo.utils.DataManager;
import com.zolo.view.ui.fragments.LoginFragment;
import com.zolo.view.ui.fragments.RegisterFragment;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Provides;

/**
 * Created by ranjith on 12/5/17.
 */


public class LoginViewModel extends BaseObservable  {
    private String phonenumber;
    private String password;



    public LoginViewModel(String phonenumber, String password) {
        this.phonenumber = phonenumber;
        this.password = password;

    }



    @Bindable
    public String getPhonenumber() {
        return this.phonenumber;
    }
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
        notifyPropertyChanged(R.id.phonenumber);
    }

    @Bindable
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(R.id.password);
    }


    public void onClick(final View view) {
        final String phonenumber = this.phonenumber;
        final String password = this.password;

        ((MainActivity) view.getContext()).login(phonenumber,password);


    }


    public void onRegisterClick(final View view) {

        Toast.makeText(view.getContext(), "register", Toast.LENGTH_SHORT).show();

        ((MainActivity) view.getContext()).show();

    }

    public void onForgetPaswordClick(final View view) {

        Toast.makeText(view.getContext(), "forgot password", Toast.LENGTH_SHORT).show();

        ((MainActivity) view.getContext()).forgotPassWord();


    }



}
