package com.androgynousis.messenger.model

import androidx.annotation.DrawableRes
import com.androgynousis.messenger.R
import java.util.ArrayList

class ChatModel {

    var name: String? = null
    var lastChat: String? = null
    var time: String? = null
    var image = 0
    var online = false

    fun setData(): List<ChatModel> {
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

}