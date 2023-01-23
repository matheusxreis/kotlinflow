package com.matheusxreis.kotlinflow

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.matheusxreis.kotlinflow.adapters.MessageAdapter
import com.matheusxreis.kotlinflow.databinding.ActivityMainBinding
import com.matheusxreis.kotlinflow.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel;
    private lateinit var binding:ActivityMainBinding;
    private val messageAdapter by lazy {
        MessageAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setupRecyclerView()
        populateRecyclerView()
    }

    fun setupRecyclerView(){
            binding.messagesRv.adapter = messageAdapter;
            binding.messagesRv.layoutManager = LinearLayoutManager(applicationContext)
    }

    fun populateRecyclerView(){
        mainViewModel.message.observe(this) {
            messageAdapter.setData(it)
        }
    }
}