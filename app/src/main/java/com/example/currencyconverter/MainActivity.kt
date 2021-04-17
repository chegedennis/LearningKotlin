package com.example.currencyconverter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.currencyconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.convertButton.setOnClickListener { convertCurrency() }
    }

    private fun convertCurrency() {
        val usd = R.id.original_USD
        val kenya = R.id.original_kenya_shilling
        val euro = R.id.original_euro
        val brit = R.id.original_british_pound
        val original = binding.originalCurrencyRadioGroup.checkedRadioButtonId
        val converted = binding.targetCurrencyRadioGroup.checkedRadioButtonId
        val conUsd = R.id.target_USD
        val conKenya = R.id.target_kenya_shilling
        val conEuro = R.id.target_euro
        val conBrit = R.id.target_british_pound
        val amount = binding.amountInput.text.toString()
        val newAmount = amount.toDoubleOrNull()
        if (newAmount == null){
            binding.convertedAmount.text = " "
            return
        }
        val convertedAmount = binding.convertedAmount


        when (original) {
            usd -> {
                when (converted) {
                    conUsd -> {
                        convertedAmount.text = "Total amount: ${1.0 * newAmount}"
                    }
                    conKenya -> {
                        convertedAmount.text = "Total amount: ${newAmount * 100}"
                    }
                    conEuro -> {
                        convertedAmount.text = "Total amount: ${newAmount * 0.75}"
                    }
                    conBrit -> {
                        convertedAmount.text = "Total amount: ${newAmount * 0.65}"
                    }
                    else -> {
                        return
                    }
                }
            }
            kenya -> {
                when (converted) {
                    conUsd -> {
                        convertedAmount.text = "Total amount: ${newAmount / 100}"
                    }
                    conKenya -> {
                        convertedAmount.text = "Total amount: ${newAmount * 1.0}"
                    }
                    conEuro -> {
                        convertedAmount.text = "Total amount: ${newAmount / 150}"
                    }
                    conBrit -> {
                        convertedAmount.text = "Total amount: ${newAmount / 180}"
                    }
                    else -> {
                        return
                    }
                }
            }
            euro -> {
                when (converted) {
                    conUsd -> {
                        convertedAmount.text = "Total amount: ${newAmount * 0.75}"
                    }
                    conKenya -> {
                        convertedAmount.text = "Total amount: ${newAmount * 175}"
                    }
                    conEuro -> {
                        convertedAmount.text = "Total amount: ${newAmount * 1.0}"
                    }
                    conBrit -> {
                        convertedAmount.text = "Total amount: ${newAmount * 0.65}"
                    }
                    else -> {
                        return
                    }
                }
            }
            brit -> {
                when (converted) {
                    conUsd -> {
                        convertedAmount.text = "Total amount: ${newAmount * 7.5}"
                    }
                    conKenya -> {
                        convertedAmount.text = "Total amount: ${newAmount * 175}"
                    }
                    conEuro -> {
                        convertedAmount.text = "Total amount: ${newAmount * 6.5}"
                    }
                    conBrit -> {
                        convertedAmount.text = "Total amount: ${newAmount * 1}"
                    }
                    else -> {
                        return
                    }
                }
            }
            else -> return
        }

    }
}