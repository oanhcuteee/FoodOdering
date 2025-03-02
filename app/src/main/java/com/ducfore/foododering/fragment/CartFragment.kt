package com.ducfore.foododering.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ducfore.foododering.Adapter.CartAdapter
import com.ducfore.foododering.Activity.PayOutActivity
import com.ducfore.foododering.R
import com.ducfore.foododering.databinding.FragmentCartBinding

class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)

        val foodNameCart =
            listOf("Burger", "Sandwich", "Spacy King Crab", "Burger", "Sandwich", "Spacy King Crab")
        val priceFoodCart = listOf("12$", "7$", "24$", "12$", "7$", "24$")
        val imgFoodCart = listOf(
            R.drawable.menu_photo1,
            R.drawable.menu_photo2,
            R.drawable.menu3,
            R.drawable.menu_photo1,
            R.drawable.menu_photo2,
            R.drawable.menu3
        )

        val adapter = CartAdapter(ArrayList(foodNameCart),ArrayList(priceFoodCart),ArrayList(imgFoodCart))
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter = adapter

        binding.proceedBtn.setOnClickListener {
            val intent = Intent(requireContext(), PayOutActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    companion object {

    }
}