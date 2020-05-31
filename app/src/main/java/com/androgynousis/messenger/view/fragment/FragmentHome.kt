package com.androgynousis.messenger.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.androgynousis.messenger.R
import com.androgynousis.messenger.model.ChatModel
import com.androgynousis.messenger.view.adapter.ChatAdapter
import kotlinx.android.synthetic.main.fragment_home.view.*

class FragmentHome : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, null, false)
        view.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = ChatAdapter(context, ChatModel().setData())
        }

        return view
    }

}