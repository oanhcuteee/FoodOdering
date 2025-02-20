package com.ducfore.foododering.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.ducfore.foododering.Adapter.PopularAdapter
import com.ducfore.foododering.R
import com.ducfore.foododering.databinding.FragmentHomeBinding
import com.google.android.material.slider.Slider


class HomeFragment : Fragment() {

    private lateinit var binding:FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner2, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner3, ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList,ScaleTypes.FIT)

        val popularFoodName = listOf("Burger","Sandwich","Snack","item")
        val popularPrice = listOf("45000 VNĐ","50000 VNĐ","10000 VNĐ","5000VNĐ")
        val popularImageFood = listOf(R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu1)

        val adapter = PopularAdapter(popularPrice,popularImageFood,popularFoodName)
        binding.popularRecycleView.layoutManager = LinearLayoutManager(requireContext())
        binding.popularRecycleView.adapter = adapter
    }

    companion object {

    }
}