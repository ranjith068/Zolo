package com.zolo.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;


import com.zolo.MainActivity;

import com.zolo.R;

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

//        Toast.makeText(view.getContext(), "register", Toast.LENGTH_SHORT).show();

        ((MainActivity) view.getContext()).show();

    }

    public void onForgetPaswordClick(final View view) {

//        Toast.makeText(view.getContext(), "forgot password", Toast.LENGTH_SHORT).show();

        ((MainActivity) view.getContext()).forgotPassWord();


    }



}
