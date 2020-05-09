package com.androgynousis.messenger.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.androgynousis.messenger.R
import com.androgynousis.messenger.model.Contact

class ContactAdapter(private val mContext: Context?, private val mArrayList: List<Contact>, private val clickListener: ViewHolder.ClickListener) : SelectableAdapter<ContactAdapter.ViewHolder?>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemLayoutView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_contact, null)
        return ViewHolder(itemLayoutView, clickListener)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.tvName.text = mArrayList[position].name
        viewHolder.userPhoto.setImageResource(mArrayList[position].image)
    }

    override fun getItemCount(): Int = mArrayList.size

    class ViewHolder(itemLayoutView: View, private val listener: ClickListener?) : RecyclerView.ViewHolder(itemLayoutView), View.OnClickListener, OnLongClickListener {
        var tvName: TextView = itemLayoutView.findViewById<View>(R.id.tv_user_name) as TextView
        var userPhoto: ImageView = itemLayoutView.findViewById<View>(R.id.iv_user_photo) as ImageView
        override fun onClick(v: View) { listener?.onItemClicked(adapterPosition) }

        override fun onLongClick(view: View): Boolean {
            return listener?.onItemLongClicked(adapterPosition) ?: false
        }

        interface ClickListener {
            fun onItemClicked(position: Int)
            fun onItemLongClicked(position: Int): Boolean
            fun onCreateOptionsMenu(menu: Menu?): Boolean
        }

        init {
            itemLayoutView.setOnClickListener(this)
            itemLayoutView.setOnLongClickListener(this)
        }
    }

}