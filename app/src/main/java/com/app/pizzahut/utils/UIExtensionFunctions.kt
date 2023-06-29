package com.app.pizzahut.utils

import android.view.View
import androidx.viewbinding.ViewBinding
import com.app.pizzahut.MainActivity
import com.app.pizzahut.MainApplication

fun View.gone(){
    this.visibility = View.GONE
}

fun View.show(){
    this.visibility = View.VISIBLE
}

fun ViewBinding.gone(){
    this.root.gone()
}

fun ViewBinding.show(){
    this.root.show()
}

fun View.onClick(fn:()->Unit){
    this.setOnClickListener {
        fn()
    }
}

fun getColor(id:Int): Int {
    return MainApplication.context!!.resources.getColor(id)
}