package com.example.tools

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.tools.di.components.JokesComponent
import com.example.tools.di.components.LoginComponent

class MainActivity : AppCompatActivity() {

    // Reference to the Login graph
    lateinit var loginComponent: LoginComponent

    lateinit var jokesComponent: JokesComponent

    override fun onCreate(savedInstanceState: Bundle?) {
//        // Creation of the login graph using the application graph
//        loginComponent = (applicationContext as MyApplication).appComponent.loginComponent().create()
//        // Make Dagger instantiate @Inject fields in LoginActivity
//        loginComponent.inject(this)

        // Creation of the login graph using the application graph
        jokesComponent = (applicationContext as MyApplication).appComponent.jokesComponent().create()
        // Make Dagger instantiate @Inject fields in LoginActivity
        jokesComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findNavController(R.id.nav_host_fragment).navigate(R.id.jokes_graph)
    }
}
