package com.example.mockito_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCenter.start(application,"548a173b-4286-4729-932e-f25741f63304",Analytics::class.java, Crashes::class.java)
    }
}