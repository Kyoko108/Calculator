package com.example.calculator


import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnSin = findViewById<Button>(R.id.button_Sine)
        btnCos = findViewById<Button>(R.id.button_cos)
        btnTan = findViewById<Button>(R.id.button_tan)
        btnSinInverse = findViewById<Button>(R.id.button_sin_inverse)
        btnCosInverse = findViewById<Button>(R.id.button_cos_Inverse)
        btnTanInverse = findViewById<Button>(R.id.button_tan_Inverse)
        btnLog = findViewById<Button>(R.id.button_Logarithm)
        btnLn = findViewById<Button>(R.id.button_NaturalLogarithm)
        btnLogbase2 = findViewById<Button>(R.id.button_logbase2)
        btnPower = findViewById<Button>(R.id.button_power)
        btnSqrt = findViewById<Button>(R.id.button_squareRoot)
        btnSquare = findViewById<Button>(R.id.buttonSquare)
        btnExponent = findViewById<Button>(R.id.button_Exponent)
        btnEpower = findViewById<Button>(R.id.button_exponent_Power)
        btnPi = findViewById<Button>(R.id.button_pi)
        btnIsPrime = findViewById<Button>(R.id.button_isPrime)

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
            if(isChecked)
            {
                var s: String = Input.text.toString()//this particular syntax is mandatory for the toggle button to run successfully
                s= s.substring(0,s.length-1)
                Input.text = s
            }else{
                Input.text=""
                Output.text=""
            }
        }
        binding.buttonFirstBracketopen.setOnClickListener {
            Input.text = addToInputText("(")
        }
        button_firstBracketClose.setOnClickListener {
            Input.text = addToInputText(")")
        }
        btnSin.setOnClickListener {
            Input.text = addToInputText("sin(")
        }
        btnCos.setOnClickListener {
            Input.text = addToInputText("cos(")
        }
        btnTan.setOnClickListener {
            Input.text = addToInputText("tan(")
        }
        btnSinInverse.setOnClickListener {
            Input.text = addToInputText("asin(")
        }
        btnCosInverse.setOnClickListener {
            Input.text = addToInputText("acos(")
        }
        btnTanInverse.setOnClickListener {
            Input.text = addToInputText("atan(")
        }
        btnIsPrime.setOnClickListener {
            Input.text = addToInputText("ispr(")
        }
        btnLog.setOnClickListener {
            Input.text = addToInputText("log10(")
        }
        btnLn.setOnClickListener {
            Input.text = addToInputText("ln(")
        }
        btnLogbase2.setOnClickListener {
            Input.text = addToInputText("log2(")
        }
        btnSquare.setOnClickListener {
            Input.text = addToInputText("^2")
        }
        btnSqrt.setOnClickListener {
            Input.text = addToInputText("sqrt(")
        }
        btnPower.setOnClickListener {
            Input.text = addToInputText("^")
        }
        btnPi.setOnClickListener {
            Input.text = addToInputText("pi")
        }
        btnExponent.setOnClickListener {
            Input.text = addToInputText("e")
        }
        btnEpower.setOnClickListener {
            Input.text = addToInputText("exp(")
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
                Output.text ="Error"
             }
             else
             {
                Output.text = DecimalFormat( "0.######").format(result).toString()
             }
         }catch(e:RuntimeException){
             Output.text ="Error1234"
         }
     }
         }




