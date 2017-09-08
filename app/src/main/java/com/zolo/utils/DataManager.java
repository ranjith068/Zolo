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

//    public User getUser(Long userId) throws Resources.NotFoundException, NullPointerException {
//        return mDbHelper.getUser(userId);
//    }
}