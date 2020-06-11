package com.androgynousis.messenger.view.holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.androgynousis.messenger.R

class HolderYou(v: View) : RecyclerView.ViewHolder(v) {
    var time: TextView = v.findViewById<View>(R.id.tv_time) as TextView
    var chatText: TextView = v.findViewById<View>(R.id.tv_chat_text) as TextView
}