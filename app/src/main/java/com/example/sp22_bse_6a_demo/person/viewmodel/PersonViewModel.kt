package com.example.sp22_bse_6a_demo.person.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.sp22_bse_6a_demo.person.model.PersonModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PersonViewModel : ViewModel() {  // MMVM Android Kotlin
//    val person: PersonModel = PersonModel()

    private val counterMLD: MutableLiveData<Int> = MutableLiveData(0)

    val counterLD: LiveData<Int> = counterMLD

    val counterAsStringLD: LiveData<String> = counterLD.map { it ->
        it.toString()
    }

    private val speedMLD: MutableLiveData<Long> = MutableLiveData(500)


    init {
        viewModelScope.launch(Dispatchers.IO) {
            while (true) {
                delay((speedMLD.value?:10))

                counterMLD.postValue((counterMLD.value ?: 0) + 1)
            }
        }
    }


    // Live data

    val personMLD: MutableLiveData<PersonModel> = MutableLiveData(PersonModel())


    fun handelSaveButton() {
        Log.e("PersonViewModel", "handelSaveButtonClick: Button clicked")
        personMLD.value = personMLD.value?.copy()
    }

    fun handelClearButton() {
        Log.e("PersonViewModel", "handelClearButtonClick: Button clicked")
        personMLD.value = PersonModel()
    }

    fun slowSpeed() {
        speedMLD.value = (speedMLD.value?:0) + 100
    }

    fun fastSpeed() {
        speedMLD.value = (speedMLD.value?:0) - 100
    }


}