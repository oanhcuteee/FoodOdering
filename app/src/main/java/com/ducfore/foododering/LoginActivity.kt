package com.ducfore.foododering

import android.content.Intent
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ducfore.foododering.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private val binding : ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this,SignActivity::class.java)
            startActivity(intent)
        }
        binding.dontHaveAccount.setOnClickListener {
            val intent = Intent(this,SignActivity::class.java)
            startActivity(intent)
        }
    }
}