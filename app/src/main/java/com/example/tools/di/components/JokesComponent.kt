package com.example.tools.di.components

import com.example.tools.MainActivity
import com.example.tools.di.scopes.ActivityScope
import com.example.tools.features.jokes.JokesFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface JokesComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): JokesComponent
    }

    fun inject(activity: MainActivity)
    fun inject(jokesFragment: JokesFragment)
}