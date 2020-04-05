package com.example.homeworkbookapi

import com.example.homeworkbookapi.res.MarvelCharacter
import io.reactivex.Observable
import java.util.*
import kotlin.collections.ArrayList


class Repository( val marvelService: MarvelService) {
    val defaultLimit = 10
    var offset = 0
    val timestamp = Date().time
    val hash = Utils.md5(timestamp.toString() + "a3d7fcf6d56977ea915495d3f40e47eb8ea4249e"+ BuildConfig.API_KEY)

    fun getCharacters(): Observable<MarvelCharacter> {
        return marvelService.getCharacters("-modified", timestamp.toString(),
            BuildConfig.API_KEY, hash, offset, defaultLimit)
    }
    fun getCharacterById(id: Int): Observable<MarvelCharacter>{
        return marvelService.getCharacterDetail(id.toString(),timestamp.toString(),
            BuildConfig.API_KEY, hash)
    }
    fun searchCharacterByName( nameStartsWith : String) : Observable<MarvelCharacter> {
        return marvelService.searchCharacterNameStartsWith(nameStartsWith ,
            BuildConfig.API_KEY, hash, timestamp.toString() , "name", offset, defaultLimit)
    }
}
