package com.yoesuv.myespresso.menu.list.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.yoesuv.myespresso.R
import com.yoesuv.myespresso.databinding.ItemListBinding
import com.yoesuv.myespresso.menu.list.models.PlaceModel
import com.yoesuv.myespresso.menu.list.viewmodels.ItemListViewModel
import java.lang.ref.WeakReference

class MyListAdapter(private val myList: MutableList<PlaceModel>): RecyclerView.Adapter<MyListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemListBinding = DataBindingUtil.inflate(inflater, R.layout.item_list, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindView(myList[holder.adapterPosition])
    }

    class MyViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(placeModel: PlaceModel){
            val viewModel = ItemListViewModel(placeModel, WeakReference(binding.root.context))
            binding.itemList = viewModel
        }

    }
}