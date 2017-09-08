package com.zolo.view.ui.fragments;


import android.arch.lifecycle.LifecycleFragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zolo.R;
import com.zolo.databinding.FragmentLoginBinding;
import com.zolo.databinding.FragmentRegisterBinding;
import com.zolo.di.Injectable;
import com.zolo.viewmodel.LoginViewModel;
import com.zolo.viewmodel.RegisterViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends LifecycleFragment implements Injectable {
    private FragmentRegisterBinding binding;


//    @Inject
//    ViewModelProvider.Factory viewModelFactory;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false);

        RegisterViewModel registerViewModel = new RegisterViewModel("", "","","");
        binding.setRegisterViewModel(registerViewModel);
        binding.setHandler(registerViewModel);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }





}
