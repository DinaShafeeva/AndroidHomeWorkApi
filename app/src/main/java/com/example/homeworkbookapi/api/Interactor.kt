package com.example.homeworkbookapi.api

import com.example.homeworkbookapi.res.MarvelCharacter
import io.reactivex.Observable
import javax.inject.Inject


class Interactor {

    @Inject
    lateinit var repository: Repository

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
