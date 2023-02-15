package com.elcodee.mvpcrud.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.elcodee.mvpcrud.R
import com.elcodee.mvpcrud.databinding.ActivityPutBinding
import com.elcodee.mvpcrud.model.contract.PutContract
import com.elcodee.mvpcrud.presenter.PutPresenter
import com.google.gson.JsonObject

class PutActivity : AppCompatActivity(), PutContract.View {
    private lateinit var presenter: PutPresenter
    private val binding: ActivityPutBinding by lazy{
        ActivityPutBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presenter = PutPresenter(this)
    }

    override fun initActivity() {
        supportActionBar?.hide()
    }

    override fun initListener() {
        binding.btnPut.setOnClickListener {
            val update = JsonObject()
            update.addProperty("name", binding.etName.text.toString())
            update.addProperty("job", binding.etJob.text.toString())
            presenter.putData(update)
        }
    }

    override fun onMessage(Message: String) {
        Toast.makeText(this@PutActivity, Message, Toast.LENGTH_SHORT).show()
    }
}