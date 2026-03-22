package com.example.productionmindsetxmlretrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class JokeViewModel : ViewModel() {
    val jokeLiveData = MutableLiveData<String>()
    fun getJoke() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getJoke()

                if (response.isSuccessful) {
                    val data = response.body()

                    val jokeText = if (data?.type == "single") {
                        data.joke
                    } else {
                        "${data?.setup}\n\n${data?.delivery}"
                    }

                    jokeLiveData.postValue(jokeText ?: "No joke found")

                } else {
                    jokeLiveData.postValue("Error: ${response.code()}")
                }

            } catch (e: Exception) {
                jokeLiveData.postValue("Exception: ${e.message}")
            }
        }
    }
}