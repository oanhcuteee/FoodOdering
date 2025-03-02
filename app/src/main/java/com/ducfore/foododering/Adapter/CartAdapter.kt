package com.ducfore.foododering.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ducfore.foododering.databinding.CartItemBinding

class CartAdapter(
    private val cartItem: MutableList<String>,
    private val cartItemPrice: MutableList<String>,
    private val cartItemImage: MutableList<Int>
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private val itemQuantities = IntArray(cartItem.size)
    //Tao 1 ViewHolder
    //Moi 1 ViewHolder chi dc goi 1 lan
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }
    // Tai su dung lai ViewHolder da tao
    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }
    // Return ve position co trong List
    override fun getItemCount(): Int = cartItem.size


    inner class CartViewHolder(private val binding: CartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(position: Int) {
            binding.apply {
                foodNameCart.text = cartItem[position]
                priceFoodCart.text = cartItemPrice[position]
                imgFoodCart.setImageResource(cartItemImage[position])
                val quantity = itemQuantities[position]
                cartItemQuantity.text = quantity.toString()

                minusBtn.setOnClickListener {
                    deceaseQuantity(position)

                }
                plusBtn.setOnClickListener {
                    increaseQuantity(position)

                }
                deleteBtn.setOnClickListener {
                    val itemPosition = adapterPosition
                    if (itemPosition != RecyclerView.NO_POSITION) {
                        deleteItem(itemPosition)
                    }
                }
            }
        }

        @SuppressLint("SetTextI18n")
        private fun deceaseQuantity(position: Int) {
            if (itemQuantities[position] > 1) {
                itemQuantities[position]--
                binding.cartItemQuantity.text = itemQuantities[position].toString()
            }
        }

        @SuppressLint("SetTextI18n")
        private fun increaseQuantity(position: Int) {
            if (itemQuantities[position] < 15) {
                itemQuantities[position]++
                binding.cartItemQuantity.text = itemQuantities[position].toString()
            }
        }

        private fun deleteItem(position: Int) {
            cartItem.removeAt(position)
            cartItemPrice.removeAt(position)
            cartItemImage.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, cartItem.size)

        }


    }
}