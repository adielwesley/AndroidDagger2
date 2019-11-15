package com.example.tools.features.jokes

import com.example.tools.features.model.Joke
import com.example.tools.services.ApiService
import retrofit2.Call
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class JokesRepository @Inject constructor(private val apiService: ApiService) {

    fun getData(): Call<MutableList<Joke>> {
        return apiService.get()
    }
}