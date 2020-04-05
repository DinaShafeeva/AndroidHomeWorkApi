package com.example.homeworkbookapi

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import com.example.homeworkbookapi.res.Result

class CharacterViewModel(): ViewModel() {
    private  var resultLiveData: MutableLiveData<Result> = MutableLiveData()
    val interactor: Interactor = Interactor()

    fun  getCharacterMutableLiveData(id: Int): MutableLiveData<Result> {

        var data:Disposable = interactor.getCharacter(id).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
                    data -> resultLiveData.value = data.data.results.get(0)
                Log.e("Character: " , data.toString())
            },
                {
                        error -> Log.e("Error" , error.toString())
                })

        return resultLiveData

    }

    fun character(id: Int): LiveData<Result> = getCharacterMutableLiveData(id)
}
