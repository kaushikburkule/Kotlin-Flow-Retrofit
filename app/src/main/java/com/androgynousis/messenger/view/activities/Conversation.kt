package com.androgynousis.messenger.view.activities

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androgynousis.messenger.R
import com.androgynousis.messenger.model.ChatData
import com.androgynousis.messenger.view.adapter.ConversationRecyclerView
import java.util.*

class Conversation : BaseActivity() {

    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: ConversationRecyclerView? = null
    private var text: EditText? = null
    private var send: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversation)
        setupToolbarWithUpNav(R.id.toolbar, "Julia Harriss", R.drawable.ic_action_back)
        mRecyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView
        mRecyclerView!!.setHasFixedSize(true)
        mRecyclerView!!.layoutManager = LinearLayoutManager(this)
        mAdapter = ConversationRecyclerView(this, setData() as MutableList<ChatData>)
        mRecyclerView!!.adapter = mAdapter
        mRecyclerView!!.postDelayed({ mRecyclerView!!.smoothScrollToPosition(mRecyclerView!!.adapter!!.itemCount - 1) }, 1000)
        text = findViewById<View>(R.id.et_message) as EditText
        text!!.setOnClickListener { mRecyclerView!!.postDelayed({ mRecyclerView!!.smoothScrollToPosition(mRecyclerView!!.adapter!!.itemCount - 1) }, 500) }
        send = findViewById<View>(R.id.bt_send) as Button
        send!!.setOnClickListener {
            if (text!!.text.toString() != "") {
                val data: MutableList<ChatData?> = ArrayList()
                val item = ChatData()
                item.time = "6:00pm"
                item.type = "2"
                item.text = text!!.text.toString()
                data.add(item)
                mAdapter!!.addItem(data)
                mRecyclerView!!.smoothScrollToPosition(mRecyclerView!!.adapter!!.itemCount - 1)
                text!!.setText("")
            }
        }
    }

    private fun setData(): List<ChatData> {
        val data: MutableList<ChatData> = ArrayList()
        val text = arrayOf("15 September", "Hi, Julia! How are you?", "Hi, Joe, looks great! :) ", "I'm fine. Wanna go out somewhere?", "Yes! Coffe maybe?", "Great idea! You can come 9:00 pm? :)))", "Ok!", "Ow my good, this Kit is totally awesome", "Can you provide other kit?", "I don't have much time, :`(")
        val time = arrayOf("", "5:30pm", "5:35pm", "5:36pm", "5:40pm", "5:41pm", "5:42pm", "5:40pm", "5:41pm", "5:42pm")
        val type = arrayOf("0", "2", "1", "1", "2", "1", "2", "2", "2", "1")
        for (i in text.indices) {
            val item = ChatData()
            item.type = type[i]
            item.text = text[i]
            item.time = time[i]
            data.add(item)
        }
        return data
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_userphoto, menu)
        return true
    }

    override fun onPointerCaptureChanged(hasCapture: Boolean) {}
}