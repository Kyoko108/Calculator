package com.example.calculator


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.calculator.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.memory_rv_item.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

abstract class MainActivity : AppCompatActivity() , NoteClickInterface {

    // on below line we are creating a variable
    // for our recycler view, exit text, button and viewmodel.
    private lateinit var viewModel: MemoryViewModel
    private lateinit var notesRV: RecyclerView
    private lateinit var memory: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


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
binding.memory?.setOnClickListener {
    if(it.isActivated)
    {
        val calculation = StringBuilder()
        calculation.append(Input.text.toString()).append("=").append(Output.text.toString())

        viewModel.addNote( Memory(noteTitle = Memory ,
            noteDescription = calculation.toString(),  timeStamp = Date))
    }
}
        notesRV = findViewById(R.id.notesRV)
        memory = findViewById(R.id.memory)


        notesRV.layoutManager = LinearLayoutManager(this)


        val memoryAdapter = MemoryAdapter(this, this)


        notesRV.adapter = memoryAdapter


        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[MemoryViewModel::class.java]


        viewModel.allNotes.observe(this,  { list ->
            list?.let {

                memoryAdapter.updateList(it)
            }
        })

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