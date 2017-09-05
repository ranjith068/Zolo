package com.zolo.di;

/**
 * Created by ranjith on 5/9/17.
 */

import android.app.Application;

import com.zolo.MyApplication;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;


@Component(modules = { AndroidInjectionModule.class, MyApplicationModule.class,MainActivityModule.class})
public interface MyApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        MyApplicationComponent build();
    }
    void inject(MyApplication myApplication);
}