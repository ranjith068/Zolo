package com.zolo.viewmodel;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.Observable;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import com.zolo.MainActivity;
import com.zolo.MyApplication;
import com.zolo.R;
import com.zolo.view.ui.fragments.LoginFragment;
import com.zolo.view.ui.fragments.RegisterFragment;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Provides;

/**
 * Created by ranjith on 12/5/17.
 */

//public class LoginViewModel extends ViewModel {
//
//    private Context context;
//
//    @Inject
//    public LoginViewModel(MyApplication application) {
//
//        this.context = application;
//
//
//    }
//
//
//}


public class LoginViewModel extends BaseObservable  {
    private String phonenumber;
    private String password;
    Context context;
//    private int busy;

    @Inject
    public LoginViewModel(String phonenumber, String password) {
        this.phonenumber = phonenumber;
        this.password = password;
//        this.busy = View.GONE;

    }

//    public LoginViewModel(LoginViewModel lvm) {
//        this.email = lvm.email;
//        this.password = lvm.password;
//        this.busy = lvm.busy;
//    }

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

//    @Bindable
//    public int getBusy() {
//        return this.busy;
//    }
//    public void setBusy(int busy) {
//        this.busy = busy;
//        notifyPropertyChanged(R.id.login_progress);
//    }

    public void onClick(final View view) {
        final String phonenumber = this.phonenumber;
        final String password = this.password;
//        setBusy(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
//                setBusy(View.GONE);
//                Snackbar.make(view, email + ", " + password, Snackbar.LENGTH_SHORT).show();

                Toast.makeText(view.getContext(), phonenumber + ", " + password, Toast.LENGTH_SHORT).show();
            }
        }, 500);
    }


    public void onRegisterClick(final View view) {

        Toast.makeText(view.getContext(), "register", Toast.LENGTH_SHORT).show();

//        RegisterFragment fragment = new RegisterFragment();
//        getSupportFragmentManager().beginTransaction()
//                .add(R.id.fragment_container, fragment, "LoginFragment").commit();
        ((MainActivity) view.getContext()).show();

    }

    public void onForgetPaswordClick(final View view) {

        Toast.makeText(view.getContext(), "forgot password", Toast.LENGTH_SHORT).show();

    }



}
