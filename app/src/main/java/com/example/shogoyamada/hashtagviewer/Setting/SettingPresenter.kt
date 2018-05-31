package com.example.shogoyamada.hashtagviewer.Setting

import android.app.Activity
import android.support.annotation.NonNull
import dto.SettingDataDto

class SettingPresenter(@NonNull activity: Activity, @NonNull private val viewContract: SettingContract) {

    fun onCreate(){

    }

    fun onResume(){

    }

    fun onDestroy(){

    }

    /**
     * 次へボタンを押した時
     */
    fun nextButton(){
        val list = viewContract.getSettingDataList()

        if (list.size == 0){
            viewContract.errorMessage()
            return
        }

        viewContract.moveToImageFeed(convertDto(list))
    }

    /**
     * 追加ボタンを押した時
     */
    fun addButton(text: String) {

        viewContract.settingTextList(text)
        if (text == "") {
            viewContract.errorMessage()
        } else {
            viewContract.addText(text)
        }
    }

    private fun convertDto(list: ArrayList<String>): SettingDataDto {
        return SettingDataDto(list)
    }
}