package com.armstrong.calculate

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.armstrong.calculate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var activityMainBinding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        displayResult()
        activityMainBinding.btnCalculate.setOnClickListener(this)
    }

    private fun displayResult() {
        activityMainBinding.tvResult.text = mainViewModel.result.toString()
    }

    override fun onClick(view: View?) {
        val width = activityMainBinding.edtWidth.text.toString()
        val length = activityMainBinding.edtLength.text.toString()
        val height = activityMainBinding.edtHeight.text.toString()

        when {
            width.isEmpty() -> {
                activityMainBinding.edtWidth.error = "Empty width"
            }
            height.isEmpty() -> {
                activityMainBinding.edtHeight.error = "Empty height"
            }
            length.isEmpty() -> {
                activityMainBinding.edtLength.error = "Empty length"
            }
            else -> {
                mainViewModel.calculate(width, height, length)
                displayResult()
            }
        }
    }
}