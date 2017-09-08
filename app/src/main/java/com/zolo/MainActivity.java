package com.zolo;

import android.arch.lifecycle.LifecycleActivity;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.zolo.utils.DataManager;
import com.zolo.view.ui.fragments.LoginFragment;
import com.zolo.view.ui.fragments.RegisterFragment;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends LifecycleActivity implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LoginFragment fragment = new LoginFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, fragment, "LoginFragment").commit();

    }

    /** Shows the register fragment */
    public void show() {
        RegisterFragment registerFragment = new RegisterFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack("RegisterFragment")
                .replace(R.id.fragment_container,
                        registerFragment, "RegisterFragment").commit();
    }

    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
