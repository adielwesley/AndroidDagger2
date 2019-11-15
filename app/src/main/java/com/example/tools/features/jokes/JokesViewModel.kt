package com.example.tools.features.jokes

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tools.features.login.LoginRepository
import com.example.tools.features.model.Joke
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class JokesViewModel@Inject constructor(private val loginRepository: LoginRepository) : ViewModel() {

    var jokes  = MutableLiveData<MutableList<Joke>>()

    init {

        loginRepository.getData()
            .enqueue(object : Callback<MutableList<Joke>> {
                override fun onFailure(call: Call<MutableList<Joke>>, t: Throwable) {

                }

                override fun onResponse(call: Call<MutableList<Joke>>, response: Response<MutableList<Joke>>) {
                    Log.d("log", response.body()?.size.toString())

                    response.body().let {
                        jokes.postValue(it)
                    }

                }

            })
    }

}