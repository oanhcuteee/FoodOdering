package com.ducfore.foododering.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ducfore.foododering.Adapter.BuyAgainAdapter
import com.ducfore.foododering.R
import com.ducfore.foododering.databinding.FragmentHistoryBinding


class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var buyAgainAdapter: BuyAgainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment
        setupRecyclerView()
        return binding.root
    }
    private fun setupRecyclerView(){
        val buyAgainFoodName = arrayListOf("Food 1","Food 2","Food 3")
        val buyAgainPrice = arrayListOf("10$","12$","23$")
        val buyAgainImage = arrayListOf(R.drawable.menu1,R.drawable.menu2,R.drawable.menu3)
        buyAgainAdapter = BuyAgainAdapter(buyAgainFoodName,buyAgainPrice,buyAgainImage)
        binding.buyAgaintRecyclerView.adapter = buyAgainAdapter
        binding.buyAgaintRecyclerView.layoutManager = LinearLayoutManager(requireContext() )

    }

    companion object {

    }
}