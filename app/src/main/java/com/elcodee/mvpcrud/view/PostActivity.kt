package com.elcodee.mvpcrud.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.elcodee.mvpcrud.databinding.ActivityPostBinding
import com.elcodee.mvpcrud.model.contract.PostContact
import com.elcodee.mvpcrud.presenter.PostPresenter
import com.google.gson.JsonObject

class PostActivity : AppCompatActivity(), PostContact.View {
    private lateinit var presenter: PostPresenter
    private val binding: ActivityPostBinding by lazy {
        ActivityPostBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presenter = PostPresenter(this)
    }

    override fun initActivity() {
        supportActionBar?.hide()
    }

    override fun initListener() {
        binding.btnPost.setOnClickListener {
            val data = JsonObject()
            data.addProperty("name",binding.etName.toString())
            data.addProperty("job",binding.etJob.toString())
            presenter.postData(data)
        }
    }

    override fun onMessage(Message: String) {
        Toast.makeText(this@PostActivity, "$Message", Toast.LENGTH_SHORT).show()
    }
}