package com.example.homeworkbookapi.res


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("comics")
    var comics: Comics,
    @SerializedName("description")
    var description: String,
    @SerializedName("events")
    var events: Events,
    @SerializedName("id")
    var id: Long,
    @SerializedName("modified")
    var modified: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("resourceURI")
    var resourceURI: String,
    @SerializedName("series")
    var series: Series,
    @SerializedName("stories")
    var stories: Stories,
    @SerializedName("thumbnail")
    var thumbnail: Thumbnail,
    @SerializedName("urls")
    var urls: List<Url>
)