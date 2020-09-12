package com.intern.app.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import androidx.recyclerview.widget.RecyclerView
import com.intern.app.R
import com.intern.app.model.Previous
import com.intern.app.util.ClickListenerString
import kotlinx.android.synthetic.main.items_item.view.*
import kotlinx.android.synthetic.main.previous_item.view.ivPre
import kotlinx.android.synthetic.main.previous_item.view.tvName
import kotlinx.android.synthetic.main.previous_item.view.tvPrice
import kotlinx.android.synthetic.main.previous_item.view.tvQuantity
import java.util.*


/*
Created by Aiman Qaid on 10,سبمتمبر,2020
Contact me at wakka-2@hotmail.com
*/
class ItemsAdapter(
    private var items: ArrayList<Previous>,
    private val clickListenerString: ClickListenerString
) :
    RecyclerView.Adapter<ItemsAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem = LayoutInflater.from(parent.context).inflate(
            R.layout.items_item,
            parent,
            false
        )
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {

        if(position == 0 || (position % 2 != 0 && position != 1)){
            setMargin(context, holder.itemView.cvItem.layoutParams, 48, 8, holder.itemView.cvItem)
        }
        holder.itemView.ivPre.setImageResource(items[position].drawable)
        holder.itemView.tvPrice.text = items[position].price
        holder.itemView.tvName.text = items[position].name
        holder.itemView.tvQuantity.text = items[position].quantity

        holder.itemView.setOnClickListener {
            clickListenerString.onClick(items[position].name, items[position].drawable)
        }

        val colors: MutableList<String>

        colors = ArrayList()

        colors.add("#5E97F6")
        colors.add("#9CCC65")
        colors.add("#FF8A65")
        colors.add("#AED581")
        colors.add("#F6BF26")
        colors.add("#FFA726")
        colors.add("#4DD0E1")
        colors.add("#BA68C8")
        colors.add("#A1887F")

        val r = Random()
        val i1 = r.nextInt(9 - 0) + 0

        holder.itemView.cvItem.setCardBackgroundColor(Color.parseColor(colors.get(i1)))
    }
    private fun setMargin(
        con: Context,
        params: ViewGroup.LayoutParams,
        dp: Int,
        dpOther: Int,
        view: View
    ) {
        val scale = con.resources.displayMetrics.density
        // convert the DP into pixel
        val pixel = (dp * scale + 0.5f).toInt()
        val otherPixel = (dpOther * scale + 0.5f).toInt()
        val s = params as MarginLayoutParams
        s.setMargins(otherPixel, pixel, otherPixel, otherPixel)
        view.layoutParams.height = (244 * scale + 0.5f).toInt()
        view.layoutParams = params
    }

}