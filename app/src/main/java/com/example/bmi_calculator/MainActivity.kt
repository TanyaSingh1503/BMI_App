package com.example.bmi_calculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bmi_calculator.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateBMI.setOnClickListener{
            calculateBMI()
        }
    }

    private fun calculateBMI(){
        val height = binding.heightEdit.text.toString().toFloatOrNull()
        val weight = binding.weightEdit.text.toString().toFloatOrNull()

        if(height != null && weight != null){
            val bmi = weight/(height/100).pow(2)
            val bmiResult = String.format("%.2f",bmi)

            val bmiCategory = when{
                bmi<18.5 -> "Underweight"
                bmi<25 -> "Normal weight"
                bmi<30 -> "Overweight"
                else -> "obese"
            }
            binding.Text.text = "BMI: $bmiResult \n Category:  $bmiCategory"
        }
        else{
            binding.Text.text="Invalid Input"
        }
    }
}