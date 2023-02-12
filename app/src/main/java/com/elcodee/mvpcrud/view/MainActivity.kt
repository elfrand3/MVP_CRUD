package com.elcodee.mvpcrud.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.elcodee.mvpcrud.databinding.ActivityMainBinding
import com.elcodee.mvpcrud.model.contract.MainContract
import com.elcodee.mvpcrud.model.data.adapter.DataAdapter
import com.elcodee.mvpcrud.model.data.response.ResponseGet
import com.elcodee.mvpcrud.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainContract.View {

    var adapter = DataAdapter(arrayListOf())
    private lateinit var presenter: MainPresenter
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presenter = MainPresenter(this)
        presenter.getData()
    }

    override fun initActivity() {
        supportActionBar?.hide()
        binding.rvData.layoutManager = LinearLayoutManager(this)
        binding.rvData.adapter = adapter
    }

    override fun initListener() {
    }

    override fun onMessage(Message: String) {
        Toast.makeText(this, Message, Toast.LENGTH_SHORT).show()
    }

    override fun setData(response: ResponseGet) {
        val r = response.data
        adapter.setData(r)
    }
}