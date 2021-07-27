package com.coco.shows.framework.ui.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.coco.shows.R
import com.coco.shows.databinding.ActivityShowsBinding
import com.coco.shows.framework.common.Resource
import com.coco.shows.framework.ui.detail.ShowActivity
import com.coco.shows.framework.ui.list.adapter.ShowsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShowsActivity : AppCompatActivity() {

    private val model by viewModels<ShowsViewModel>()
    private lateinit var binding: ActivityShowsBinding
    private val adapter = ShowsAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter.setListener(model::onItemClick)
        binding.recycler.adapter = adapter

        model.shows.observe(this, {
            when (it.status) {
                Resource.Status.ERROR -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
                Resource.Status.SUCCESS -> {
                    it.data?.let { it1 -> adapter.submitList(it1) }
                }
                else -> {

                }
            }
        })

        model.loading.observe(this, {

        })

        model.navigation.observe(this, {
            startActivity(Intent(this, ShowActivity::class.java).apply {
                putExtra("id", it)
            })
        })
    }
}