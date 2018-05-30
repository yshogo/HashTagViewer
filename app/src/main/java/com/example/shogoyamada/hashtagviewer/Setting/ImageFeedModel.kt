package com.example.shogoyamada.hashtagviewer.Setting

data class ImageFeedModel(val page: Int, val pages: Int, val perpage: Int, val total: String,
                          val list: ArrayList<ImageFeedModel.PhotoModel>) {

    data class PhotoModel(val id: String, val owner: String, val secret: String,
                          val server: Int, val farm: Int, val title: String, val isPublic: Int,
                          val isFriend: Int, val isFamily: Int)

    companion object {
        fun createPhotoModelList(json: String): ImageFeedModel {

        }
    }
}