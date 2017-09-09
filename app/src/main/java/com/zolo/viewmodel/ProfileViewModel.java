package com.zolo.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;
import android.widget.Toast;

import com.zolo.MainActivity;
import com.zolo.ProfileActivity;
import com.zolo.R;

/**
 * Created by ranjith on 08/9/17.
 */


public class ProfileViewModel extends BaseObservable  {
    private String phonenumber;
    private String name;
    private String email;
    private String password;



    public ProfileViewModel(String phonenumber,String name,String email) {
        this.phonenumber = phonenumber;
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



    public void onLogoutClick(final View view) {


        ((ProfileActivity) view.getContext()).logout();

    }





}
