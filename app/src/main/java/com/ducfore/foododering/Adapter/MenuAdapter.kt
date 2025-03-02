package com.ducfore.foododering.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ducfore.foododering.Activity.DetailsActivity
import com.ducfore.foododering.databinding.ActivityDetailsBinding
import com.ducfore.foododering.databinding.MenuSearchItemBinding

class MenuAdapter(
    private val menuItemName:MutableList<String>,
    private val menuItemPrice:MutableList<String>,
    private val menuItemImage:MutableList<Int>,
    private val requireContext:Context
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    private val itemClickListener:OnClickListener ?= null

    inner class MenuViewHolder(private val binding:MenuSearchItemBinding) :  RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if(position != RecyclerView.NO_POSITION){
                    itemClickListener?.onItemClick(position)
                }
                //set onClickListener to open details
                val intent = Intent(requireContext,DetailsActivity::class.java)
                intent.putExtra("MenuItemName",menuItemName.get(position))
                intent.putExtra("MenuItemImage",menuItemImage.get(position))
                requireContext.startActivity(intent)
            }
        }
        fun bind(position: Int){
            binding.foodNameMenu.text = menuItemName[position]
            binding.priceMenu.text = menuItemPrice[position]
            binding.imgFoodMenu.setImageResource(menuItemImage[position])


        }
    }
    // Create 1 ViewHolder
    //Moi ViewHolder chi gọi 1 lần
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuSearchItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MenuViewHolder(binding)
    }
    // Return so luong  in List
    override fun getItemCount(): Int {
        return  menuItemName.size
    }
    // Tai su dung ViewHolder    holder tham chieu toi View Holder, position do tai vi tri
    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }
    interface OnClickListener{
        fun onItemClick(position: Int){

        }
    }

}
