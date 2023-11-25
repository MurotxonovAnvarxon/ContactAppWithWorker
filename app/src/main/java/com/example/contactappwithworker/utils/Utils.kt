package com.example.contactappwithworker.utils

import timber.log.Timber

fun myLog(message : String){
    Timber.tag("TTT").d(message)
}