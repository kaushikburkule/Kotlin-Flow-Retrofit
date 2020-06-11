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
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        val itemLayoutView = LayoutInflater.from(parent.context).inflate(
                R.layout.list_item_chat, null)
        return ViewHolder(itemLayoutView, clickListener)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.tvName.text = mArrayList[position].name
        if (isSelected(position)) {
            viewHolder.checked.isChecked = true
            viewHolder.checked.visibility = View.VISIBLE
        } else {
            viewHolder.checked.isChecked = false
            viewHolder.checked.visibility = View.GONE
        }
        viewHolder.tvTime.text = mArrayList[position].time
        viewHolder.userPhoto.setImageResource(mArrayList[position].image)
        if (mArrayList[position].online) {
            viewHolder.onlineView.visibility = View.VISIBLE
        } else viewHolder.onlineView.visibility = View.INVISIBLE
        viewHolder.tvLastChat.text = mArrayList[position].lastChat
    }

    override fun getItemCount(): Int {
        return mArrayList.size
    }

    class ViewHolder(itemLayoutView: View, private val listener: ClickListener?) : RecyclerView.ViewHolder(itemLayoutView), View.OnClickListener, OnLongClickListener {
        var tvName: TextView
        var tvTime: TextView
        var tvLastChat: TextView
        var userPhoto: ImageView
        var online = false
        val onlineView: View
        var checked: CheckBox
        override fun onClick(v: View) {
            listener?.onItemClicked(adapterPosition)
        }

        override fun onLongClick(view: View): Boolean {
            return listener?.onItemLongClicked(adapterPosition) ?: false
        }

        interface ClickListener {
            fun onItemClicked(position: Int)
            fun onItemLongClicked(position: Int): Boolean
            fun onCreateOptionsMenu(menu: Menu?): Boolean
        }

        init {
            tvName = itemLayoutView.findViewById<View>(R.id.tv_user_name) as TextView
            //selectedOverlay = (View) itemView.findViewById(R.id.selected_overlay);
            tvTime = itemLayoutView.findViewById<View>(R.id.tv_time) as TextView
            tvLastChat = itemLayoutView.findViewById<View>(R.id.tv_last_chat) as TextView
            userPhoto = itemLayoutView.findViewById<View>(R.id.iv_user_photo) as ImageView
            onlineView = itemLayoutView.findViewById(R.id.online_indicator) as View
            checked = itemLayoutView.findViewById<View>(R.id.chk_list) as CheckBox
            itemLayoutView.setOnClickListener(this)
            itemLayoutView.setOnLongClickListener(this)
        }
    }

}