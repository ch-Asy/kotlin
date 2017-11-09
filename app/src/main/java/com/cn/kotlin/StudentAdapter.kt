package com.cn.kotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.*

/**
 * Created by anliyuan on 2017/10/18.
 */
class StudentAdapter(val students: ArrayList<Student>?) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    override fun onBindViewHolder(holder: StudentViewHolder?, position: Int) {
        holder?.bindData2View(students?.get(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): StudentViewHolder {
        val view=LayoutInflater.from(parent!!.context).inflate(R.layout.item_list, parent,false)
        val studentViewHolder = StudentViewHolder(view)
        return studentViewHolder
    }

    override fun getItemCount(): Int = students!!.size

    class StudentViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val name: TextView by lazy {
            view.findViewById(R.id.item_list_name) as TextView
        }
        val sex: TextView by lazy {
            view.findViewById(R.id.item_list_sex) as TextView
        }

        fun bindData2View(student: Student?) {
            name.text=student?.name
            sex.text=student?.sex
        }
    }
}
