package com.example.manishk4.dynamicjsonparsing.model

object ResponseOne {

    data class Result(
            val data: Data
    )

    data class Data(
            val status_code: String,
            val feeds: Map<String, Feed>
    )

    data class Feed(
            val name: String,
            val address: String
    )
}