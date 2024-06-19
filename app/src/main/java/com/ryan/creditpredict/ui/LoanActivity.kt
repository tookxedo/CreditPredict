package com.ryan.creditpredict.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ryan.creditpredict.R
import com.ryan.creditpredict.databinding.ActivityLoanBinding

class LoanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoanBinding

    private var purpose = ""
    private var duration = ""
    private var ammount = ""

    private var purposeIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoanBinding.inflate(layoutInflater)
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

        val genderIndex = intent.getIntExtra("genderIndex", 0)
        val numberIndex = intent.getIntExtra("numberIndex", 0)
        val employmentIndex = intent.getIntExtra("employmentIndex", 0)
        val jobIndex = intent.getIntExtra("jobIndex", 0)
        val propertyIndex = intent.getIntExtra("propertyIndex", 0)

        val spPurpose = binding.spPurpose

        val purposeArray = resources.getStringArray(R.array.purpose)

        val purposeAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, purposeArray)

        spPurpose.adapter = purposeAdapter

//        spPurpose.setSelection(0, false)

        spPurpose.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                purposeIndex = position - 1
                purpose = purposeArray[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        binding.btnNext.setOnClickListener {
            duration = binding.etDuration.text.toString()
            if (purposeIndex != -1 && binding.etDuration.text?.isNotEmpty()!! && binding.etAmount.text?.isNotEmpty()!!) {
                ammount = binding.etAmount.text.toString()
//                Toast.makeText(
//                    applicationContext,
//                    "$fullname, $age, $gender, $number, $employment, $job, $property, $purpose, $duration $ammount",
//                    Toast.LENGTH_LONG
//                ).show()
                val intent = Intent(this, CreditActivity::class.java)
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

                intent.putExtra("genderIndex", genderIndex)
                intent.putExtra("numberIndex", numberIndex)
                intent.putExtra("EmploymentIndex", employmentIndex)
                intent.putExtra("jobIndex", jobIndex)
                intent.putExtra("propertyIndex", propertyIndex)

                intent.putExtra("purposeIndex", purposeIndex)

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