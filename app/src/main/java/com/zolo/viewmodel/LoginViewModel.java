package com.zolo.viewmodel;

import android.arch.lifecycle.AndroidViewModel;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import com.zolo.MyApplication;
import com.zolo.R;

/**
 * Created by ranjith on 12/5/17.
 */

//public class LoginViewModel extends AndroidViewModel {
//
//    private Context context;
//
////    @Inject
//    public LoginViewModel(@NonNull MyApplication application) {
//        super(application);
//
//        this.context = application;
//
//
//    }
//
//
//}

public class LoginViewModel extends BaseObservable {
    private String email;
    private String password;
    private int busy;

    public LoginViewModel(String email, String password) {
        this.email = email;
        this.password = password;
        this.busy = View.GONE;
    }

    public LoginViewModel(LoginViewModel lvm) {
        this.email = lvm.email;
        this.password = lvm.password;
        this.busy = lvm.busy;
    }

    @Bindable
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(R.id.email);
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
    public int getBusy() {
        return this.busy;
    }
    public void setBusy(int busy) {
        this.busy = busy;
        notifyPropertyChanged(R.id.login_progress);
    }

    public void onClick(final View view) {
        final String email = this.email;
        final String password = this.password;
        setBusy(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                setBusy(View.GONE);
//                Snackbar.make(view, email + ", " + password, Snackbar.LENGTH_SHORT).show();

                Toast.makeText(view.getContext(), email + ", " + password, Toast.LENGTH_SHORT).show();
            }
        }, 500);
    }
}
