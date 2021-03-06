package com.example.shogoyamada.hashtagviewer.ImageFeed

import adapter.ImageFeedGridViewAdapter
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shogoyamada.hashtagviewer.R
import kotlinx.android.synthetic.main.fragment_image_feed.view.*

class ImageFeedFragment : Fragment(), ImageFeedContract {

    private lateinit var presenter: ImageFeedPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = ImageFeedPresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_image_feed, container, false)
    }

    override fun onResume() {
        super.onResume()

        presenter.onResume()
    }

    override fun updateGrid(list: ArrayList<String>) {
        renderImageGrid(list)
    }

    private fun renderImageGrid(list: ArrayList<String>) {
        val activity = activity as ImageFeedActivity
        val adapter = ImageFeedGridViewAdapter(activity, list)
        adapter.notifyDataSetChanged()
        view?.image_feed?.layoutManager = GridLayoutManager(activity, 4)
        view?.image_feed?.adapter = adapter
    }

    override fun getSearchKeyWordText(): String? {
        val bundle = arguments
        return bundle?.get("searchWord") as String
    }
}
