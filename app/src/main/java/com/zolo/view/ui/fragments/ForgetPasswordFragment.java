package com.zolo.view.ui.fragments;


import android.arch.lifecycle.LifecycleFragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zolo.R;
import com.zolo.databinding.FragmentForgetPasswordBinding;
import com.zolo.databinding.FragmentRegisterBinding;
import com.zolo.di.Injectable;
import com.zolo.viewmodel.ForgetPasswordViewModel;
import com.zolo.viewmodel.LoginViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForgetPasswordFragment extends LifecycleFragment implements Injectable {
    private FragmentForgetPasswordBinding binding;


    public ForgetPasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         binding = DataBindingUtil.inflate(inflater, R.layout.fragment_forget_password, container, false);
        ForgetPasswordViewModel fgPwdViewModel = new ForgetPasswordViewModel("");


        binding.setForgetPasswordViewModel(fgPwdViewModel);
        binding.setHandler(fgPwdViewModel);


        // Inflate the layout for this fragment
        return binding.getRoot();
    }





}
