package com.example.movielist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movielist.databinding.ActivityMainBinding
import com.example.movielist.utils.Response
import com.example.movielist.utils.SpacesItemDecoration
import com.example.movielist.viewmodel.MainViewModel
import com.example.movielist.viewmodel.ViewModelFactory
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var viewModel: MainViewModel
    lateinit var binding: ActivityMainBinding
    private var showAdapter: MovieListAdapter = MovieListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        setContentView(binding.root)

        initRecyclerView()
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        viewModel.showDetails.observe(this) {
            when (it) {
                is Response.Success -> {
                    it.data?.let { data ->
                        showAdapter.setData(data)
                    }
                }
                is Response.Loading -> {

                }
                is Response.Error -> {

                }
            }
        }
        viewModel.getShowDetails("girls")
    }

    private fun initRecyclerView() {
        binding.rcShowList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rcShowList.addItemDecoration(SpacesItemDecoration(20))
        binding.rcShowList.adapter = showAdapter
    }
}