package com.example.homeworkbookapi.res


import com.google.gson.annotations.SerializedName

data class ItemXXX(
    @SerializedName("name")
    var name: String,
    @SerializedName("resourceURI")
    var resourceURI: String,
    @SerializedName("type")
    var type: String
)