package com.example.simple_crypto_currency_converter.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.simple_crypto_currency_converter.R
import com.example.simple_crypto_currency_converter.databinding.CryptoItemBinding
import com.example.simple_crypto_currency_converter.json.CryptoItem
import java.math.RoundingMode
import java.text.DecimalFormat

class CryptoAdapter : ListAdapter<CryptoItem, CryptoAdapter.Holder>(Comparator()) {

    // ViewHolder pattern to hold the item views and bind data to them
    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = CryptoItemBinding.bind(view)

        @SuppressLint("SetTextI18n")
        fun bind(cryptoItem: CryptoItem) = with(binding) {
            val df = DecimalFormat("#.######")
            df.roundingMode = RoundingMode.CEILING

            itemName.text = cryptoItem.name
            itemBuy.text = ((df.format(cryptoItem.current_price)).toString() + ("$"))

            // Use Glide to load the cryptoItem's image into CryptoIcon ImageView
            Glide.with(itemView.context)
                .load(cryptoItem.image)
                .placeholder(R.drawable.crypto_standart)
                .into(CryptoIcon)
        }
    }

    // DiffUtil.ItemCallback for efficient list updates
    class Comparator : DiffUtil.ItemCallback<CryptoItem>() {
        override fun areItemsTheSame(oldItem: CryptoItem, newItem: CryptoItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CryptoItem, newItem: CryptoItem): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        // Inflate the list_item layout and create a ViewHolder for it
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.crypto_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        // Bind data to the ViewHolder's views
        holder.bind(getItem(position))
    }
}