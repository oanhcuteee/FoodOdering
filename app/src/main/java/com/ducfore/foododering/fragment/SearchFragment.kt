package com.ducfore.foododering.fragment

import android.annotation.SuppressLint
import android.app.DownloadManager.Query
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.ducfore.foododering.Adapter.MenuAdapter
import com.ducfore.foododering.R
import com.ducfore.foododering.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: MenuAdapter
    private val originalMenuFoodName =
        listOf("Burger", "Sandwich", "Spacy King Crab", "Burger", "Sandwich", "Spacy King Crab")
    private val originalMenuItemPrice = listOf("12$", "7$", "24$", "12$", "7$", "24$")
    private val originalMenuImage = listOf(
        R.drawable.menu_photo1,
        R.drawable.menu_photo2,
        R.drawable.menu3,
        R.drawable.menu_photo1,
        R.drawable.menu_photo2,
        R.drawable.menu3
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private val filterMenuItemsName = mutableListOf<String>()
    private val filterMenuPrice = mutableListOf<String>()
    private val filterMenuImage = mutableListOf<Int>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentSearchBinding.inflate(inflater, container, false)
        adapter = MenuAdapter(filterMenuItemsName,filterMenuPrice,filterMenuImage,requireContext())
        binding.searchRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.searchRecyclerView.adapter = adapter

        // setup for search View
        setupSearchView()
        // show all menu Item
        showAllMenuItem()
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun showAllMenuItem() {
        filterMenuItemsName.clear()
        filterMenuPrice.clear()
        filterMenuImage.clear()

        filterMenuItemsName.addAll(originalMenuFoodName)
        filterMenuPrice.addAll(originalMenuItemPrice)
        filterMenuImage.addAll(originalMenuImage)

        adapter.notifyDataSetChanged()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String  ): Boolean {
                filterMenuItems(newText)
                return true
            }

        })
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun filterMenuItems(query: String) {
       filterMenuItemsName.clear()
        filterMenuPrice.clear()
        filterMenuImage.clear()
        
        originalMenuFoodName.forEachIndexed { index, foodName ->
            if(foodName.contains(query, ignoreCase = true)){
                filterMenuItemsName.add(foodName)
                filterMenuPrice.add(originalMenuItemPrice[index])
                filterMenuImage.add(originalMenuImage[index])
            }
        }
        adapter.notifyDataSetChanged()
    }


    companion object {

    }
}