package com.harjot.fragmentspractice

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.harjot.fragmentspractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val TAG = "MainActivity"
    lateinit var activityInterface : ActivityInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnRed.setOnClickListener {
            activityInterface.colorChange(1)
        }
        binding.btnGreen.setOnClickListener {
            activityInterface.colorChange(2)
        }
        binding.btnBlue.setOnClickListener {
            activityInterface.colorChange(3)
        }
        binding.btnPass.setOnClickListener {
            if (binding.etText.text.toString().trim().isNullOrEmpty()){
                binding.etText.error = "Enter Text"
            }else{
                activityInterface.textUpdate("${binding.etText.text.toString().trim()}")
            }
        }
    }
    fun textChange(text:String){
        binding.etText.setText(text)
    }
    fun counterUpdate(counter :Int){
        binding.btnCounter.setText("${counter}")
//        Log.e(TAG, "counterUpdate: $counter", )
    }
}