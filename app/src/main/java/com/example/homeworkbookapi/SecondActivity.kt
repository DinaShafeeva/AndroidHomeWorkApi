package com.example.homeworkbookapi

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.homeworkbookapi.databinding.ActivitySecondBinding
import com.example.homeworkbookapi.di.modules.NetModule
import com.example.homeworkbookapi.di.viewModel.ViewModelFactory
import com.example.homeworkbookapi.viewModels.CharacterViewModel


class SecondActivity : AppCompatActivity() {

    private lateinit var viewModel: CharacterViewModel
    private lateinit var binding: ActivitySecondBinding
    private lateinit var viewModelFactory: ViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.plusNetComponentBuilder().netModule(NetModule()).build()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        viewModel = ViewModelProvider(this,
            viewModelFactory).get(CharacterViewModel::class.java)

        viewModel.character(intent.extras?.getInt(KEY_ID) ?: 0).observe(this, Observer {
            binding = DataBindingUtil.setContentView<ActivitySecondBinding>(this, R.layout.activity_second)
            binding.characterViewModel = it
        })
    }

    companion object {

        private const val KEY_ID = "id"
        fun createIntent(
            activity: Activity,
            id: Long
        ) =
            Intent(activity, SecondActivity::class.java).apply {
                putExtra(KEY_ID, id)
            }
    }
}
