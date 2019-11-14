package com.example.tools.features.login

import android.util.Log
import com.example.tools.features.model.Joke
import com.example.tools.services.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepository @Inject constructor(private val apiService: ApiService) {

    fun getData(): Call<MutableList<Joke>> {
        return apiService.get()
    }
}