package com.example.ecurrencyexchangeapp.ui.currencyui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.blongho.country_data.World
import com.example.ecurrencyexchangeapp.R
import com.example.ecurrencyexchangeapp.data.remote.entities.currencyRateEntities.CurrencRateEntity
import com.example.ecurrencyexchangeapp.databinding.FragmentCurrencyExchangeBinding
import com.example.ecurrencyexchangeapp.ui.currencyui.adapter.CurrencyExchangeRateAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrencyExchangeFragment : Fragment(R.layout.fragment_currency_exchange) {

    private lateinit var binding: FragmentCurrencyExchangeBinding
    var currencyList = arrayListOf<CurrencRateEntity>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCurrencyExchangeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val flag = World.getFlagOf("se")
        val currencyRecyclerView = binding.rvCurrency
        val adapter = CurrencyExchangeRateAdapter(currencyList)
        currencyRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        currencyRecyclerView.adapter = adapter
    }

}