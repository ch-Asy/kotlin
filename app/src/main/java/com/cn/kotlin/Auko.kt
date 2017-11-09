package com.cn.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext

class Auko : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auko)
    }

    class MyUI :AnkoComponent<Auko>{
        override fun createView(ui: AnkoContext<Auko>): View {
           return ui.apply {
//                vertical
            }.view
        }

    }
}

