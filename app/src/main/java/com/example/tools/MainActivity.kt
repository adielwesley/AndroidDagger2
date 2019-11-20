package com.example.tools

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.tools.di.components.JokesComponent
import com.example.tools.di.components.LoginComponent
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.*

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
        jokesComponent =
            (applicationContext as MyApplication).appComponent.jokesComponent().create()
        // Make Dagger instantiate @Inject fields in LoginActivity
        jokesComponent.inject(this)

        loginComponent = (application as MyApplication).appComponent.loginComponent().create()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Cria uma lista de Usuarios, simulando como se fosse de uma api por ex
        val users = mutableListOf(
            UserApi("A", 5, Date(), "M"),
            UserApi("B", 6, Date(), "M"),
            UserApi("C", 5, Date(), "F"),
            UserApi("V", 6, Date(), "F")
        )

        // Cria um stream ( corrente de dados) a partir da lista de usuarios, para ser emitido por um subscriber/observador
        val stream = Observable.fromArray(users)

        //Aqui nós aplicamos o flatMap, que nos permite reemitir a nossa cadeia de maneiras distintas, para obter alguma informacão especifica
        stream.flatMap { usersApi ->

            // O parametro usersApi é uma mutableList, para que possamos percorrer essa mutableList aproveitando os recursos do Rx,
            //nós precisamos emitir cada item como um Observable, para isso podemos utilizar o fromIterable
            val ages = Observable.fromIterable(usersApi)
                .map { u -> u.age }
                .reduce { a, b -> a + b }
                .map {
                    total -> total / users.size
                }
                .map { total -> Pair<String, Int>("Media de idade", total) }
                .toObservable()// Aqui convertemos o Stream do tipo Maybe para Observable, para que posssamos continuar trantando como uma stream de dados

            val males = Observable.fromIterable(usersApi)
                .filter { users -> users.gender == "M" }
                .count()
                .map { total -> Pair<String, Int>("Media de Homens", total.toInt()) }
                .toObservable()



            val females = Observable.fromIterable(usersApi)
                .filter { users -> users.gender == "F" }
                .count()
                .map { total -> Pair<String, Int>("Media de mulheres", total.toInt()) }
                .toObservable()

            //Aqui estamos para que possamos passar os resultados para o proximo operador, precisamos reemitir como um observable unico, entao usamos o merge
            Observable.merge(ages, males, females)

            // o subscribe emiti a chamada para nosso stream ser executado
        }.subscribe({ result ->
            Log.d("result", "${result.first} -  ${result.second}")
        }, { error ->
            Log.d("result", error.toString())
        })

        //findNavController(R.id.nav_host_fragment).navigate(R.id.jokes_graph)
    }

    inner class UserApi(var name: String, var age: Int, bday: Date, var gender: String)
    inner class UserApp(var name: String, var age: Int)
}
