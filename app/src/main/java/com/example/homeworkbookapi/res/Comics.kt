package com.example.homeworkbookapi.res


import com.google.gson.annotations.SerializedName

data class Comics(
    @SerializedName("available")
    var available: Int,
    @SerializedName("collectionURI")
    var collectionURI: String,
    @SerializedName("items")
    var items: List<Item>,
    @SerializedName("returned")
    var returned: String
)