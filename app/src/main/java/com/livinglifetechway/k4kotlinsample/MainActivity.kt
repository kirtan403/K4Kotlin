package com.livinglifetechway.k4kotlinsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.livinglifetechway.k4kotlin.core.debug
import com.livinglifetechway.k4kotlin.core.err
import com.livinglifetechway.k4kotlin.core.fadeIn
import com.livinglifetechway.k4kotlin.core.fadeOut
import com.livinglifetechway.k4kotlin.core.hide
import com.livinglifetechway.k4kotlin.core.hideKeyboard
import com.livinglifetechway.k4kotlin.core.hideViews
import com.livinglifetechway.k4kotlin.core.info
import com.livinglifetechway.k4kotlin.core.invisible
import com.livinglifetechway.k4kotlin.core.onClick
import com.livinglifetechway.k4kotlin.core.onItemSelected
import com.livinglifetechway.k4kotlin.core.orZero
import com.livinglifetechway.k4kotlin.core.setItems
import com.livinglifetechway.k4kotlin.core.show
import com.livinglifetechway.k4kotlin.core.showKeyboard
import com.livinglifetechway.k4kotlin.core.showViews
import com.livinglifetechway.k4kotlin.core.startActivity
import com.livinglifetechway.k4kotlin.core.toast
import com.livinglifetechway.k4kotlin.core.toggleVisibility
import com.livinglifetechway.k4kotlin.core.verbose
import com.livinglifetechway.k4kotlin.core.warning
import com.livinglifetechway.k4kotlin.core.wtf
import com.livinglifetechway.k4kotlinsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val mBinding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val helloWorld = mBinding.helloWorld

        mBinding.buttonShow.onClick { helloWorld.show() }
        mBinding.buttonHide.onClick { helloWorld.hide() }
        mBinding.buttonInvisible.onClick { helloWorld.invisible() }
        mBinding.buttonToggle.onClick { helloWorld.toggleVisibility() }
        mBinding.buttonFadeIn.onClick { helloWorld.fadeIn() }
        mBinding.buttonFadeOut.onClick { helloWorld.fadeOut() }
        mBinding.buttonHideKeyboard.onClick { hideKeyboard() }
        mBinding.buttonShowKeyboard.onClick { mBinding.edit.showKeyboard() }
        mBinding.buttonShowAll.onClick { showViews(mBinding.helloWorld, mBinding.edit) }
        mBinding.buttonHideAll.onClick { hideViews(mBinding.helloWorld, mBinding.edit) }

        // set spinner - example
        data class Country(var name: String, var code: String)

        // some logs are here
        debug("This is a debug log!")
        info("This is info log")
        err("err log it is...")
        verbose("What's this, verbose? ")
        warning("I am warning you!!")
        wtf("WTF!")

        val countries: ArrayList<Country> = ArrayList()
        countries.add(Country("India", "IND"))
        countries.add(Country("United States of America", "USA"))
        mBinding.spinner.setItems(countries) { it.name + " (" + it.code + ")" }

        mBinding.spinner.onItemSelected { _, _, position, _ ->
            val (name, _) = countries[position.orZero()]
            toast("You selected : $name")
        }

        mBinding.buttonEnterExitAnimation.setOnClickListener {
            startActivity<AnimationActivity>()
        }
    }
}
