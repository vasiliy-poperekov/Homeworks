package com.example.homeworks.homework10

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworks.R
import com.example.homeworks.databinding.ActivityHomework7Binding
import com.example.homeworks.databinding.ItemSweetsBinding

class SweetAdapter(
    private val sweetsList: ArrayList<Sweet>
) : RecyclerView.Adapter<SweetAdapter.SweetViewHolder>(){

    override fun getItemCount(): Int = sweetsList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SweetViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_sweets, parent, false)
        return SweetViewHolder(view)
    }

    override fun onBindViewHolder(holder: SweetViewHolder, position: Int) {
        holder.bind(sweetsList[position])
    }

    class SweetViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView){
        private val brand: TextView = itemView.findViewById(R.id.brand)
        private val code: TextView = itemView.findViewById(R.id.code)

        fun bind(item: Sweet){
            brand.text = "Брэнд: ${item.brand}"
            code.text = "Штрихкод: ${item.code}"
        }
    }
}