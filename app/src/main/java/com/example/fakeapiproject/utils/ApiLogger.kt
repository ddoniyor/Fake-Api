package com.example.fakeapiproject.utils

import android.util.Log

object ApiLogger {
    fun isSuccess( classTag:String, responseTag:String, result:String){

    }

    fun isUnSuccess(){

    }

    fun isFailure(){

    }

    //Log.i: Use this to post useful information to the log. For example: that you have
    //successfully connected to a server. Basically use it to report successes.
    fun onSuccessLog(classTag:String,responseTag:String,result:String){
        Log.i(classTag,"Result: $result, Response Tag: $responseTag")
    }
    //Log.w: Use this when you suspect something shady is going on.
    //You may not be completely in full on error mode, but maybe you recovered
    //from some unexpected behavior. Basically, use this to log stuff you didn't
    //expect to happen but isn't necessarily an error.
    //Kind of like a "hey, this happened, and it's weird, we should look into it."
    fun onUnSuccessLog(classTag:String,responseTag:String,message:String,customCode:Int?){
        Log.w(classTag,"Message: $message, Custom Code: $customCode, Response Tag: $responseTag")
    }

    //Log.e: This is for when bad stuff happens.
    //Use this tag in places like inside a catch statement.
    //You know that an error has occurred and therefore you're logging an error.
    fun onFailureLog(classTag:String,responseTag:String,message: String){
        Log.e(classTag,"Message: $message, Response Tag: $responseTag")
    }

}