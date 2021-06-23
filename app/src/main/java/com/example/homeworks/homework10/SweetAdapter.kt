package com.example.homeworks.homework10

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homeworks.R
import com.example.homeworks.databinding.ItemSweetsBinding

class SweetAdapter(
    private val sweetsList: MutableList<Sweet>,
    private val context: Context
) : RecyclerView.Adapter<SweetAdapter.SweetViewHolder>() {

    override fun getItemCount(): Int = sweetsList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SweetViewHolder {
        return SweetViewHolder(
            ItemSweetsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), context
        )
    }


    override fun onBindViewHolder(holder: SweetViewHolder, position: Int) {
        holder.bind(sweetsList[position])
    }

    fun updateList(newSweetList: MutableList<Sweet>) {
        sweetsList.clear()
        sweetsList.addAll(newSweetList)
    }

    class SweetViewHolder(
        private val bindingView: ItemSweetsBinding,
        private val context: Context
    ) :
        RecyclerView.ViewHolder(bindingView.root) {

        fun bind(item: Sweet) {
            bindingView.brand.text = context.getString(R.string.brand) + item.brand
            bindingView.code.text = context.getString(R.string.code) + item.code
            Glide.with(bindingView.sweetsImage).load(item.urlPackage).into(bindingView.sweetsImage)
        }
    }
}