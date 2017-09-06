package com.zolo.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.zolo.MainActivity;
import com.zolo.R;

import javax.inject.Inject;

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

public class RegisterViewModel extends BaseObservable  {
    private String phonenumber;
    private String password;
    Context context;
//    private int busy;

    @Inject
    public RegisterViewModel(String phonenumber, String password) {
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




    public void onRegisterClick(final View view) {

        Toast.makeText(view.getContext(), "register", Toast.LENGTH_SHORT).show();

//        RegisterFragment fragment = new RegisterFragment();
//        view.getContext().getSupportFragmentManager().beginTransaction()
//                .add(R.id.fragment_container, fragment, "LoginFragment").commit();


        ((MainActivity) view.getContext()).show();

    }





}
