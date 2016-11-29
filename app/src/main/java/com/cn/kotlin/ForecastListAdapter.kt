package com.cn.kotlin

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

/**
 * Package :com.cn.kotlin.
 * Author :ann.
 * Time:2016/11/29_11:54.
 */
class ForecastListAdapter(val items:List<String>?) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun getItemCount(): Int =items?.size?:0

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.tv?.text = items?.get(position)
    }
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder = ViewHolder(TextView(parent!!.context))

    class ViewHolder(val tv:TextView) : RecyclerView.ViewHolder(tv)
}