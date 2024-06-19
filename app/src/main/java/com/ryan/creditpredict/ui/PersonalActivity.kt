package com.ryan.creditpredict.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ryan.creditpredict.R
import com.ryan.creditpredict.databinding.ActivityPersonalBinding

class PersonalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPersonalBinding
    private var fullname = ""
    private var age = 0
    private var gender = ""

    private var genderIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonalBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val sharedPref = getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        val genders = resources.getStringArray(R.array.gender)
        val spGender = binding.spGender
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, genders
        )
        spGender.adapter = adapter
//        spGender.setSelection(0, false)

        spGender.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                genderIndex = position - 1
                gender = genders[position]
                Log.d("INDEX NUMBER", "$genderIndex")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        binding.btnNext.setOnClickListener {

            if (binding.etFullname.text?.isNotEmpty()!! && binding.etAge.text?.isNotEmpty() == true && genderIndex != -1) {

                fullname = binding.etFullname.text.toString()
                age = binding.etAge.text.toString().toInt()

//                Toast.makeText(applicationContext, "$fullname, $age, $gender", Toast.LENGTH_LONG)
//                    .show()

                editor.putString("fullname", fullname)
                editor.putInt("age", age)
                editor.putInt("gender", genderIndex)

                val intent = Intent(this, IdentityActivity::class.java)
                intent.putExtra("fullname", fullname)
                intent.putExtra("age", age)
                intent.putExtra("gender", gender)

                intent.putExtra("genderIndex", genderIndex)
                startActivity(intent)

            } else {
                Toast.makeText(
                    applicationContext,
                    "PLEASE COMPLETE YOUR IDENTITY",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}