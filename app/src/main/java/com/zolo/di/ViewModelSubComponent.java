package com.zolo.di;




import com.zolo.viewmodel.LoginViewModel;

import dagger.Subcomponent;


@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }

//    LoginViewModel projectListViewModel();
    LoginViewModel loginViewModel();
}
