package com.example.mvpfood.main

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvpfood.R
import com.example.mvpfood.model.DataItem
import com.example.mvpfood.updatedelete.UpdateDeleteActivity
import kotlinx.android.synthetic.main.item_row_food.view.*
import java.text.NumberFormat
import java.util.*

class FoodAdapter(val dataFood: List<DataItem?>?, val context: Context) :
    RecyclerView.Adapter<FoodAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.item_image
        val nameFood = view.item_tv_name_food
        val price = view.item_tv_price
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_row_food, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.price.text = dataFood?.get(position)?.menuHarga
        holder.price.text = NumberFormat.getCurrencyInstance(Locale("in", "ID")).format(Integer.valueOf(dataFood?.get(position)?.menuHarga))
        holder.nameFood.text = dataFood?.get(position)?.menuNama
        Glide.with(context)
            .load(dataFood?.get(position)?.menuGambar)
            .error(R.drawable.ic_launcher_background)
            .into(holder.image)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, UpdateDeleteActivity::class.java)
            intent.putExtra("Data", dataFood?.get(position))
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        if (dataFood != null) {
            return dataFood.size
        }
        return 0
    }

}