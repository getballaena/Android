package com.papered.gorae.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.papered.gorae.R
import com.papered.gorae.databinding.ItemStampBinding
import com.papered.gorae.model.StampModel
import com.papered.gorae.ui.main.stamp.StampViewModel
import org.jetbrains.anko.backgroundResource

class StampAdapter(val viewModel: StampViewModel) :
    androidx.recyclerview.widget.RecyclerView.Adapter<StampAdapter.StampViewHolder>() {

    var item = arrayListOf<StampModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StampViewHolder {
        val binding = ItemStampBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StampViewHolder(binding)
    }

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: StampViewHolder, position: Int) {
        holder.bind()
    }


    inner class StampViewHolder(val binding: ItemStampBinding) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.stampModel = item[adapterPosition]
            binding.index = adapterPosition
            binding.vm = viewModel
            if (item[adapterPosition].isCaptured == true) {
                itemView.backgroundResource = R.drawable.back_stamp_true
            }
        }
    }
}