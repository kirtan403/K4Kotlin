package com.livinglifetechway.k4kotlinsample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.livinglifetechway.k4kotlin.setBindingView
import com.livinglifetechway.k4kotlinsample.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = setBindingView(R.layout.activity_home)

        mBinding.btnMain.setOnClickListener {
            startActivity(Intent(this@HomeActivity, MainActivity::class.java))
        }
        mBinding.btnAnim.setOnClickListener {
            startActivity(Intent(this@HomeActivity, AnimationActivity::class.java))
        }
        mBinding.btnRetrofit.setOnClickListener {
            startActivity(Intent(this@HomeActivity, RetrofitActivity::class.java))
        }
    }
}
