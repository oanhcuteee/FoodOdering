package com.ducfore.foododering.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ducfore.foododering.Activity.DetailsActivity
import com.ducfore.foododering.databinding.PopularItemBinding

class PopularAdapter(
    private val items: List<String>,
    private val images: List<Int>,
    private val prices: List<String>,
    private val requireContext: Context
) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    class PopularViewHolder(private val bindind: PopularItemBinding) :
        RecyclerView.ViewHolder(bindind.root) {
        private val imageView = bindind.imgFoodPopular
        fun bind(item: String, image: Int, price: String) {
            bindind.foodNamePopular.text = item
            bindind.pricePopular.text = price
            imageView.setImageResource(image)
        }

    }

    // Tao 1 viewholder, moi 1 viewholder chi dc goi 1 lan
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(
            PopularItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    // Return ve so luog trong list
    override fun getItemCount(): Int {
        return items.size
    }

    // Tai su dung lai viewholder da tao
    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item = items[position]
        val image = images[position]
        val price = prices[position]
        holder.bind(item, image, price)
        holder.itemView.setOnClickListener {
            val intent = Intent(requireContext, DetailsActivity::class.java)
            intent.putExtra("MenuItemName",item)
            intent.putExtra("MenuItemImage",image)
            requireContext.startActivity(intent)
        }
    }

}