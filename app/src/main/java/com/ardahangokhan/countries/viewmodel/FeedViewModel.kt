package com.ardahangokhan.countries.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.ardahangokhan.countries.model.Country
import com.ardahangokhan.countries.service.CountryAPIService
import com.ardahangokhan.countries.service.CountryDatabase
import com.ardahangokhan.countries.util.CustomSharedPreferences
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class FeedViewModel(application: Application) :BaseViewModel(application){
    private val countryApiService = CountryAPIService()
    private val disposable = CompositeDisposable()
    private var customPreferences = CustomSharedPreferences(getApplication())
    private var refreshTime = 10*60*1000*1000*1000L

    val countries = MutableLiveData<List<Country>>()
    val countryError = MutableLiveData<Boolean>()
    val countryLoading = MutableLiveData<Boolean>()

    fun refreshData(){
        val updateTime = customPreferences.getTime()
        if (updateTime!=null&&updateTime!=0L&&System.nanoTime()-updateTime<refreshTime){
            getDataFromSQLite()
        }
        else{
            getDataFromAPI()
        }
    }
    fun refreshFromAPI(){
        getDataFromAPI()
    }
    private fun getDataFromSQLite(){
        countryLoading.value=true
        launch {
            val countries = CountryDatabase(getApplication()).countryDao().getAllCountries()
            showCountries(countries)
            Toast.makeText(getApplication(),"Countries From SQLite",Toast.LENGTH_SHORT).show()
        }
    }

    private fun getDataFromAPI(){
        countryLoading.value=true
        disposable.add(
            countryApiService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Country>>(){
                    override fun onSuccess(t: List<Country>) {
                    storeInSQLite(t)
                        Toast.makeText(getApplication(),"Countries From API",Toast.LENGTH_SHORT).show()

                    }

                    override fun onError(e: Throwable) {
                    countryLoading.value=false
                        countryError.value=true
                        e.printStackTrace()

                    }
                })
        )
    }
    private fun showCountries(countryList: List<Country>){

        countries.value = countryList
        countryError.value = false
        countryLoading.value = false
    }
    private fun storeInSQLite(list:List<Country>){
        //normalde launch diyerek doğrudan coroutines i kullanabiliyoruz ancak bu fonksiyon bunu bilmediğim için öncelikle bunu tanıtmamız gerekiyor.

        launch {
            val dao = CountryDatabase(getApplication()).countryDao()
            dao.deleteAllCountries()
            //suspent fonksyonun içerisinde ne varsa önce sildik sonra;
            val listLong = dao.insertAll(*list.toTypedArray())
        //bir listeyi tekil eleman haline getirmek kotlin in bir özelliği ve biz burada bunu kullanıyoruz. -->individual
            var i = 0
            while (i<list.size){
                list[i].uuid = listLong[i].toInt()
                i += 1
                //uuid opsiyonel olduğu için burada tanımlanan bir öğeye uuid verme işlemi sağladık ve sonrasında showcountries ile bunları gösterdik.
            }
            showCountries(list)
        }
        customPreferences.saveTime(System.nanoTime())
    }
}