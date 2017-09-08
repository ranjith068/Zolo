package com.zolo;

import android.arch.lifecycle.LifecycleActivity;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.zolo.utils.DataManager;
import com.zolo.utils.UserModel;
import com.zolo.view.ui.fragments.ForgetPasswordFragment;
import com.zolo.view.ui.fragments.LoginFragment;
import com.zolo.view.ui.fragments.RegisterFragment;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends LifecycleActivity implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;
    @Inject
    DataManager mDataManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LoginFragment fragment = new LoginFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment, "LoginFragment").commit();

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

    /** Shows the register fragment */
    public void forgotPassWord() {
        ForgetPasswordFragment forgetPasswordFragment = new ForgetPasswordFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack("ForgetPasswordFragment")
                .replace(R.id.fragment_container,
                        forgetPasswordFragment, "ForgetPasswordFragment").commit();
    }

    public  void login(String phonenumber,String password){

        new Handler().postDelayed(() -> {
//                Snackbar.make(view, email + ", " + password, Snackbar.LENGTH_SHORT).show();
            try {
                if(mDataManager.getCount()==0){
                    Log.d("yyy","countttt00000");
                    Toast.makeText(MainActivity.this, "No User is registered", Toast.LENGTH_SHORT).show();

                }else {
                    if (phonenumber.length() > 0) {
                        if (password.length() > 0) {

                            if(mDataManager.checkLogin(phonenumber,password)) {
                                Toast.makeText(MainActivity.this, "Login", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(MainActivity.this, "Entered phone/password is invalid", Toast.LENGTH_SHORT).show();

                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Password field is Empty", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Phone field is Empty", Toast.LENGTH_SHORT).show();
                    }

                    Toast.makeText(MainActivity.this, phonenumber + ", " + password, Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 500);
    }


    public  void register(String phonenumber,String password,String email,String name){

        new Handler().postDelayed(() -> {
//                Snackbar.make(view, email + ", " + password, Snackbar.LENGTH_SHORT).show();
            if (phonenumber.length() > 0) {
                if (email.length() > 0) {
                    if (name.length() > 0) {
                        if (password.length() > 0) {

                            try {
                                if(mDataManager.checkNumber(phonenumber)){
                                    Toast.makeText(MainActivity.this, "User already exists", Toast.LENGTH_SHORT).show();

                                }else{
                                    Toast.makeText(MainActivity.this, "Registering user...", Toast.LENGTH_SHORT).show();

                                    mDataManager.createUser(new UserModel(phonenumber, email, password, name));
                            }
                            }catch (Exception e) {
                                e.printStackTrace();
                            }

                        } else {
                            Toast.makeText(MainActivity.this, "Password field is Empty", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Name field is Empty", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Email field is Empty", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(MainActivity.this, "Phone field is Empty", Toast.LENGTH_SHORT).show();
            }

        }, 500);
    }



    public void reset() {

    }


    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
