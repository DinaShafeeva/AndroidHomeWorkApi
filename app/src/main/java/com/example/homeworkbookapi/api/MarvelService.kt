package com.example.homeworkbookapi.api

import androidx.annotation.Nullable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import com.example.homeworkbookapi.res.MarvelCharacter
import io.reactivex.Observable


interface MarvelService {

    @GET("/v1/public/characters")
    public fun getCharacters(@SuppressWarnings("SameParameterValue") @Nullable @Query("orderBy") modified: String,
                             @Query("ts") ts: String,
                             @Query("apikey") apiKey: String,
                             @Query("hash") hash: String,
                             @Nullable @Query("offset") offset: Int,
                             @Query("limit") limit: Int): Observable<MarvelCharacter>

    @GET("/v1/public/characters/{id}")
    public fun getCharacterDetail(@Path("id") id: String,
                                  @Query("ts") ts: String,
                                  @Query("apikey") apiKey: String,
                                  @Query("hash") hash: String)
            : Observable<MarvelCharacter>

        @GET("/v1/public/characters")
    public fun searchCharacterNameStartsWith(@Query("nameStartsWith") nameStartsWith: String,
                                             @Query("apikey") apiKey: String,
                                             @Query("hash") hash: String,
                                             @Query("ts") ts: String,
                                             @Query("orderBy") orderBy: String,
                                             @Nullable @Query("offset") offset: Int,
                                             @Query("limit") limit: Int)
                : Observable<MarvelCharacter>
}
