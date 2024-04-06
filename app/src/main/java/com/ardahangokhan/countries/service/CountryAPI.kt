package com.ardahangokhan.countries.service

import com.ardahangokhan.countries.model.Country
import io.reactivex.Single
import retrofit2.http.GET

interface CountryAPI {

    //GET,POST
    //https://raw.githubusercontent.com/ardahangokhan/Countries/main/countries.json
    // BASE_URL -> https://raw.githubusercontent.com/
    //EXT -> ardahangokhan/Countries/main/countries.json

    @GET("ardahangokhan/Countries/main/countries.json")
    fun getCountries():Single<List<Country>>


}