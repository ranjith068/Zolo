package com.zolo.utils;

import android.content.Context;

import com.zolo.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by ranjith on 7/9/17.
 */

@Singleton
public class DataManager {

    private Context mContext;
    private Database mDbHelper;
    private AppPreferences mSharedPrefsHelper;

    @Inject
    public DataManager(@ApplicationContext Context context,Database dbHelper,
                       AppPreferences sharedPrefsHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mSharedPrefsHelper = sharedPrefsHelper;
    }

    public void saveData(String tag,String value) {
        mSharedPrefsHelper.SaveData(tag, value);
    }

    public String getData(String tag){
        return mSharedPrefsHelper.getData(tag);
    }

    public void createUser(UserModel user) throws Exception {
         mDbHelper.addUser(user);
    }


    public void updateUser(UserModel user,String phonenumber) throws Exception {
        mDbHelper.updateUser(user,phonenumber);
    }

    public int getCount() throws Exception {
        return mDbHelper.getUsersCount();
    }


    public boolean checkNumber(String phonenumber) throws Exception {
        return mDbHelper.phoneNumberExists(phonenumber);
    }

    public boolean checkPassword(String password) throws Exception {
        return mDbHelper.passwordExists(password);
    }

    public boolean checkLogin(String phonenumber,String password) throws Exception {
        return mDbHelper.loginExists(phonenumber,password);
    }

    public UserModel getUser(String phonenumber) throws  Exception {
        return mDbHelper.getUser(phonenumber);
    }
}