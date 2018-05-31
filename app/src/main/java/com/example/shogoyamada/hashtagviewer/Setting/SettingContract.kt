package com.example.shogoyamada.hashtagviewer.Setting

import dto.SettingDataDto

interface SettingContract {

    fun getEditText(): String

    fun errorMessage()

    fun moveToImageFeed(dto: SettingDataDto)

    fun addText(text: String)

    fun getSettingDataList(): ArrayList<String>

    fun settingTextList(text: String)
}