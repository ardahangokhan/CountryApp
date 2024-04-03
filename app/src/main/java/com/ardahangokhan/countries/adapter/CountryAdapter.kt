package com.ardahangokhan.countries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ardahangokhan.countries.R
import com.ardahangokhan.countries.model.Country

class CountryAdapter(val countryList: ArrayList<Country>): RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {
    class CountryViewHolder (var view: View):RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view= inflater.inflate(R.layout.item_country,parent,false)
        return CountryViewHolder(view)
    }

    override fun getItemCount(): Int {

        return countryList.size

    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {


        holder.view.findViewById<TextView>(R.id.name).text= countryList[position].countryName
        holder.view.findViewById<TextView>(R.id.region).text=countryList[position].countryRegion

    }

    fun updateCountryList(newCountryList:List<Country>){
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()

    }

}