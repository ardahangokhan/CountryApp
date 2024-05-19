package com.ardahangokhan.countries.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ardahangokhan.countries.model.Country

@Dao
interface CountryDao {

    //Data Access Object
    @Insert
    suspend fun insertAll(vararg countries: Country): List<Long>
    //Insert --> Insert Into
    //suspend : coroutine içinden çağırılıyor. durdurulup devam ettirmeye olanak veriyor.
    //vararg --> sayısını bilmediğimiz tekil objeyi tek tek veya çift çift veya hepsini verimemize yarıyor.
    // yani tek tek country sınıfının öğesini vermek yada tüm list i vermek gibi değil de istediğimiz kadar değişkeni istediğimiz aralıkta vermek diyebiliriz.
    //List<Long> --> primary key i geri döndürüyor


    @Query("SELECT * FROM country")
    suspend fun getAllCountries(): List<Country>

    @Query("SELECT * FROM country WHERE uuid=:countryId")
    suspend fun getCountry(countryId: Int): Country

    @Query("DELETE FROM country")
    suspend fun deleteAllCountries()

}