package com.matheusxreis.kotlinflow

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.matheusxreis.kotlinflow.adapters.MessageAdapter
import com.matheusxreis.kotlinflow.data.MessageRepository
import com.matheusxreis.kotlinflow.databinding.ActivityMainBinding
import com.matheusxreis.kotlinflow.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel;
    private lateinit var binding: ActivityMainBinding;
    private val messageAdapter by lazy {
        MessageAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel =
            ViewModelProvider(this, MainViewModel.MainViewModelFactory(MessageRepository())).get(
                MainViewModel::class.java
            )
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setupRecyclerView()
        populateRecyclerView()
        getMessages()
    }

    fun setupRecyclerView() {
        val linearLayout = LinearLayoutManager(applicationContext)
        linearLayout.stackFromEnd = true


        binding.messagesRv.adapter = messageAdapter;
        binding.messagesRv.layoutManager = linearLayout;
    }

    fun populateRecyclerView() {
        mainViewModel.message.observe(this) {
            messageAdapter.setData(it)
            scrollRecyclerView()

        }
    }

    fun scrollRecyclerView(){
        val bottom = binding.messagesRv.adapter?.itemCount

        if(bottom != null && bottom != 0){
            binding.messagesRv.smoothScrollToPosition(
                bottom - 1
            )
        }

    }

    fun getMessages() {
        mainViewModel.observeMessages()
    }
}