package com.zolo;

import android.arch.lifecycle.LifecycleActivity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Toast;

import com.zolo.databinding.ActivityProfileBinding;
import com.zolo.utils.DataManager;
import com.zolo.utils.UserModel;
import com.zolo.view.ui.fragments.ForgetPasswordFragment;
import com.zolo.view.ui.fragments.LoginFragment;
import com.zolo.view.ui.fragments.RegisterFragment;
import com.zolo.viewmodel.LoginViewModel;
import com.zolo.viewmodel.ProfileViewModel;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class ProfileActivity extends LifecycleActivity implements HasSupportFragmentInjector {


    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;
    @Inject
    DataManager mDataManager;

    private ActivityProfileBinding binding;
    private String name;
    private String email;
    private String phonenumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding = DataBindingUtil.setContentView(this,R.layout.activity_profile);

        name = mDataManager.getData("name");
        email = mDataManager.getData("email");
        phonenumber = mDataManager.getData("phonenumber");

        ProfileViewModel profileViewModel = new ProfileViewModel(phonenumber,name,email);

        binding.setProfileViewModel(profileViewModel);
        binding.setHandler(profileViewModel);

    }


    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }

    public void logout() {
        mDataManager.saveData("login","");
        finish();
    }

}
