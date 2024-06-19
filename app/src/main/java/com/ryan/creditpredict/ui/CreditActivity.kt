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
import com.ryan.creditpredict.databinding.ActivityCreditBinding

class CreditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreditBinding

    private var credit = ""
    private var installmentRate = ""
    private var otherDebtor = ""
    private var otherInstallment = ""

    private var creditIndex = 0
    private var installmentRateIndex = 0
    private var otherDebtorIndex = 0
    private var otherInstallmentIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreditBinding.inflate(layoutInflater)
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

        val genderIndex = intent.getIntExtra("genderIndex", 0)
        val numberIndex = intent.getIntExtra("numberIndex", 0)
        val employmentIndex = intent.getIntExtra("employmentIndex", 0)
        val jobIndex = intent.getIntExtra("jobIndex", 0)
        val propertyIndex = intent.getIntExtra("propertyIndex", 0)
        val purposeIndex = intent.getIntExtra("purposeIndex", 0)
        val durationIndex = intent.getIntExtra("durationIndex", 0)

        val spCredit = binding.spHistory
        val spInstallment = binding.spRate
        val spDebtor = binding.spDebtor
        val spLoan = binding.spOtherLoan

        val creditArray = resources.getStringArray(R.array.credit)
        val otherInstallmentArray = resources.getStringArray(R.array.installment_rate)
        val debtorArray = resources.getStringArray(R.array.debtors)
        val loanArray = resources.getStringArray(R.array.other_installment)

        val creditAdapter = ArrayAdapter(this, R.layout.spinner_dropdown_item, creditArray)
        val installmentAdapter = ArrayAdapter(this, R.layout.spinner_dropdown_item, otherInstallmentArray)
        val debtorAdapter = ArrayAdapter(this, R.layout.spinner_dropdown_item, debtorArray)
        val loanAdapter = ArrayAdapter(this, R.layout.spinner_dropdown_item, loanArray)

        spCredit.adapter = creditAdapter
        spInstallment.adapter = installmentAdapter
        spDebtor.adapter = debtorAdapter
        spLoan.adapter = loanAdapter

//        spCredit.setSelection(0, false)
//        spInstallment.setSelection(0, false)
//        spDebtor.setSelection(0, false)
//        spLoan.setSelection(0, false)

        spCredit.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                creditIndex = position - 1

                credit = creditArray[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        spInstallment.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                installmentRateIndex = position - 1
                installmentRate = otherInstallmentArray[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        spDebtor.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                otherDebtorIndex = position - 1
                otherDebtor = debtorArray[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        spLoan.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                otherInstallmentIndex = position - 1
                otherInstallment = loanArray[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        binding.btnNext.setOnClickListener {
            if (creditIndex != -1 && installmentRateIndex != -1 && otherDebtorIndex != -1 && otherInstallmentIndex != -1) {
//                Toast.makeText(
//                    applicationContext,
//                    "$fullname, $age, $gender, $number, $employment, $job, $property, $purpose, $duration, $ammount, $credit, $installmentRate, $otherDebtor, $otherInstallment",
//                    Toast.LENGTH_LONG
//                ).show()
                val intent = Intent(this, FamsActivity::class.java)
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

                intent.putExtra("genderIndex", genderIndex)
                intent.putExtra("numberIndex", numberIndex)
                intent.putExtra("EmploymentIndex", employmentIndex)
                intent.putExtra("jobIndex", jobIndex)
                intent.putExtra("propertyIndex", propertyIndex)

                intent.putExtra("purposeIndex", purposeIndex)
                intent.putExtra("durationIndex", durationIndex)

                intent.putExtra("creditIndex", credit)
                intent.putExtra("installmentRateIndex", installmentRateIndex)
                intent.putExtra("otherDebtorIndex", otherDebtorIndex)
                intent.putExtra("otherInstallmentIndex", otherInstallmentIndex)
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