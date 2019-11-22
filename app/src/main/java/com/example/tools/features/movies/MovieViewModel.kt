package com.example.tools.features.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tools.features.model.Movie

class MovieViewModel : ViewModel() {

    lateinit var list : MutableLiveData<List<Movie>>
    lateinit var loading : MutableLiveData<Boolean>
    lateinit var error : MutableLiveData<Boolean>



}