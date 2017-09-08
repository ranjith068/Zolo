package com.zolo.di;




import com.zolo.viewmodel.LoginViewModel;

import dagger.Provides;
import dagger.Subcomponent;


@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }

//    ViewModelSubComponent getViewModelSubComponent();

//    LoginViewModel projectListViewModel();
    LoginViewModel loginViewModel();
}
