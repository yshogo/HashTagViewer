package com.example.shogoyamada.hashtagviewer.ImageFeed

import Task.Callback
import Task.GetImageListTask
import android.content.Context
import android.support.annotation.NonNull
import com.example.shogoyamada.hashtagviewer.Setting.ImageFeedModel

class ImageFeedPresenter(context: Context?, @NonNull private val viewContract: ImageFeedContract) {

    fun onResume(){
        // APIを叩く
        val task = GetImageListTask(object : Callback {
            override fun onSuccess(result: ImageFeedModel) {
                print(result)
            }

            override fun onError() {
                print("エラーが発生しました")
            }
        })
        task.execute()
    }
}