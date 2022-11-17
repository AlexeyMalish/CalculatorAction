package com.appprivatestudio.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import com.appprivatestudio.calculator.core.CalculatorCore
import com.appprivatestudio.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),  View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    private val engine by lazy {
        CalculatorCore()
    }

    private val operands = listOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".")

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        registerButtonClick()
        binding.textResult.isSelected = true
    }

    private fun registerButtonClick() {
        (binding.layoutButtonHolder as ViewGroup).children.forEach {
            it.setOnClickListener(this)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        if (engine.isInInvalidState) {
            resetCalculator()
        }

        if (v == null || v.tag == null) {
            return
        }
        when (val tag = v.tag.toString()) {
            "del" -> {
                val oldValue = readInputValue()
                if (oldValue.isNotEmpty()) {
                    binding.editTextInput.setText(oldValue.substring(0, oldValue.lastIndex))
                }
            }
            "C" -> resetCalculator()
            in operands -> {
                if (readInputValue().contains(".") && tag == ".") {
                    return
                }
                binding.editTextInput.setText(readInputValue() + tag)
            }
            else -> {
                val result = engine.calculate(readInputValue())
                binding.textResult.text = result
                binding.editTextInput.setText("")
                if (tag != "=") {
                    engine.operator = tag[0]
                    binding.textOperator.text = tag
                }
            }
        }
    }

    private fun resetCalculator() {
        engine.clear()
        binding.editTextInput.setText("")
        binding.textOperator.text = engine.operator.toString()
        binding.textResult.text = "0"
    }

    private fun readInputValue() = binding.editTextInput.text.toString()
}