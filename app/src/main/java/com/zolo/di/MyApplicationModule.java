package com.zolo.di;

/**
 * Created by ranjith on 5/9/17.
 */

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


import com.zolo.MyApplication;
import com.zolo.viewmodel.LoginViewModel;
import com.zolo.viewmodel.ProjectViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(subcomponents = ViewModelSubComponent.class)
class MyApplicationModule {

    private final Application mApplication;



    public MyApplicationModule(Application app) {
        mApplication = app;
    }



    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    SharedPreferences provideSharedPrefs() {
        return mApplication.getSharedPreferences("demo-prefs", Context.MODE_PRIVATE);
    }


}