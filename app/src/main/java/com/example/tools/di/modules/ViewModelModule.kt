package com.example.tools.di.modules

import androidx.lifecycle.ViewModel
import com.example.tools.ViewModelKey
import com.example.tools.features.login.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindDetailsViewModel(viewModel: LoginViewModel) : ViewModel
}