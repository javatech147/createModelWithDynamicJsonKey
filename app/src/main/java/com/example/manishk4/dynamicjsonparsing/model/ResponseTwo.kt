package com.example.manishk4.dynamicjsonparsing.model

import com.google.gson.annotations.SerializedName

object ResponseTwo {
    data class Result(
            @SerializedName("status")
            val status: String,

            @SerializedName("search_result")
            val searchResult: ArrayList<SearchResult>
    )

    data class SearchResult(
            @SerializedName("product")
            val productName: String,

            @SerializedName("id")
            val productId: String,

            @SerializedName("question_mark")
            val questionMark: Map<String, QuestionMark>
    )


    data class QuestionMark(
            @SerializedName("count")
            val count: String,

            @SerializedName("more_description")
            val moreDescription: String,

            @SerializedName("seq")
            val sequence: String
    )
}