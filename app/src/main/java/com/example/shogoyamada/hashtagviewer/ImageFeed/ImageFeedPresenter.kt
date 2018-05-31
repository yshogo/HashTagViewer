package com.example.shogoyamada.hashtagviewer.ImageFeed

import Task.Callback
import Task.GetImageListTask
import android.content.Context
import android.support.annotation.NonNull
import com.example.shogoyamada.hashtagviewer.Setting.ImageFeedModel

class ImageFeedPresenter(context: Context?, @NonNull private val viewContract: ImageFeedContract) {

    fun onResume(){

        val searchWord = viewContract.getSearchKeyWordText()
        if (searchWord == null) {
            throw IllegalStateException("データがからです")
            return
        }

        requestGetPhotoList(searchWord)
    }

    private fun requestGetPhotoList(text: String) {
        // APIを叩く
        val task = GetImageListTask(object : Callback {
            override fun onSuccess(result: ImageFeedModel) {
                val urlList = ArrayList<String>()
                for (photo in result.list) {
                    urlList.add(photo.createUrl())
                }
                viewContract.updateGrid(urlList)
            }

            override fun onError() {
                print("エラーが発生しました")
            }
        })

        task.execute(text)
    }
}