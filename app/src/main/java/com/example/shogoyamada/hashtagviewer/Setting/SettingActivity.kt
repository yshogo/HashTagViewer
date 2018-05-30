package com.example.shogoyamada.hashtagviewer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.shogoyamada.hashtagviewer.Setting.SettingFragment

class SettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fragmentManager.beginTransaction().replace(android.R.id.content, SettingFragment()).commitAllowingStateLoss()
    }
}
