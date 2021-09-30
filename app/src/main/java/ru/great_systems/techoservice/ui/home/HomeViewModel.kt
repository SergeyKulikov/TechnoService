package ru.great_systems.techoservice.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.great_systems.techoservice.R

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
       // value = R.string.sample_text.toString()
    }
    val text: LiveData<String> = _text
}