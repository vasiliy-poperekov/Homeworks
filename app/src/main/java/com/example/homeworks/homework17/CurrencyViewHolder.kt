package com.example.homeworks.homework17

import androidx.recyclerview.widget.RecyclerView
import com.example.homeworks.databinding.ItemCurrencyBinding
import com.example.homeworks.homework17.data.Currency

class CurrencyViewHolder(
    val binding: ItemCurrencyBinding
) : RecyclerView.ViewHolder(binding.root){
    fun bind(item: Currency){
        binding.tvCurrencyId.text = item.id.toString()
        binding.tvCurrencyName.text = item.name
        binding.tvCurrencySign.text = item.sign
        binding.tvCurrencySymbol.text = item.symbol
    }
}