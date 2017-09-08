package com.zolo.di;

/**
 * Created by ranjith on 5/9/17.
 */

import android.app.Application;
import android.content.Context;

import com.zolo.MainActivity;
import com.zolo.MyApplication;
import com.zolo.utils.AppPreferences;
import com.zolo.utils.DataManager;
import com.zolo.utils.Database;
import com.zolo.view.ui.fragments.LoginFragment;
import com.zolo.viewmodel.LoginViewModel;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = { AndroidInjectionModule.class, MyApplicationModule.class,MainActivityModule.class})
public interface MyApplicationComponent {

//    @Component.Builder
//    interface Builder {
//        @BindsInstance
//        Builder application(Application application);
//        MyApplicationComponent build();
//    }
    void inject(MyApplication myApplication);
//    void inject(MainActivity mainActivity);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    AppPreferences getPreferenceHelper();

    Database getDbHelper();


}