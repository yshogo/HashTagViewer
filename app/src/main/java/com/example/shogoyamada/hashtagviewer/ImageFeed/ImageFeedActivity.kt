package com.example.shogoyamada.hashtagviewer.ImageFeed

import adapter.ImageFeedFragmentAdapter
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import com.example.shogoyamada.hashtagviewer.R
import kotlinx.android.synthetic.main.activity_image_feed.*

class ImageFeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_image_feed)

        val viewPagerAdapter = ImageFeedFragmentAdapter(supportFragmentManager)
        view_pager.adapter = viewPagerAdapter
        tab_layout.tabMode = TabLayout.MODE_SCROLLABLE
        tab_layout.setupWithViewPager(view_pager)
    }
}
