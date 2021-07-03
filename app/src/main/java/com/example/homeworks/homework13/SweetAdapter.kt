package com.example.homeworks.homework13

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homeworks.R
import com.example.homeworks.databinding.ItemSweetsBinding
import com.example.homeworks.databinding.ItemSweetsCodeBinding
import com.example.homeworks.homework10.Sweet

class SweetAdapter(
    private val sweetsList: MutableList<Sweet> = mutableListOf<Sweet>(),
    private val click: (Sweet) -> Unit
) : RecyclerView.Adapter<SweetAdapter.SweetViewHolder>() {

    override fun getItemCount(): Int = sweetsList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SweetViewHolder {
        return SweetViewHolder(
            ItemSweetsCodeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), click
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
        private val bindingView: ItemSweetsCodeBinding,
        private var click: (Sweet) -> Unit
    ) :
        RecyclerView.ViewHolder(bindingView.root) {
        fun bind(item: Sweet) {
            bindingView.code.text = bindingView.root.context.getString(R.string.code) + item.code
            itemView.setOnClickListener {
                click(item)
            }
        }
    }
}