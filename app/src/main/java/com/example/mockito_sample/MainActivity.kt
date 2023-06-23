package com.example.mockito_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes

class MainActivity : AppCompatActivity() {

    private lateinit var button : Button
    private lateinit var interestEditText: EditText
    private lateinit var currentAge: EditText
    private lateinit var retirementAge: EditText
    private lateinit var resultTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCenter.start(application,"548a173b-4286-4729-932e-f25741f63304",Analytics::class.java, Crashes::class.java  )

        button = findViewById<Button>(R.id.calculateButton)
        interestEditText = findViewById(R.id.interestEditText)
        currentAge= findViewById(R.id.ageEditText)
        retirementAge=findViewById(R.id.retirementEditText)
        resultTextView=findViewById(R.id.resultTextView)
        button.setOnClickListener {
             //Crashes.generateTestCrash()
            //throw Exception("Something wrong")

            val interestRate = interestEditText.text.toString().toFloat()
            val currentAgeValue = currentAge.text.toString().toInt()
            val retirementAgeValue = retirementAge.text.toString().toInt()
            if(interestRate<=0){
                Analytics.trackEvent("Wrong_interest_rate")
            }
            if(retirementAgeValue<=currentAgeValue){
                Analytics.trackEvent("Wrong_age")
            }
            resultTextView.text="curent rate is $interestRate"
        }

    }
}