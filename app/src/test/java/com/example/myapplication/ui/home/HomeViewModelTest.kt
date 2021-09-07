package com.example.myapplication.ui.home

import com.example.myapplication.FakeHomeRepo
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import com.example.myapplication.ui.home.HomeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.setMain

class HomeViewModelTest : TestCase() {

    private lateinit var homeViewModel:HomeViewModel
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")
    @Before
    public override fun setUp() {
        super.setUp()
        Dispatchers.setMain(mainThreadSurrogate)
        homeViewModel=HomeViewModel(FakeHomeRepo())
    }


    @Test
    fun `test vei model `() = runBlocking {
        launch(Dispatchers.Main) {  // Will be launched in the mainThreadSurrogate dispatcher
            Assert.assertNotNull(homeViewModel.getHomeReposne())
        }
    }
    public override fun tearDown() {}
}