package com.example.movielist.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.movielist.FakeRepository
import com.example.movielist.MainCoroutineRule
import com.example.movielist.getOrAwaitValueTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        viewModel = MainViewModel(FakeRepository())
    }

    @Test
    fun test_movies_list_success() {
        viewModel.getShowDetails("test")
        val data = viewModel.showDetails.getOrAwaitValueTest()
        Assert.assertTrue(data.data?.size == 1)
    }
}