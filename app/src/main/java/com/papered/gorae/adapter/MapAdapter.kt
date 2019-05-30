package com.papered.gorae.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.papered.gorae.R
import com.papered.gorae.model.MapListModel
import org.jetbrains.anko.find

class MapAdapter(val models: ArrayList<MapListModel>) : RecyclerView.Adapter<MapAdapter.MapViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MapViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_map, parent, false)
        return MapViewHolder(view)
    }

    override fun getItemCount(): Int = models.size

    override fun onBindViewHolder(holder: MapViewHolder, position: Int) = holder.bind()


    inner class MapViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val title = view.find<TextView>(R.id.itemMap_title)
        val where = view.find<TextView>(R.id.itemMap_where)
        fun bind() {
            title.text = models[adapterPosition].boothName
            where.text = models[adapterPosition].location
        }

    }
}