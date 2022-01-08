package com.example.calculator


import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

 class MainActivity : AppCompatActivity(){


     private val viewModel by viewModels<MemoryViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.init(application)


        binding.button0.setOnClickListener {
            Input.text = addToInputText("0")
        }
        binding.button1.setOnClickListener {
            Input.text = addToInputText("1")
        }
        binding.button2.setOnClickListener {
            Input.text = addToInputText("2")
        }
        binding.button3.setOnClickListener {
            Input.text = addToInputText("3")
        }
        binding.button4.setOnClickListener {
            Input.text = addToInputText("4")
        }
        binding.button5.setOnClickListener {
            Input.text = addToInputText("5")
        }
        binding.button6.setOnClickListener {
            Input.text = addToInputText("6")
        }
        binding.button7.setOnClickListener {
            Input.text = addToInputText("7")
        }
        binding.button8.setOnClickListener {
            Input.text = addToInputText("8")
        }
        binding.button9.setOnClickListener {
            Input.text = addToInputText("9")
        }
        binding.buttonPlus.setOnClickListener {
            Input.text = addToInputText("+")
        }
        binding.buttonMinus.setOnClickListener {
            Input.text = addToInputText("-")
        }
        binding.buttonInto.setOnClickListener {
            Input.text = addToInputText("*")
        }
        binding.buttonDivide.setOnClickListener {
            Input.text = addToInputText("/")
        }
        binding.buttonEquals.setOnClickListener {
            showResult()

        }
        binding.buttonDecimalPoint.setOnClickListener {
            Input.text = addToInputText(".")
        }
        binding.buttonClear.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                var s: String =
                    Input.text.toString()//this particular syntax is mandatory for the toggle button to run successfully
                s = s.substring(0, s.length - 1)
                Input.text = s
            } else {
                Input.text = ""
                Output.text = ""
            }
        }
        binding.buttonFirstBracketopen.setOnClickListener {
            Input.text = addToInputText("(")
        }
        binding.buttonFirstBracketClose.setOnClickListener {
            Input.text = addToInputText(")")
        }
        binding.buttonSine?.setOnClickListener {
            Input.text = addToInputText("sin(")
        }
        binding.buttonCos?.setOnClickListener {
            Input.text = addToInputText("cos(")
        }
        binding.buttonTan?.setOnClickListener {
            Input.text = addToInputText("tan(")
        }
        binding.buttonSinInverse?.setOnClickListener {
            Input.text = addToInputText("asin(")
        }
        binding.buttonCosInverse?.setOnClickListener {
            Input.text = addToInputText("acos(")
        }
        binding.buttonTanInverse?.setOnClickListener {
            Input.text = addToInputText("atan(")
        }
        binding.buttonIsPrime?.setOnClickListener {
            Input.text = addToInputText("ispr(")
        }
        binding.buttonLogarithm?.setOnClickListener {
            Input.text = addToInputText("log10(")
        }
        binding.buttonNaturalLogarithm?.setOnClickListener {
            Input.text = addToInputText("ln(")
        }
        binding.buttonLogbase2?.setOnClickListener {
            Input.text = addToInputText("log2(")
        }
        binding.buttonSquare?.setOnClickListener {
            Input.text = addToInputText("^2")
        }
        binding.buttonSquareRoot?.setOnClickListener {
            Input.text = addToInputText("sqrt(")
        }
        binding.buttonPower?.setOnClickListener {
            Input.text = addToInputText("^")
        }
        binding.buttonPi?.setOnClickListener {
            Input.text = addToInputText("pi")
        }
        binding.buttonExponent?.setOnClickListener {
            Input.text = addToInputText("e")
        }
        binding.buttonExponentPower?.setOnClickListener {
            Input.text = addToInputText("exp(")
        }


        binding.Memory?.setOnClickListener {
            val data = Input.text.toString() + "=" + Output.text.toString()
            if (data.isNotEmpty()) {
                viewModel.saveMemory(data)
            }
        }
    }
     private fun addToInputText(buttonVal:String):String
     {
         return "${Input.text}$buttonVal"
     }
    private fun getInputFromUser(): String {
        return Input.text.replace(Regex("÷"), "/")
    }
     private fun showResult()
     {
         try{
            val express = getInputFromUser()
             val result = Expression(express).calculate()

             if(result.isNaN())
             {
                Output.text =""
             }
             else
             {
                Output.text = DecimalFormat( "0.######").format(result).toString()
             }
         }catch(e:RuntimeException){
             Output.text =""
         }
     }




}