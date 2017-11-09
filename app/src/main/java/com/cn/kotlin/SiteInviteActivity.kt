package com.cn.kotlin

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.widget.TextView
import java.util.*

/**
 * Created by anliyuan on 2017/10/19.
 */
class SiteInviteActivity : BaseActivity(), BaseActivity.onLeftOnClickListener {
    override fun onLeftClick() {
        finish()
    }

    val toolbar :Toolbar? by lazy {
        findViewById(R.id.toolbar) as Toolbar
    }

    val toolbar_title :TextView? by lazy {
        findViewById(R.id.toolbar_title) as TextView
    }

    val recycler: RecyclerView? by lazy {
        findViewById(R.id.forecast_list) as RecyclerView
    }


    override fun getLayoutId(): Int = R.layout.activity_main

    override fun setUpView() {

        val students = ArrayList<Student>()

        for (i in 0..9) {
            val student = Student(if (i % 2 == 0) "小红" + i else "小明" + i, if (i % 2 == 0) "女" else "男")
            students.add(student)
        }

        recycler!!.layoutManager=LinearLayoutManager(this)
        val siteInviteAdapter = SiteInviteAdapter(students, null)
        recycler!!.adapter= siteInviteAdapter

        students.add(Student("asy","男"))
        siteInviteAdapter.lists=students
    }

    override fun setUpData() {

    }

    override fun initToolBar(savedInstanceState: Bundle?) {
        setToolBar(toolbar,toolbar_title,"我的kotlin",true,R.drawable.abc_text_select_handle_left_mtrl_light,this)
    }
}