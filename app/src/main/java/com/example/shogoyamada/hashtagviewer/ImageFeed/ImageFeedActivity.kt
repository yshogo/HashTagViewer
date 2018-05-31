package com.example.shogoyamada.hashtagviewer.ImageFeed

import adapter.ImageFeedFragmentAdapter
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import com.example.shogoyamada.hashtagviewer.R
import dto.SettingDataDto
import kotlinx.android.synthetic.main.activity_image_feed.*

class ImageFeedActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context, dto: SettingDataDto): Intent {
            return Intent(context, ImageFeedActivity::class.java).apply {
                putExtra("textList", dto)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_feed)

        val dto = intent.getSerializableExtra("textList") as SettingDataDto
        val viewPagerAdapter = ImageFeedFragmentAdapter(supportFragmentManager, dto.list)
        view_pager.adapter = viewPagerAdapter
        tab_layout.tabMode = TabLayout.MODE_SCROLLABLE
        tab_layout.tabGravity = TabLayout.GRAVITY_CENTER
        tab_layout.setupWithViewPager(view_pager)
    }
}
