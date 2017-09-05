package com.zolo.di;




import com.zolo.view.ui.fragments.LoginFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract LoginFragment contributeLoginFragment();
//
//    @ContributesAndroidInjector
//    abstract ProjectListFragment contributeProjectListFragment();
}
