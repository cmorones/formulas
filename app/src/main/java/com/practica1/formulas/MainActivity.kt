package com.practica1.formulas

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.practica1.formulas.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener  {

    private lateinit var binding: ActivityMainBinding
    private lateinit var formulas: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        formulas = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item)

        formulas.addAll(Arrays.asList("Area","Circunferencia","Chicharronera"))

        binding.spinnerFormulas.onItemSelectedListener = this
        binding.spinnerFormulas.adapter = formulas

       setSupportActionBar(binding.toolbar)

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
       binding.btnIr.text = formulas.getItem(position)
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }



    fun click(view: View) {

        if(binding.btnIr.text == "Chicharronera"){
            val intent = Intent(this, formula1::class.java)
            startActivity(intent)
            finish()

        }

        if(binding.btnIr.text == "Area"){
            val intent = Intent(this, formula2::class.java)
            startActivity(intent)
            finish()

        }

        if(binding.btnIr.text == "Circunferencia"){
            val intent = Intent(this, formula3::class.java)
            startActivity(intent)
            finish()

        }

    }
}