package com.livinglifetechway.k4kotlinsample

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.livinglifetechway.k4kotlin.*
import com.livinglifetechway.k4kotlinsample.databinding.ActivityAnimationBinding

class AnimationActivity : AppCompatActivity() {

    val mBinding: ActivityAnimationBinding by lazy {
        DataBindingUtil.setContentView<ActivityAnimationBinding>(this, R.layout.activity_animation)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val duration = 1000L

        mBinding.imageView.post {
            val initialX = mBinding.imageView.x
            val initialY = mBinding.imageView.y

            val listener = object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    super.onAnimationEnd(animation)
                    mBinding.imageView.x = initialX
                    mBinding.imageView.y = initialY
                }
            }

            mBinding.buttonEnterFromTop.setOnClickListener { mBinding.imageView.enterFromTop(duration)?.setListener(listener) }
            mBinding.buttonEnterFromLeft.setOnClickListener { mBinding.imageView.enterFromLeft(duration)?.setListener(listener) }
            mBinding.buttonEnterFromBottom.setOnClickListener { mBinding.imageView.enterFromBottom(duration)?.setListener(listener) }
            mBinding.buttonEnterFromRight.setOnClickListener { mBinding.imageView.enterFromRight(duration)?.setListener(listener) }
            mBinding.buttonExitToTop.setOnClickListener { mBinding.imageView.exitToTop(duration)?.setListener(listener) }
            mBinding.buttonExitToLeft.setOnClickListener { mBinding.imageView.exitToLeft(duration)?.setListener(listener) }
            mBinding.buttonExitToBottom.setOnClickListener { mBinding.imageView.exitToBottom(duration)?.setListener(listener) }
            mBinding.buttonExitToRight.setOnClickListener { mBinding.imageView.exitToRight(duration)?.setListener(listener) }
        }

    }
}
