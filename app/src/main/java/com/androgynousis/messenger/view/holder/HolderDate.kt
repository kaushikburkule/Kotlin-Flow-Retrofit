package com.androgynousis.messenger.view.holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.androgynousis.messenger.R

class HolderDate(v: View) : RecyclerView.ViewHolder(v) {
    var date: TextView = v.findViewById<View>(R.id.tv_date) as TextView
}