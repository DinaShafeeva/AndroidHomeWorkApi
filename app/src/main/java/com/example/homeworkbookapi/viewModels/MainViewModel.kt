package com.example.homeworkbookapi.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homeworkbookapi.api.Interactor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import com.example.homeworkbookapi.res.Result
import javax.inject.Inject


class MainViewModel() : ViewModel() {

    private  var resultLiveData: MutableLiveData<List<Result>> = MutableLiveData<List<Result>>()

    @Inject
   lateinit var interactor: Interactor

    fun  getCharactersMutableLiveData(): MutableLiveData<List<Result>> {
            var data: Disposable = interactor.getCharacters().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({
                     data ->

                        resultLiveData.value = data.data.results
                    Log.e("Characters: ", data.toString())
                },
                    { error ->
                        Log.e("Error", error.toString())
                    })

        return resultLiveData
    }
    fun characters(): LiveData<List<Result>> = getCharactersMutableLiveData()

    fun  getCharactersMutableLiveDataByName(name: String): MutableLiveData<List<Result>> {

        var data: Disposable = interactor.getCharactersByName(name).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
                    data ->
                    resultLiveData.value = data.data.results

                Log.e("Characters: " , data.toString())
            },
                {
                        error -> Log.e("Error" , error.toString())
                })

        return resultLiveData
    }

    fun charactersByName(name:String): LiveData<List<Result>> = getCharactersMutableLiveDataByName(name)
}
