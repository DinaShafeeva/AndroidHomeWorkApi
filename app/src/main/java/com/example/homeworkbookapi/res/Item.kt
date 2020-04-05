package com.example.homeworkbookapi.res


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("name")
    var name: String,
    @SerializedName("resourceURI")
    var resourceURI: String
)