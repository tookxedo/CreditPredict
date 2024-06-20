package com.ryan.creditpredict.ui

import com.ryan.creditpredict.data.Result
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.JsonObject
import com.ryan.creditpredict.R
import com.ryan.creditpredict.databinding.ActivityJobBinding
import com.ryan.creditpredict.databinding.ActivityLoanBinding

class JobActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJobBinding

    private val viewModel by viewModels<JobViewModel> {
        ViewModelFactory.getInstance(this)
    }

    private var currentEmploymentDuration = ""
    private var savings = ""
    private var creditTaken = ""
    private var creditRisk = ""

    private var savingsIndex = 0
    private var currentEmploymentDurationIndex = 0
    private var creditRiskIndex = 0
    private var creditTakenIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJobBinding.inflate(layoutInflater)
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
        val duration = intent.getIntExtra("duration", 0)
        val amount = intent.getStringExtra("ammount")
        val credit = intent.getStringExtra("credit")
        val installmentRate = intent.getStringExtra("installmentRate")
        val otherDebtor = intent.getStringExtra("otherDebtor")
        val otherInstallment = intent.getStringExtra("otherInstallment")
        val marital = intent.getStringExtra("marital")
        val housing = intent.getStringExtra("housing")
        val residence = intent.getStringExtra("residence")
        val liable = intent.getStringExtra("liable")

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
        val maritalIndex = intent.getIntExtra("propertyIndex", 0)
        val housingIndex = intent.getIntExtra("purposeIndex", 0)
        val residenceIndex = intent.getIntExtra("durationIndex", 0)
        val liableIndex = intent.getIntExtra("liableIndex", 0)

        val spEmployment = binding.spEmploymentDuration
        val spSavings = binding.spSaving
        val spCreditRisk = binding.spCreditRisk
        val spCreditTaken = binding.spCreditTaken

        val employmentArray = resources.getStringArray(R.array.employment_duration)
        val savingArray = resources.getStringArray(R.array.saving)
        val riskArray = resources.getStringArray(R.array.credit_risk)
        val takenArray = resources.getStringArray(R.array.credit_taken)

        val employmentAdapter =
            ArrayAdapter(this, R.layout.spinner_dropdown_item, employmentArray)
        val savingAdapter = ArrayAdapter(this, R.layout.spinner_dropdown_item, savingArray)
        val riskAdapter = ArrayAdapter(this, R.layout.spinner_dropdown_item, riskArray)
        val takenAdapter = ArrayAdapter(this, R.layout.spinner_dropdown_item, takenArray)

        spEmployment.adapter = employmentAdapter
        spSavings.adapter = savingAdapter
        spCreditRisk.adapter = riskAdapter
        spCreditTaken.adapter = takenAdapter

//        spEmployment.setSelection(0, false)
//        spSavings.setSelection(0, false)
//        spCreditRisk.setSelection(0, false)
//        spCreditTaken.setSelection(0, false)

        spEmployment.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                currentEmploymentDurationIndex = position - 1
                currentEmploymentDuration = employmentArray[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        spSavings.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                savingsIndex = position - 1
                savings = savingArray[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        spCreditRisk.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                creditRiskIndex = position - 1
                creditRisk = riskArray[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        spCreditTaken.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                creditTakenIndex = position - 1
                creditTaken = takenArray[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        binding.btnNext.setOnClickListener {
            if (currentEmploymentDurationIndex != -1 && savingsIndex != -1 && creditTakenIndex != -1 && creditRiskIndex != -1) {
                val dataForms = JsonObject().apply {
                    addProperty("duration", duration)
                    addProperty("credit_history", creditIndex)
                    addProperty("purpose", purposeIndex)
                    addProperty("amount", amount?.toInt())
                    addProperty("savings", savingsIndex)
                    addProperty("employment_duration", employmentIndex)
                    addProperty("installment_rate", installmentRateIndex)
                    addProperty("gender", genderIndex)
                    addProperty("marital_status", maritalIndex)
                    addProperty("other_debtors", otherDebtorIndex)
                    addProperty("present_residence", residenceIndex)
                    addProperty("property", propertyIndex)
                    addProperty("age", age)
                    addProperty("other_installment_plans", otherInstallmentIndex)
                    addProperty("housing", housingIndex)
                    addProperty("number_credits", creditTakenIndex)
                    addProperty("job", jobIndex)
                    addProperty("people_liable", liableIndex)
                    addProperty("telephone", numberIndex)
                    addProperty("foreign_worker", employmentIndex)
                    addProperty("credit_risk", creditRiskIndex)
                }
                Log.d("JSONPayload", dataForms.toString())
                viewModel.postPrediction(dataForms)

                Log.d(
                    "DATA",
                    "durationIndex: $durationIndex, creditIndex: $creditIndex, purposeIndex: $purposeIndex amount: $amount, " +
                            "savingsIndex: $savingsIndex, currentEmploymentDurationIndex: $currentEmploymentDurationIndex, " +
                            "installmentRateIndex: $installmentRateIndex, genderIndex: $genderIndex, maritalIndex: $maritalIndex, " +
                            "otherDebtorIndex: $otherDebtorIndex, residenceIndex: $residenceIndex, propertyIndex: $propertyIndex, " +
                            "age: $age, otherInstallmentIndex: $otherInstallmentIndex, housingIndex: $housingIndex," +
                            " creditTaken: $creditTaken, jobIndex: $jobIndex, liable: $liable, numberIndex: $numberIndex," +
                            " employmentIndex: $employmentIndex, creditRiskIndex: $creditRiskIndex"
                )

                viewModel.jobViewModel.observe(this) {
                    when (it) {
                        is Result.Loading -> {
                            binding.progressBar.visibility = View.VISIBLE
                        }

                        is Result.Success -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(applicationContext, "SUCCESS!!", Toast.LENGTH_SHORT).show()
                            if (it.data.prediction == "Accept") {
                                startActivity(Intent(this, ApproveActivity::class.java))
                            } else {
                                startActivity(Intent(this, DeclineActivity::class.java))
                            }
                        }

                        else -> {
                            binding.progressBar.visibility = View.GONE
                        }
                    }
                }
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