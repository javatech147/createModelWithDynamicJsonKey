package com.example.manishk4.dynamicjsonparsing.model

object ResponseExpedia {
    data class Result(
            val result: Map<String, ExpediaResponse>
    )

    data class ExpediaResponse(
            val propertyId: String,
            val name: String
    )
}