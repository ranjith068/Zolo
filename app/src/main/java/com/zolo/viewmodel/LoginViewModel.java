package com.zolo.viewmodel;

import android.arch.lifecycle.AndroidViewModel;
import android.content.Context;
import android.support.annotation.NonNull;

import com.zolo.MyApplication;

/**
 * Created by ranjith on 12/5/17.
 */

public class LoginViewModel extends AndroidViewModel {

    private Context context;

//    @Inject
    public LoginViewModel(@NonNull MyApplication application) {
        super(application);

        this.context = application;


    }


}
