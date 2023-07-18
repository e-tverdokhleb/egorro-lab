package com.egorro.etlab.tools

import android.util.Log

const val TAG = "XXX"

inline fun Any?.l(a: Any? = null, tag: String = TAG) {
    val methodName = Throwable().stackTrace[0].methodName
    val msg = " ${this?.javaClass?.simpleName}." +
            "$methodName() |:   ${a ?: "_"}"
    when (a) {
        is Exception -> Log.e(tag, msg)
        else -> Log.d(tag, msg)
    }
}

inline fun l(a: Any? = null, tag: String = TAG) {
    val methodName = Throwable().stackTrace[0].methodName
    val msg = "$methodName() |:   ${a ?: "_"}"
    when (a) {
        is Exception -> Log.e(tag, msg)
        else -> Log.d(tag, msg)
    }
}