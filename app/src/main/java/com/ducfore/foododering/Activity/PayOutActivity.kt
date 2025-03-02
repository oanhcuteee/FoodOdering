package com.ducfore.foododering.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ducfore.foododering.databinding.ActivityPayOutBinding

class PayOutActivity : AppCompatActivity() {
   private lateinit var binding: ActivityPayOutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPayOutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.placeMyOderBtn.setOnClickListener {
            val bottomSheetDialog = CongratsBottomSheetFragment()
            bottomSheetDialog.show(supportFragmentManager,"Test")
        }
    }
}