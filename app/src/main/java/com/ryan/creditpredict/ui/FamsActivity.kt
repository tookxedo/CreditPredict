package com.ryan.creditpredict.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ryan.creditpredict.R
import com.ryan.creditpredict.databinding.ActivityFamBinding

class FamsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFamBinding
    private var marital = ""
    private var housing = ""
    private var residence = ""
    private var liable = ""

    private var maritalIndex = 0
    private var housingIndex = 0
    private var residenceIndex = 0
    private var liableIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFamBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val fullname = intent.getStringExtra("fullname")
        val age = intent.getIntExtra("age", 0)
        val gender = intent.getStringExtra("gender")
        val number = intent.getStringExtra("number")
        val employment = intent.getStringExtra("employment")
        val job = intent.getStringExtra("job")
        val property = intent.getStringExtra("property")
        val purpose = intent.getStringExtra("purpose")
        val duration = intent.getStringExtra("duration")
        val ammount = intent.getStringExtra("ammount")
        val credit = intent.getStringExtra("credit")
        val installmentRate = intent.getStringExtra("installmentRate")
        val otherDebtor = intent.getStringExtra("otherDebtor")
        val otherInstallment = intent.getStringExtra("otherInstallment")

        val genderIndex = intent.getIntExtra("genderIndex", 0)
        val numberIndex = intent.getIntExtra("numberIndex", 0)
        val employmentIndex = intent.getIntExtra("employmentIndex", 0)
        val jobIndex = intent.getIntExtra("jobIndex", 0)
        val propertyIndex = intent.getIntExtra("propertyIndex", 0)
        val purposeIndex = intent.getIntExtra("purposeIndex", 0)
        val durationIndex = intent.getIntExtra("durationIndex", 0)
        val creditIndex = intent.getIntExtra("jobIndex", 0)
        val installmentRateIndex = intent.getIntExtra("propertyIndex", 0)
        val otherDebtorIndex = intent.getIntExtra("purposeIndex", 0)
        val otherInstallmentIndex = intent.getIntExtra("durationIndex", 0)

        val spMarital = binding.spMarital
        val spHousing = binding.spHousing
        val spResidence = binding.spResidence
        val spLiable = binding.spLiable

        val maritalArray = resources.getStringArray(R.array.marital)
        val housingArray = resources.getStringArray(R.array.housing)
        val residenceArray = resources.getStringArray(R.array.residence)
        val liableArray = resources.getStringArray(R.array.liable)

        val maritalAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, maritalArray)
        val housingAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, housingArray)
        val residenceAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, residenceArray)
        val liableAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, liableArray)

        spMarital.adapter = maritalAdapter
        spHousing.adapter = housingAdapter
        spResidence.adapter = residenceAdapter
        spLiable.adapter = liableAdapter

//        spMarital.setSelection(0, false)
//        spHousing.setSelection(0, false)
//        spResidence.setSelection(0, false)
//        spLiable.setSelection(0, false)

        spMarital.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                maritalIndex = position - 1
                marital = maritalArray[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        spHousing.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                housingIndex = position - 1
                housing = housingArray[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        spResidence.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                residenceIndex = position - 1
                residence = residenceArray[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        spLiable.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                liableIndex = position - 1
                liable = residenceArray[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        binding.btnNext.setOnClickListener {
            if (maritalIndex != -1 && housingIndex != -1 && residenceIndex != -1 && liableIndex != -1) {
//                Toast.makeText(
//                    applicationContext,
//                    "$fullname, $age, $gender, $number, $employment, $job, $property, $purpose," +
//                            " $duration, $ammount, $credit, $installmentRate, $otherDebtor, $otherInstallment," +
//                            "$marital, $housing, $residence, $liable",
//                    Toast.LENGTH_LONG
//                ).show()
                Log.d("LIABLE", liable)
                val intent = Intent(this, JobActivity::class.java)
                intent.putExtra("fullname", fullname)
                intent.putExtra("age", age)
                intent.putExtra("gender", gender)
                intent.putExtra("number", number)
                intent.putExtra("employment", employment)
                intent.putExtra("job", job)
                intent.putExtra("property", property)
                intent.putExtra("purpose", purpose)
                intent.putExtra("duration", duration)
                intent.putExtra("ammount", ammount)
                intent.putExtra("credit", credit)
                intent.putExtra("installmentRate", installmentRate)
                intent.putExtra("otherDebtor", otherDebtor)
                intent.putExtra("otherInstallment", otherInstallment)
                intent.putExtra("marital", marital)
                intent.putExtra("housing", housing)
                intent.putExtra("residence", residence)
                intent.putExtra("liable", liable)

                intent.putExtra("genderIndex", genderIndex)
                intent.putExtra("numberIndex", numberIndex)
                intent.putExtra("EmploymentIndex", employmentIndex)
                intent.putExtra("jobIndex", jobIndex)
                intent.putExtra("propertyIndex", propertyIndex)

                intent.putExtra("purposeIndex", purposeIndex)
                intent.putExtra("durationIndex", durationIndex)

                intent.putExtra("creditIndex", creditIndex)
                intent.putExtra("installmentRateIndex", installmentRateIndex)
                intent.putExtra("otherDebtorIndex", otherDebtorIndex)
                intent.putExtra("otherInstallmentIndex", otherInstallmentIndex)

                intent.putExtra("maritalIndex", maritalIndex)
                intent.putExtra("housingIndex", housingIndex)
                intent.putExtra("residenceIndex", residenceIndex)
                intent.putExtra("liableIndex", liableIndex)

                startActivity(intent)
            } else {
                Toast.makeText(
                    applicationContext,
                    "PLEASE COMPLETE THE FORM",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}