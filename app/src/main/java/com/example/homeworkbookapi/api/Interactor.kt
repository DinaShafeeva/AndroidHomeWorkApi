package com.example.homeworkbookapi.api

import com.example.homeworkbookapi.api.ApiFactory
import com.example.homeworkbookapi.api.Repository
import com.example.homeworkbookapi.res.MarvelCharacter
import io.reactivex.Observable


class Interactor {
    private val repository: Repository =
        Repository(ApiFactory.marvelService)

    fun getCharacters(): Observable<MarvelCharacter> {
        return repository.getCharacters()
    }

    fun getCharactersByName(name: String): Observable<MarvelCharacter> {
        return repository.searchCharacterByName(name)
    }

    fun getCharacter(id: Int): Observable<MarvelCharacter> {
        return repository.getCharacterById(id)
    }
}