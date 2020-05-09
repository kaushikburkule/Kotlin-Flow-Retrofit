package com.androgynousis.messenger.view.fragment

import android.os.Bundle
import android.view.*
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androgynousis.messenger.R
import com.androgynousis.messenger.model.ContactModel
import com.androgynousis.messenger.view.adapter.ContactAdapter
import java.util.*

class FragmentContacts : Fragment(), ContactAdapter.ViewHolder.ClickListener {

    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: ContactAdapter? = null

    override fun onCreate(a: Bundle?) {
        super.onCreate(a)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_contacts, null, false)
        activity!!.supportInvalidateOptionsMenu()
        //(activity as MainActivity?)!!.changeTitle(R.id.toolbar, "Contacts")
        mRecyclerView = view.findViewById<View>(R.id.recyclerView) as RecyclerView
        mRecyclerView!!.setHasFixedSize(true)
        mRecyclerView!!.layoutManager = LinearLayoutManager(context)
        mAdapter = ContactAdapter(context, setData(), this)
        mRecyclerView!!.adapter = mAdapter
        return view
    }

    private fun setData(): List<ContactModel> {
        val data: MutableList<ContactModel> = ArrayList()
        val name = arrayOf("Laura Owens", "Angela Price", "Donald Turner", "Kelly", "Julia Harris", "Laura Owens", "Angela Price", "Donald Turner", "Kelly", "Julia Harris")
        @DrawableRes val img = intArrayOf(R.drawable.userpic, R.drawable.user1, R.drawable.user2, R.drawable.user3, R.drawable.user4, R.drawable.userpic, R.drawable.user1, R.drawable.user2, R.drawable.user3, R.drawable.user4)
        for (i in 0..9) {
            val contact = ContactModel()
            contact.name = name[i]
            contact.image = img[i]
            data.add(contact)
        }
        return data
    }

    override fun onItemClicked(position: Int) {}
    override fun onItemLongClicked(position: Int): Boolean {
        toggleSelection(position)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return false
    }

    private fun toggleSelection(position: Int) = mAdapter!!.toggleSelection(position)

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.menu_add, menu)
    }

}