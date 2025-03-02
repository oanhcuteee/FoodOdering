package com.ducfore.foododering.Activity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ducfore.foododering.databinding.FragmentCongratsBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class CongratsBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding:FragmentCongratsBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentCongratsBottomSheetBinding.inflate(layoutInflater,container,false)
        binding.goHomeButton.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }

    companion object {

    }
}