package com.example.loancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)
        buttonCalculate.setOnClickListener{loanCalculator()}

        val buttonReset : Button = findViewById(R.id.buttonReset)
        buttonReset.setOnClickListener{resetText()}

    }
    private fun loanCalculator() {
        val carPrice: Double = editTextCarPrice.text.toString().toDouble()
        val downPayment : Double = editTextDownPayment.text.toString().toDouble()
        val loanPeriod : Double = editTextLoanPeriod.text.toString().toDouble()
        val tinterest : Double = editTextInterestRate.text.toString().toDouble()

        var carLoan = String.format("%.2f", carPrice - downPayment)
        var interest = String.format("%.2f", carLoan.toDouble() * tinterest / 100 * loanPeriod)
        var monthlyPayment = String.format("%.2f", (carLoan.toDouble() + interest.toDouble())/ loanPeriod / 12)

        val textLoan : TextView = findViewById(R.id.textViewLoan)
        val textInterest : TextView = findViewById(R.id.textViewInterest)
        val textMonthlyPayment : TextView = findViewById(R.id.textViewMonthlyRepayment)

        textLoan.text = "Loan : " + carLoan
        textInterest.text = "Interest : " + interest
        textMonthlyPayment.text = "Monthly Payment : " + monthlyPayment



    }
    private fun resetText(){
        editTextCarPrice.text = null
        editTextDownPayment.text = null
        editTextLoanPeriod.text = null
        editTextInterestRate.text = null

        textViewLoan.text = "Loan : "
        textViewInterest.text = "Interest : "
        textViewMonthlyRepayment.text = "Monthly Repayment : "
    }
}
