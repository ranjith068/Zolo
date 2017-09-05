package com.zolo;

import android.arch.lifecycle.LifecycleActivity;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;

import com.zolo.view.ui.fragments.LoginFragment;

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

//    /** Shows the project detail fragment */
//    public void show(Project project) {
//        ProjectFragment projectFragment = ProjectFragment.forProject(project.name);
//
//        getSupportFragmentManager()
//                .beginTransaction()
//                .addToBackStack("project")
//                .replace(R.id.fragment_container,
//                        projectFragment, null).commit();
//    }

    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
