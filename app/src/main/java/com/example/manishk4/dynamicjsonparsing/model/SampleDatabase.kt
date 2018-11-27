package com.example.manishk4.dynamicjsonparsing.model

import android.content.Context

object SampleDatabase {
    fun getJsonResponse(context: Context, fileName:String): String {
        val inputStream = context.assets.open(fileName)
        val size = inputStream.available()
        var buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        return String(buffer)
    }
}