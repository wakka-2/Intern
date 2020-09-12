package com.intern.app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.intern.app.R
import com.intern.app.model.Category
import com.intern.app.util.ClickListenerString
import kotlinx.android.synthetic.main.category_item.view.*
import java.util.*


/*
Created by Aiman Qaid on 10,سبمتمبر,2020
Contact me at wakka-2@hotmail.com
*/
class CategoriesAdapter(
    private var items: ArrayList<Category>,
    private val clickListenerString: ClickListenerString
) :
    RecyclerView.Adapter<CategoriesAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem = LayoutInflater.from(parent.context).inflate(
            R.layout.category_item,
            parent,
            false
        )
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {

        holder.itemView.ivCat.setImageResource(items[position].drawable)
        holder.itemView.tvCat.text = items[position].name

        holder.itemView.setOnClickListener {
            clickListenerString.onClick(items[position].name,items[position].drawable)
        }
    }

}