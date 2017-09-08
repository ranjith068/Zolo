package com.zolo.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.zolo.MainActivity;
import com.zolo.R;
import com.zolo.utils.DataManager;
import com.zolo.utils.UserModel;

import javax.inject.Inject;

/**
 * Created by ranjith on 12/5/17.
 */


public class RegisterViewModel extends BaseObservable {
    private String phonenumber;
    private String password;
    private String name;
    private String email;

//    @Inject
//    DataManager mDataManager;


    public RegisterViewModel(String phonenumber, String password, String name, String email) {
        this.phonenumber = phonenumber;
        this.password = password;
        this.name = name;
        this.email = email;
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

    @Bindable
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(R.id.name);
    }

    @Bindable
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(R.id.email);
    }


    public void onRegisterClick(final View view) {

        final String phonenumber = this.phonenumber;
        final String password = this.password;
        final String email = this.email;
        final String name = this.name;


//        Toast.makeText(view.getContext(), "register", Toast.LENGTH_SHORT).show();

        ((MainActivity) view.getContext()).register(phonenumber,password,email,name);

}





}
