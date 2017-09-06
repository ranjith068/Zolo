package com.zolo.di;




import com.zolo.view.ui.fragments.LoginFragment;
import com.zolo.view.ui.fragments.RegisterFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract LoginFragment contributeLoginFragment();

    @ContributesAndroidInjector
    abstract RegisterFragment contributeRegisterFragment();
//
//    @ContributesAndroidInjector
//    abstract ProjectListFragment contributeProjectListFragment();
}
