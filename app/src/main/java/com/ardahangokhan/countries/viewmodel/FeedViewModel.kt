package com.ardahangokhan.countries.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ardahangokhan.countries.model.Country

class FeedViewModel:ViewModel() {
    val countries = MutableLiveData<List<Country>>()
    val countryError = MutableLiveData<Boolean>()
    val countryLoading = MutableLiveData<Boolean>()

    fun refreshData(){
        val country = Country("Turkey","Europe","Ankara","TRY","Turkish","www.googl.com")
        val country2 = Country("France","Europe","Paris","EUR","French","www.googl.com")
        val country3 = Country("Germany","Europe","Berlin","EUR","German","www.googl.com")

        val countryList = arrayListOf<Country>(country,country2,country3)
        countries.value = countryList
        countryError.value= false
        countryLoading.value=false
    }
}