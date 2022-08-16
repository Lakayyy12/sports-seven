package com.application.sportsodds

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(
    val onItemClicked: OnContentCLickListener
        ): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

//            title & descriptions

    private var titles = arrayOf("SPORTS BET GUIDE","SPORTS BET GUIDE","SPORTS BET GUIDE","SPORTS BET GUIDE","SPORTS BET GUIDE","SPORTS BET GUIDE",
    "SPORTS BET GUIDE","SPORTS BET GUIDE","SPORTS BET GUIDE","SPORTS BET GUIDE")

    private var details = arrayOf("BASKETBALL","SOCCER","BASEBALL","AMERICAN FOOTBALL","BOXING","MMA/UFC","Motor Racing","Tennis","Horse Racing","GOLF")

    private var contents = intArrayOf(R.string.g1,R.string.g2,R.string.g3,R.string.g4,R.string.g5,R.string.g6
        ,R.string.g7,R.string.g8,R.string.g9,R.string.g10)

    private var images = intArrayOf(R.drawable.navbar,R.drawable.navbar,R.drawable.navbar,R.drawable.navbar,R.drawable.navbar,R.drawable.navbar,
        R.drawable.navbar,R.drawable.navbar,R.drawable.navbar,R.drawable.navbar)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemDetail.text = details[position]
        holder.itemImage.setImageResource(images[position])

        holder.itemView.setOnClickListener {
            onItemClicked.OnContentItemClicked(images[position], contents[position])
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView = itemView.findViewById(R.id.item_image)
        var itemTitle: TextView = itemView.findViewById(R.id.item_title)
        var itemDetail: TextView = itemView.findViewById(R.id.item_detail)
    }
}
































