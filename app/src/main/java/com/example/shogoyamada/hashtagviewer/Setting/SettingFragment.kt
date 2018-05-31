package com.example.shogoyamada.hashtagviewer.Setting

import android.app.AlertDialog
import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.shogoyamada.hashtagviewer.ImageFeed.ImageFeedActivity
import com.example.shogoyamada.hashtagviewer.R
import kotlinx.android.synthetic.main.fragment_setting.*

class SettingFragment: Fragment(), SettingContract {

    private lateinit var presenter: SettingPresenter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = SettingPresenter(activity, this)
        presenter.onCreate()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.addButton).setOnClickListener {
            presenter.addButton(hashTagText.text.toString())
        }

        view.findViewById<View>(R.id.next).setOnClickListener {
            presenter.nextButton()
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun getEditText(): String {
        return hashTagText.text.toString()
    }

    override fun errorMessage() {
        AlertDialog.Builder(activity).setTitle("空はなしでお願いします")
                .setPositiveButton("OK"){ _, _ ->
                }.show()
    }

    override fun moveToImageFeed(text: String) {
        val intent = Intent(activity, ImageFeedActivity::class.java).apply {
            putExtra("text", text)
        }
        startActivity(intent)
    }

    override fun addText(text: String) {
        val textView = TextView(activity).apply {
            setText("#$text")
            textSize = 30.0F
        }
        select_name.addView(textView)
        updateText("")
    }

    private fun updateText(text: String) {
        hashTagText.setText(text)
    }
}
