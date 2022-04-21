package com.example.ecurrencyexchangeapp.ui.currencyui

import android.content.ContentValues.TAG
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.blongho.country_data.World
import com.example.ecurrencyexchangeapp.R
import com.example.ecurrencyexchangeapp.data.remote.entities.currencyRateEntities.CurrencRateEntity
import com.example.ecurrencyexchangeapp.databinding.FragmentCurrencyExchangeBinding
import com.example.ecurrencyexchangeapp.ui.currencyui.adapter.CurrencyExchangeRateAdapter
import com.example.ecurrencyexchangeapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CurrencyExchangeFragment : Fragment(R.layout.fragment_currency_exchange) {

    val TAG = "CurrencyExchangeFragment"
    private lateinit var binding: FragmentCurrencyExchangeBinding
    private val viewModel: CurrencyExchangeViewModel by viewModels()
    var currencyList: List<CurrencRateEntity>? = listOf<CurrencRateEntity>()

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
        Log.i(TAG, "onViewCreated")

        val currencyRecyclerView = binding.rvCurrency
        lifecycleScope.launch {
            viewModel.getCurrencyList()
            delay(500)
            viewModel.curencyList.observe(viewLifecycleOwner) {
                when (it.status) {
                    Resource.Status.SUCCESS -> {
                        Log.i(TAG, "onViewCreated: nour ${it.data}")
                        currencyList = it.data
                        currencyList?.let {
                            val adapter = CurrencyExchangeRateAdapter(it)
                            currencyRecyclerView.layoutManager =
                                LinearLayoutManager(requireContext())
                            currencyRecyclerView.adapter = adapter
                        }
                    }
                    Resource.Status.ERROR -> {
                        Log.i(TAG, "onViewCreated: nourERROR")
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                    }
                    Resource.Status.LOADING -> {
                        Log.i(TAG, "onViewCreated: nour LOADING")
                        binding.pr.visibility = View.VISIBLE

                    }
                    else -> {}
                }
            }
        }

    }

}