package com.example.manishk4.dynamicjsonparsing

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.manishk4.dynamicjsonparsing.model.ResponseExpedia
import com.example.manishk4.dynamicjsonparsing.model.ResponseOne
import com.example.manishk4.dynamicjsonparsing.model.ResponseTwo
import com.example.manishk4.dynamicjsonparsing.model.SampleDatabase
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //parseFileOne("response_one.json")
        // parseFileTwo("response_array.json")
        parseExpediaResponse("expedia_response.json")
    }

    private fun parseFileOne(fileName: String) {
        val responseString = SampleDatabase.getJsonResponse(this, fileName)
        Log.d(TAG, "ResponseOne String $responseString")

        val gson = Gson()
        val response: ResponseOne.Result = gson.fromJson<ResponseOne.Result>(responseString, object : TypeToken<ResponseOne.Result>() {}.type)
        val data = response.data
        val statusCode = data.status_code
        println("Status Code $statusCode")
        val feeds: Map<String, ResponseOne.Feed> = data.feeds
        feeds.forEach { key, value -> println("Id : $key -- Name : ${value.name} and Address : ${value.address}") }
    }

    private fun parseFileTwo(fileName: String) {
        val responseString = SampleDatabase.getJsonResponse(this, fileName)
        Log.d(TAG, "ResponseOne String $responseString")
        val gson = Gson()

        val response = gson.fromJson<ResponseTwo.Result>(responseString, object : TypeToken<ResponseTwo.Result>() {}.type)
        val status = response.status

        println("Status $status")
        val searchResult = response.searchResult
        for (result in searchResult) {
            val productId = result.productId
            val productName = result.productName
            val questionmark = result.questionMark

            println("Product Id : $productId")
            println("Product Name : $productName")
            println("Question Mark : $questionmark")
        }
    }

    private fun parseExpediaResponse(fileName: String) {
        val responseString = SampleDatabase.getJsonResponse(this, fileName)
        Log.d(TAG, "ResponseOne String $responseString")
        val gson = Gson()
        val response = gson.fromJson<ResponseExpedia.Result>(responseString, object : TypeToken<ResponseExpedia.Result>() {}.type)
        val result = response.result
        println("Result $result")
    }
}
