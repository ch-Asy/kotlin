package com.ann.http.iml

/**
 * Created by anliyuan on 2017/11/10.
 */
interface OnHttpRequestListener<T> {
    fun onSuccess(t: T)
    fun onError(t: T)
}