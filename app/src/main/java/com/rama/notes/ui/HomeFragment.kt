package com.rama.notes.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.lifecycle.lifecycleScope
import com.rama.notes.ForecastApplication
import com.rama.notes.R
import com.rama.notes.util.getViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }
    private val viewModel by viewModels<HomeViewModel> { getViewModelFactory() }

//    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        //viewModel = HomeViewModelFactory.
        //x()
        y()
//        withContext(Dispatchers.IO) {
//        Log.i("I", viewModel.getWeather("london").awa.toString())
//    }
//


        // TODO: Use the ViewModel
    }

    private fun x(){
            lifecycleScope.launch{
                viewModel.getWeather("London")
                //Log.i("I", viewModel.getWeather("london").toString())
            }
    }

    private fun y(){
        lifecycleScope.launch{
            val weather = viewModel.weather.await()

                weather.observe(viewLifecycleOwner, Observer { current ->
                    Log.i("Cuurent from db", current.toString())
                }
                )

            //Log.i("I", viewModel.getWeather("london").toString())
        }
    }

}