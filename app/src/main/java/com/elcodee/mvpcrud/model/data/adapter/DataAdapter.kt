package com.elcodee.mvpcrud.model.data.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.elcodee.mvpcrud.R
import com.elcodee.mvpcrud.model.data.response.DataItem

class DataAdapter(private var listData: ArrayList<DataItem>) :
    RecyclerView.Adapter<DataAdapter.myviewHolder>() {
//        class myviewHolder(val binding: ListDataBinding): RecyclerView.ViewHolder(binding.root) {
//
//    }
    inner class myviewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val id: TextView = itemView.findViewById(R.id.tv_id)
        val fs: TextView = itemView.findViewById(R.id.tv_first_name)
        val ls: TextView = itemView.findViewById(R.id.tv_last_name)
        val em: TextView = itemView.findViewById(R.id.tv_email)
        val av: ImageView = itemView.findViewById(R.id.iv_avatar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_data, parent, false)
        return myviewHolder(view)
//        val binding = ListDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return myviewHolder(binding)
    }

    override fun onBindViewHolder(holder: myviewHolder, position: Int) {
        val data = listData[position]
        holder.id.text = data.id.toString()
        holder.fs.text = data.first_name
        holder.ls.text = data.last_name
        holder.em.text = data.email
        Glide.with(holder.itemView)
            .load(data.avatar)
            .into(holder.av)

//        holder.binding.tvId.text = data.id.toString()
//        holder.binding.tvFirstName.text = data.first_name
//        holder.binding.tvLastName.text = data.last_name
//        holder.binding.tvEmail.text = data.email
//        Glide.with(holder.itemView.context)
//            .load(data.avatar)
//            .into(holder.binding.ivAvatar)

    }

    override fun getItemCount() = listData.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<DataItem>) {
        listData.clear()
        listData.addAll(data)
        notifyDataSetChanged()
    }

}