package com.example.homeworkbookapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homeworkbookapi.di.modules.NetModule
import com.example.homeworkbookapi.di.viewModel.ViewModelFactory
import com.example.homeworkbookapi.recycler.MarvelAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import com.example.homeworkbookapi.res.Result
import com.example.homeworkbookapi.viewModels.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private var adapter: MarvelAdapter? = null
    private lateinit var viewModelFactory: ViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.plusNetComponentBuilder().netModule(NetModule())
            .build()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list: ArrayList<Result> = ArrayList<Result>()
        adapter = MarvelAdapter(list) { character ->
            navigateToSecondActivity(character.id)
        }
        rv_marvel.layoutManager = LinearLayoutManager(this)
        rv_marvel.adapter = adapter
             viewModel = ViewModelProvider(this,
                 viewModelFactory).get(MainViewModel::class.java)
        getData()
    }

    fun getData() {
        viewModel.characters().observe(this, Observer {
            try {
                adapter?.updateList( viewModel.characters().value ?: ArrayList())
                adapter?.notifyDataSetChanged()
            } catch (ex: IOException) {
                Snackbar.make(
                    findViewById(android.R.id.content),
                    "Персонажи не найдены",
                    Snackbar.LENGTH_LONG
                )
                    .show()
            }
    })
    }

    private fun navigateToSecondActivity(id: Long) {
        startActivity(SecondActivity.createIntent(this, id))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        getMenuInflater().inflate(R.menu.menu, menu);
        val searchItem: MenuItem = menu.findItem(R.id.search);
        val searchView: SearchView = searchItem.actionView as SearchView;
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                queryTextSubmit(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        });
        return true;
    }

    fun queryTextSubmit(query: String): Boolean {
        viewModel.charactersByName(query).observe(this, Observer {

        try {
            adapter?.updateList( viewModel.charactersByName(query).value ?: ArrayList())
            adapter?.notifyDataSetChanged()
            } catch (e: IOException) {
                Snackbar.make(
                    findViewById(android.R.id.content),
                    "Персонаж не найден",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        })

        return false;
    }
}
