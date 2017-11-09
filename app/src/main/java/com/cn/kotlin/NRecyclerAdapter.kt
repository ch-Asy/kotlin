package com.cn.kotlin

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by anliyuan on 2017/10/18.
 */
class NRecyclerAdapter(val list: List<String>?) : RecyclerView.Adapter<NRecyclerAdapter.NViewHolder>() {
    override fun onBindViewHolder(holder: NViewHolder?, position: Int) {
        holder?.tv?.text=list?.get(position)
    }

    override fun getItemCount(): Int= list?.size?:0

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NViewHolder= NViewHolder(TextView(parent!!.context))


    class NViewHolder(val tv:TextView) : RecyclerView.ViewHolder(tv)
}