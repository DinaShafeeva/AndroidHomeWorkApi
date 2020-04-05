package com.example.homeworkbookapi.res


import com.google.gson.annotations.SerializedName

data class Events(
    @SerializedName("available")
    var available: Int,
    @SerializedName("collectionURI")
    var collectionURI: String,
    @SerializedName("items")
    var items: List<ItemX>,
    @SerializedName("returned")
    var returned: Int
)