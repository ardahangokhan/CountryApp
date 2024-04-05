package com.ardahangokhan.countries.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ardahangokhan.countries.model.Country

class CountryViewModel:ViewModel() {

    val countryLiveData = MutableLiveData<Country>()

    fun getDataFromRoom(){
        val country = Country("Turkey","Europe","Ankara","TRY","Turkish","www.googl.com")
        countryLiveData.value= country
    }

}