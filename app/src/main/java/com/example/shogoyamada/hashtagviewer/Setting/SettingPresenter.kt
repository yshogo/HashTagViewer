package com.example.shogoyamada.hashtagviewer.Setting

import android.app.Activity
import android.support.annotation.NonNull

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
        val text = viewContract.getEditText()

        if (text == ""){
            viewContract.errorMessage()
            return
        }

        viewContract.moveToImageFeed(text)
    }

    /**
     * 追加ボタンを押した時
     */
    fun addButton(text: String) {

        if (text == "") {
            viewContract.errorMessage()
        } else {
            viewContract.addText(text)
        }
    }
}