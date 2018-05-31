package com.example.shogoyamada.hashtagviewer.Setting

import android.app.AlertDialog
import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.shogoyamada.hashtagviewer.ImageFeed.ImageFeedActivity
import com.example.shogoyamada.hashtagviewer.R
import dto.SettingDataDto
import kotlinx.android.synthetic.main.fragment_setting.*

class SettingFragment: Fragment(), SettingContract {

    private lateinit var presenter: SettingPresenter
    private val list = ArrayList<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = SettingPresenter(this)
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

    override fun getEditText(): String {
        return hashTagText.text.toString()
    }

    override fun errorMessage() {
        AlertDialog.Builder(activity).setTitle("空はなしでお願いします")
                .setPositiveButton("OK"){ _, _ ->
                }.show()
    }

    override fun moveToImageFeed(dto: SettingDataDto) {
        startActivity(ImageFeedActivity.createIntent(activity, dto))
    }

    override fun addText(text: String) {
        val textView = TextView(activity).apply {
            setText("#$text")
            textSize = 30.0F
        }
        select_name.addView(textView)
        updateText("")
    }

    override fun getSettingDataList(): ArrayList<String> {
        return list
    }

    override fun settingTextList(text: String) {
        list.add(text)
    }

    private fun updateText(text: String) {
        hashTagText.setText(text)
    }
}
