package com.ardahangokhan.countries.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.ardahangokhan.countries.model.Country
import com.ardahangokhan.countries.service.CountryDatabase
import kotlinx.coroutines.launch

class CountryViewModel(application: Application) :BaseViewModel(application) {

    val countryLiveData = MutableLiveData<Country>()

    fun getDataFromRoom(uuid:Int){

        launch {
            val dao = CountryDatabase(getApplication()).countryDao()
            val country = dao.getCountry(uuid)
            countryLiveData.value = country
        }

    }

}