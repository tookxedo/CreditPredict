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
import com.ryan.creditpredict.databinding.ActivityIdentityBinding

class IdentityActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIdentityBinding
    private var number = ""
    private var employment = ""
    private var job = ""
    private var property = ""

    private var numberIndex = 0
    private var employmentIndex = 0
    private var jobIndex = 0
    private var propertyIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIdentityBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val genderIndex = intent.getIntExtra("genderIndex", 0)
        val fullname = intent.getStringExtra("fullname")
        val age = intent.getIntExtra("age", 0)
        val gender = intent.getStringExtra("gender")

        val arrayNumber = resources.getStringArray(R.array.number)
        val arrayEmployment = resources.getStringArray(R.array.employment)
        val arrayJob = resources.getStringArray(R.array.job_type)
        val arrayProperty = resources.getStringArray(R.array.property)

        val spNumber = binding.spNumber
        val spEmployment = binding.spStatus
        val spJob = binding.spJob
        val spProperty = binding.spProperty

        val NumberAdapter = ArrayAdapter(this, R.layout.spinner_dropdown_item, arrayNumber)
        val EmploymentAdapter =
            ArrayAdapter(this, R.layout.spinner_dropdown_item, arrayEmployment)
        val jobAdapter = ArrayAdapter(this, R.layout.spinner_dropdown_item, arrayJob)
        val propertyAdapter =
            ArrayAdapter(this, R.layout.spinner_dropdown_item, arrayProperty)

        spNumber.adapter = NumberAdapter
        spEmployment.adapter = EmploymentAdapter
        spJob.adapter = jobAdapter
        spProperty.adapter = propertyAdapter

//        spNumber.setSelection(0, false)
//        spEmployment.setSelection(0, false)
//        spJob.setSelection(0, false)
//        spProperty.setSelection(0, false)

        spNumber.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                numberIndex = position - 1
                number = arrayNumber[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spEmployment.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                employmentIndex = position - 1
                employment = arrayEmployment[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spJob.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                jobIndex = position - 1
                job = arrayJob[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spProperty.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                propertyIndex = position - 1
                property = arrayProperty[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        binding.btnNext.setOnClickListener {
            if (numberIndex != -1 && employmentIndex != -1 && jobIndex != -1 && propertyIndex != -1) {
//                Toast.makeText(
//                    applicationContext,
//                    "$fullname, $age, $gender, $number, $employment, $job, $property",
//                    Toast.LENGTH_LONG
//                ).show()
                val intent = Intent(this, LoanActivity::class.java)
                intent.putExtra("fullname", fullname)
                intent.putExtra("age", age)
                intent.putExtra("gender", gender)
                intent.putExtra("number", number)
                intent.putExtra("employment", employment)
                intent.putExtra("job", job)
                intent.putExtra("property", property)

                intent.putExtra("genderIndex", genderIndex)
                intent.putExtra("numberIndex", numberIndex)
                intent.putExtra("EmploymentIndex", employmentIndex)
                intent.putExtra("jobIndex", jobIndex)
                intent.putExtra("propertyIndex", propertyIndex)

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