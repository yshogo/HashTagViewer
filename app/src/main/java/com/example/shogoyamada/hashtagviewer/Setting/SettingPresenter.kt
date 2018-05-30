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
     * 追加ボタンを押した時
     */
    fun addButton(){
        val text = viewContract.getEditText()
        print(text)
    }
}