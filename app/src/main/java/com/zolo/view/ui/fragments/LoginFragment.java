package com.zolo.view.ui.fragments;


import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.zolo.R;

import com.zolo.databinding.FragmentLoginBinding;
import com.zolo.di.Injectable;
import com.zolo.di.ViewModelSubComponent;
import com.zolo.utils.DataManager;
import com.zolo.viewmodel.LoginViewModel;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends LifecycleFragment implements Injectable {


//    @Inject
//    ViewModelProvider.Factory viewModelFactory;

//    @Inject
//    ViewModelSubComponent viewModelSubComponent;

    @Inject
    DataManager mDataManager;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentLoginBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);

        LoginViewModel loginViewModel = new LoginViewModel("", "");

        binding.setLoginViewModel(loginViewModel);
        binding.setHandler(loginViewModel);

        // Inflate the layout for this fragment
        return binding.getRoot();
    }





}
