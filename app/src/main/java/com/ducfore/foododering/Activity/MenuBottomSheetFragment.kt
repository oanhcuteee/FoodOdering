package com.ducfore.foododering.Activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ducfore.foododering.Adapter.MenuAdapter
import com.ducfore.foododering.R
import com.ducfore.foododering.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMenuBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBottomSheetBinding.inflate(inflater,container,false)

        binding.btnBack.setOnClickListener {
            dismiss()
        }

        val foodNameMenu =
            listOf("Burger", "Sandwich", "Spacy King Crab", "Burger", "Sandwich", "Spacy King Crab")
        val priceFoodMenu = listOf("12$", "7$", "24$", "12$", "7$", "24$")
        val imgFoodMenu = listOf(
            R.drawable.menu_photo1,
            R.drawable.menu_photo2,
            R.drawable.menu3,
            R.drawable.menu_photo1,
            R.drawable.menu_photo2,
            R.drawable.menu3
        )

        val adapter = MenuAdapter(ArrayList(foodNameMenu),ArrayList(priceFoodMenu),ArrayList(imgFoodMenu),requireContext())
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter
        return binding.root
    }

    companion object {

    }
}