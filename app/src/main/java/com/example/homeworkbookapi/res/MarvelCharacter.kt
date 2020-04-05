package com.example.homeworkbookapi.res


import com.google.gson.annotations.SerializedName

data class MarvelCharacter(
    @SerializedName("attributionHTML")
    var attributionHTML: String,
    @SerializedName("attributionText")
    var attributionText: String,
    @SerializedName("code")
    var code: Int,
    @SerializedName("copyright")
    var copyright: String,
    @SerializedName("data")
    var `data`: Data,
    @SerializedName("etag")
    var etag: String,
    @SerializedName("status")
    var status: String
)