package com.androgynousis.messenger.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.androgynousis.messenger.R
import com.androgynousis.messenger.model.Chat

class ChatAdapter(private val mContext: Context?, private val mArrayList: List<Chat>, private val clickListener: ViewHolder.ClickListener) : SelectableAdapter<ChatAdapter.ViewHolder?>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemLayoutView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_chat, null)
        return ViewHolder(itemLayoutView, clickListener)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        if (isSelected(position)) {
            viewHolder.checked.isChecked = true
            viewHolder.checked.visibility = View.VISIBLE
        }

        else {
            viewHolder.checked.isChecked = false
            viewHolder.checked.visibility = View.GONE
        }

        viewHolder.tvName.text = mArrayList[position].name
        viewHolder.tvTime.text = mArrayList[position].time
        viewHolder.userPhoto.setImageResource(mArrayList[position].image)
        if (mArrayList[position].online) viewHolder.onlineView.visibility = View.VISIBLE
        else viewHolder.onlineView.visibility = View.INVISIBLE
        viewHolder.tvLastChat.text = mArrayList[position].lastChat

    }

    override fun getItemCount(): Int = mArrayList.size

    class ViewHolder(itemLayoutView: View, private val listener: ClickListener?) : RecyclerView.ViewHolder(itemLayoutView), View.OnClickListener, OnLongClickListener {

        var tvName: TextView = itemLayoutView.findViewById<View>(R.id.tv_user_name) as TextView
        var tvTime: TextView = itemLayoutView.findViewById<View>(R.id.tv_time) as TextView
        var tvLastChat: TextView = itemLayoutView.findViewById<View>(R.id.tv_last_chat) as TextView
        var userPhoto: ImageView = itemLayoutView.findViewById<View>(R.id.iv_user_photo) as ImageView
        val onlineView: View = itemLayoutView.findViewById(R.id.online_indicator) as View
        var checked: CheckBox = itemLayoutView.findViewById<View>(R.id.chk_list) as CheckBox

        override fun onClick(v: View) { listener?.onItemClicked(adapterPosition) }
        override fun onLongClick(view: View): Boolean = listener?.onItemLongClicked(adapterPosition) ?: false

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