package com.androgynousis.messenger.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.androgynousis.messenger.R
import com.androgynousis.messenger.adapter.ApiUserAdapter
import com.androgynousis.messenger.api.ApiHelperImpl
import com.androgynousis.messenger.api.RetrofitBuilder
import com.androgynousis.messenger.database.DatabaseBuilder
import com.androgynousis.messenger.database.DatabaseHelperImpl
import com.androgynousis.messenger.model.ApiUser
import com.androgynousis.messenger.utils.Status
import com.androgynousis.messenger.viewmodel.SplashViewModel
import com.androgynousis.messenger.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    lateinit var viewModel: SplashViewModel
    private lateinit var adapter: ApiUserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        viewModel = ViewModelProviders.of(this, ViewModelFactory(ApiHelperImpl(RetrofitBuilder.apiService), DatabaseHelperImpl(DatabaseBuilder.getInstance(this)))).get(SplashViewModel::class.java)

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter =
                ApiUserAdapter(
                        arrayListOf()
                )
        recyclerView.addItemDecoration(
                DividerItemDecoration(
                        recyclerView.context,
                        (recyclerView.layoutManager as LinearLayoutManager).orientation
                )
        )
        recyclerView.adapter = adapter

        viewModel.getUsers().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    it.data?.let { users -> renderList(users) }
                    recyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })

    }

    fun renderList(users: List<ApiUser>) {
        adapter.addData(users)
        adapter.notifyDataSetChanged()
    }

}