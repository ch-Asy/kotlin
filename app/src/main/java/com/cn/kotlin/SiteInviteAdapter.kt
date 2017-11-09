package com.cn.kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by anliyuan on 2017/10/19.
 */
class SiteInviteAdapter(val list: List<Student>, header: View?) : BaseHeaderAdapter<Student>(list, header) {


    override fun Holder(view: View?, viewType: Int): BaseViewHolder =SiteInviteHolder(view,list)

    override fun inflate(parent: ViewGroup?, viewType: Int): View
            = LayoutInflater.from(parent!!.context).inflate(R.layout.item_list,parent,false)



    class SiteInviteHolder(val view: View?,val list: List<Student>) : BaseViewHolder(view){

        val name: TextView by lazy {
            view!!.findViewById(R.id.item_list_name) as TextView
        }
        val sex: TextView by lazy {
            view!!.findViewById(R.id.item_list_sex) as TextView
        }

        override fun onItemClick(view: View?, position: Int) {
        }

        override fun onBindViewHolder(position: Int) {
            name.text=list.get(position).name
            sex.text=list.get(position).sex
        }

    }
}