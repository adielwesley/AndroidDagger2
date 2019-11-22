package com.example.tools.di.modules

import androidx.lifecycle.ViewModel
import com.example.tools.ViewModelKey
import com.example.tools.features.jokes.JokesViewModel
import com.example.tools.features.movies.MovieViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel::class)
    abstract fun bindDetailsViewModel(viewModel: MovieViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(JokesViewModel::class)
    abstract fun bindDetailsViewModel(viewModel: JokesViewModel) : ViewModel
}