package com.livinglifetechway.k4kotlinsample

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.livinglifetechway.k4kotlin.*
import com.livinglifetechway.k4kotlinsample.databinding.ActivityMainBinding
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    val mBinding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val helloWorld = mBinding.helloWorld

        mBinding.buttonShow.setOnClickListener { helloWorld.show() }
        mBinding.buttonHide.setOnClickListener { helloWorld.hide() }
        mBinding.buttonInvisible.setOnClickListener { helloWorld.invisible() }
        mBinding.buttonToggle.setOnClickListener { helloWorld.toggle() }
        mBinding.buttonFadeIn.setOnClickListener { helloWorld.fadeIn() }
        mBinding.buttonFadeOut.setOnClickListener { helloWorld.fadeOut() }
        mBinding.buttonHideKeyboard.setOnClickListener { hideKeyboard() }
        mBinding.buttonShowAll.setOnClickListener { showViews(mBinding.helloWorld, mBinding.edit) }
        mBinding.buttonHideAll.setOnClickListener { hideViews(mBinding.helloWorld, mBinding.edit) }

        // set spinner - example
        data class Country(var name: String, var code: String)

        val countries: ArrayList<Country> = ArrayList<Country>()
        countries.add(Country("India", "IND"))
        countries.add(Country("United States of America", "USA"))
        mBinding.spinner.setItems(countries) { it.name + " (" + it.code + ")" }

        mBinding.spinner.onItemSelected { _, _, position, _ ->
            val (name, _) = countries[position.orZero()]
            toast("You selected : $name")
        }
    }
}
