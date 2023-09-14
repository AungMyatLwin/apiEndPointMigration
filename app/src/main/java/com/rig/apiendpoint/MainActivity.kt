package com.rig.apiendpoint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.rig.apiendpoint.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


private lateinit var binding:ActivityMainBinding
private lateinit var recyclerAdapter:RecyclerAdapter

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel:MyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getAllEntries()

        viewModel.datas.observe(this, Observer {
//            recyclerAdapter=RecyclerAdapter(it.entries)
//            binding.recyclerView.apply {
//                adapter = recyclerAdapter
//                layoutManager = LinearLayoutManager(this@MainActivity)
//            }
            Log.d("Datas", "onCreate: ${it.entries}")
            binding.recyclerView.setContent {
                ReuseLazyColum(it.entries)
            }
        })

        viewModel.random.observe(this, Observer{
            binding.recyclerView.setContent {
                ReuseLazyColum(it.entries)
            }
            Log.d("Datas", "onCreate: ${it.entries}")
        })

        binding.random.setOnClickListener{
            viewModel.getSurprise()
        }
    }
}