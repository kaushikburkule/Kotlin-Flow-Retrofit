package com.androgynousis.messenger.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androgynousis.messenger.R
import com.androgynousis.messenger.model.ChatModel
import com.androgynousis.messenger.view.activities.ConversationActivity
import com.androgynousis.messenger.view.adapter.ChatAdapter
import java.util.*

class FragmentHome : Fragment(), ChatAdapter.ViewHolder.ClickListener {

    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: ChatAdapter? = null
    private var tvSelection: TextView? = null

    override fun onCreate(a: Bundle?) {
        super.onCreate(a)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, null, false)
        activity!!.supportInvalidateOptionsMenu()
//        (activity as MainActivity?)!!.changeTitle(R.id.toolbar, "Messages")
        tvSelection = view.findViewById<View>(R.id.tv_selection) as TextView
        mRecyclerView = view.findViewById<View>(R.id.recyclerView) as RecyclerView
        mRecyclerView!!.setHasFixedSize(true)
        mRecyclerView!!.layoutManager = LinearLayoutManager(context)
        mAdapter = ChatAdapter(context, setData(), this)
        mRecyclerView!!.adapter = mAdapter
        return view
    }

    private fun setData(): List<ChatModel> {
        val data: MutableList<ChatModel> = ArrayList()
        val name = arrayOf("Laura Owens", "Angela Price", "Donald Turner", "Kelly", "Julia Harris", "Laura Owens", "Angela Price", "Donald Turner", "Kelly", "Julia Harris")
        val latch = arrayOf("Hi Laura Owens", "Hi there how are you", "Can we meet?", "Ow this awesome", "How are you?", "Ow this awesome", "How are you?", "Ow this awesome", "How are you?", "How are you?")
        @DrawableRes val img = intArrayOf(R.drawable.userpic, R.drawable.user1, R.drawable.user2, R.drawable.user3, R.drawable.user4, R.drawable.userpic, R.drawable.user1, R.drawable.user2, R.drawable.user3, R.drawable.user4)
        val online = booleanArrayOf(true, false, true, false, true, true, true, false, false, true)
        for (i in 0..9) {
            val chat = ChatModel()
            //chat.setmTime("5:04pm");
            chat.name = name[i]
            chat.image = img[i]
            //chat.online = online[i];
            chat.lastChat = latch[i]
            data.add(chat)
        }
        return data
    }

    override fun onItemLongClicked(position: Int): Boolean {
        toggleSelection(position)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return false
    }

    private fun toggleSelection(position: Int) {
        mAdapter!!.toggleSelection(position)
        if (mAdapter!!.selectedItemCount > 0) {
            tvSelection!!.visibility = View.VISIBLE
        } else tvSelection!!.visibility = View.GONE
        activity!!.runOnUiThread { tvSelection!!.text = "Delete (" + mAdapter!!.selectedItemCount + ")" }
    }

    override fun onItemClicked(position: Int) = startActivity(Intent(activity, ConversationActivity::class.java))

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.menu_edit, menu)
    }

}