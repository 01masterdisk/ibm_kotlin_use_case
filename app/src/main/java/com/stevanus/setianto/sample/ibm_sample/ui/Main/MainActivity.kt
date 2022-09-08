package com.stevanus.setianto.sample.ibm_sample.ui.Main

import androidx.lifecycle.Observer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.stevanus.setianto.sample.ibm_sample.data.model.ListMovie.MovieResponse


import com.stevanus.setianto.sample.ibm_sample.databinding.ActivityMainBinding
import com.stevanus.setianto.sample.ibm_sample.ui.Main.adapter.MovieAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var homeViewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    private var adapterTop:MovieAdapter?=null
    private var adapterPop:MovieAdapter?=null
    private var adapterUpc:MovieAdapter?=null

    private var page_pop=1
    private var page_upcome=1
    private var page_Top=1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        homeViewModel = MainViewModel()

        binding.loadingPopular.root.visibility=View.VISIBLE
        homeViewModel.getListMoviePopular(page_pop.toString())

        binding.loadingTopRated.root.visibility=View.VISIBLE
        homeViewModel.getListMovieTopRated(page_Top.toString())

        binding.loadingUpcoming.root.visibility=View.VISIBLE
        homeViewModel.getListMovieUpcoming(page_upcome.toString())

        observe()

    }



    private fun observe() {
        homeViewModel.popularResult.observe(this@MainActivity, Observer {
            val result = it ?: return@Observer

            binding.loadingPopular.root.visibility = View.GONE
            if (result is MovieResponse) {
                adapterPop = MovieAdapter(this@MainActivity,result.results)
                binding.poplist.adapter = adapterPop
                binding.poplist.layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
                adapterPop?.notifyDataSetChanged()
            }else{
                Toast.makeText(this@MainActivity,"Opps Can't Load Popular Movie List",Toast.LENGTH_SHORT).show()
            }


        })

        homeViewModel.topResult.observe(this@MainActivity, Observer {
            val result = it ?: return@Observer

            binding.loadingTopRated.root.visibility = View.GONE
            if (result is MovieResponse) {
                adapterTop = MovieAdapter(this@MainActivity,result.results)
                binding.toplist.adapter = adapterTop
                binding.toplist.layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
                adapterTop?.notifyDataSetChanged()
            }else{
                Toast.makeText(this@MainActivity,"Opps Can't Load Top Rated Movie List",Toast.LENGTH_SHORT).show()
            }

        })

        homeViewModel.upcomingResult.observe(this@MainActivity, Observer {
            val result = it ?: return@Observer

            binding.loadingUpcoming.root.visibility = View.GONE
            if (result is MovieResponse) {
                adapterUpc = MovieAdapter(this@MainActivity,result.results)
                binding.upcominglist.adapter = adapterUpc
                binding.upcominglist.layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
                adapterUpc?.notifyDataSetChanged()
            }else{
                Toast.makeText(this@MainActivity,"Opps Can't Load Upcoming Movie List",Toast.LENGTH_SHORT).show()
            }

        })
    }

}
