package com.example.homeworkbookapi.res


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("count")
    var count: Int,
    @SerializedName("limit")
    var limit: Int,
    @SerializedName("offset")
    var offset: Int,
    @SerializedName("results")
    var results: List<Result>,
    @SerializedName("total")
    var total: Int
)