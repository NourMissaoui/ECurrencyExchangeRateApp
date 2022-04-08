package com.example.ecurrencyexchangeapp.ui.currencyui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ecurrencyexchangeapp.R
import com.example.ecurrencyexchangeapp.data.remote.entities.currencyRateEntities.CurrencRateEntity

class CurrencyExchangeRateAdapter(private val dataSet: List<CurrencRateEntity>) :
    RecyclerView.Adapter<CurrencyExchangeRateAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CurrencyExchangeRateAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_currency_layout, parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: CurrencyExchangeRateAdapter.ViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.tv_country_name).text = dataSet[position].CountryName
    }

    override fun getItemCount() = dataSet.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        init {

        }
    }

}