package com.example.shogoyamada.hashtagviewer.Setting

interface SettingContract {

    fun getEditText(): String

    fun errorMessage()

    fun moveToImageFeed(text: String)

    fun addText(text: String)
}