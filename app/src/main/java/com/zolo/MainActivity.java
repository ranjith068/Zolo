package com.zolo;

import android.arch.lifecycle.LifecycleActivity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.zolo.utils.DataManager;
import com.zolo.utils.UserModel;
import com.zolo.view.ui.fragments.ForgetPasswordFragment;
import com.zolo.view.ui.fragments.LoginFragment;
import com.zolo.view.ui.fragments.RegisterFragment;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends LifecycleActivity implements HasSupportFragmentInjector {

    String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    SecureRandom rnd = new SecureRandom();

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;
    @Inject
    DataManager mDataManager;

    FrameLayout frameLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = (FrameLayout)findViewById(R.id.fragment_container);

       if(mDataManager.getData("login").equals("")){

           LoginFragment fragment = new LoginFragment();

           getSupportFragmentManager().beginTransaction()
                   .replace(R.id.fragment_container, fragment, "LoginFragment").commit();

       }else{

           startActivity(new Intent(MainActivity.this,ProfileActivity.class));
           finish();
       }



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

    /** Shows the forget password fragment */
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
            try {
                if(mDataManager.getCount()==0){
                    Snackbar.make(frameLayout, "No User is registered", Snackbar.LENGTH_SHORT).show();

                }else {
                    if (phonenumber.length() > 0) {
                        if (password.length() > 0) {

                            if(mDataManager.checkLogin(phonenumber,password)) {


                                mDataManager.saveData("login","sucess");

                                mDataManager.saveData("phonenumber",mDataManager.getUser(phonenumber).get_phonenumber());
                                mDataManager.saveData("name",mDataManager.getUser(phonenumber).get_name());
                                mDataManager.saveData("email",mDataManager.getUser(phonenumber).get_email());

                                startActivity(new Intent(MainActivity.this,ProfileActivity.class));
                                finish();
                            }else{
                                Snackbar.make(frameLayout, "Entered phone/password is invalid", Snackbar.LENGTH_SHORT).show();

                            }
                        } else {
                            Snackbar.make(frameLayout, "Password field is Empty", Snackbar.LENGTH_SHORT).show();

                        }
                    } else {
                        Snackbar.make(frameLayout, "Phone field is Empty", Snackbar.LENGTH_SHORT).show();

                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 500);
    }


    public  void register(String phonenumber,String password,String email,String name){

        new Handler().postDelayed(() -> {
            if (phonenumber.length() > 0) {
                if (email.length() > 0) {
                    if (name.length() > 0) {
                        if (password.length() > 0) {

                            try {
                                if(mDataManager.checkNumber(phonenumber)){
                                    Snackbar.make(frameLayout, "PhoneNumber already exists", Snackbar.LENGTH_SHORT).show();
                                }else{
                                    if(isEmailValid(email)){

                                        mDataManager.createUser(new UserModel(phonenumber, email, name,password));

                                        Snackbar.make(frameLayout, "Register user success...", Snackbar.LENGTH_SHORT).show();

                                        LoginFragment fragment = new LoginFragment();
                                        getSupportFragmentManager().beginTransaction()
                                                .replace(R.id.fragment_container, fragment, "LoginFragment").commit();

                                    }else{
                                        Snackbar.make(frameLayout, "Email not in valid format", Snackbar.LENGTH_SHORT).show();

                                    }
                            }
                            }catch (Exception e) {
                                e.printStackTrace();
                            }

                        } else {
                            Snackbar.make(frameLayout, "Password field is Empty", Snackbar.LENGTH_SHORT).show();

                        }
                    } else {
                        Snackbar.make(frameLayout, "Name field is Empty", Snackbar.LENGTH_SHORT).show();

                    }
                } else {
                    Snackbar.make(frameLayout, "Email field is Empty", Snackbar.LENGTH_SHORT).show();

                }
            } else {
                Snackbar.make(frameLayout, "Phone field is Empty", Snackbar.LENGTH_SHORT).show();

            }

        }, 500);
    }



    public void reset(String email) {
        if(isEmailValid(email)){

            String[] addresses =  new String [] {email};
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, addresses);
            intent.putExtra(Intent.EXTRA_SUBJECT, "Zolo Forget Password...");
            intent.putExtra(Intent.EXTRA_TEXT,randomString(5));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

        }else{
            Snackbar.make(frameLayout, "Email not in valid format", Snackbar.LENGTH_SHORT).show();

        }
    }





    String randomString( int len ){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }


    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }

    public static boolean isEmailValid(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }
}
