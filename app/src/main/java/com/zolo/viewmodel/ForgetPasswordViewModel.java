package com.zolo.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;
import android.widget.Toast;

import com.zolo.MainActivity;
import com.zolo.R;

import javax.inject.Inject;

/**
 * Created by ranjith on 12/5/17.
 */


public class ForgetPasswordViewModel extends BaseObservable  {
    private String email;


    @Inject
    public ForgetPasswordViewModel(String email) {
        this.email = email;
    }



    @Bindable
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(R.id.email);
    }

    public void onResetClick(final View view) {


        ((MainActivity) view.getContext()).reset();

    }





}
