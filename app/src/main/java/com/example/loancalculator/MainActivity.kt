package com.example.loancalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener{
            calculateLoan()

        }
        findViewById<Button>(R.id.buttonReset).setOnClickListener{
            reset()

        }
    }
    private fun calculateLoan(){

        val carPrice: Double = editTextCarPrice.text.toString().toDouble()
        val downPayment: Double = editTextDownPayment.text.toString().toDouble()
        val interestR: Double = editTextInterestRate.text.toString().toDouble()
        val loanPeriod: Double = editTextLoanPeriod.text.toString().toDouble()
        var carLoan = String.format("%.2f", carPrice - downPayment)

        var interest = String.format("%.2f", carLoan.toDouble() * interestR * loanPeriod/100)
        var repayment = String.format("%.2f", (carLoan.toDouble() + interest.toDouble())/ loanPeriod/12)

        val textLoan: TextView = findViewById(R.id.textViewLoan)
        val textInterest: TextView = findViewById(R.id.textViewInterest)
        val textMonthly: TextView = findViewById(R.id.textViewMonthlyRepayment)

        textLoan.text = "Loan: RM "+ carLoan
        textInterest.text = "Interest: RM "+ interest
        textMonthly.text = "Monthly repayment: RM "+ repayment
    }
    private fun reset(){
        editTextCarPrice.text = null
        editTextDownPayment.text = null
        editTextInterestRate.text = null
        editTextLoanPeriod.text = null
        textViewLoan.text = null
        textViewInterest.text = null
        textViewMonthlyRepayment.text = null


    }
}
