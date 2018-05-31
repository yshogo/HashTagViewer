package com.example.shogoyamada.hashtagviewer.Setting

import org.json.JSONObject

data class ImageFeedModel(val page: Int, val pages: Int, val perpage: Int, val total: String,
                          val list: ArrayList<ImageFeedModel.PhotoModel>) {

    data class PhotoModel(val id: String, val owner: String, val secret: String,
                          val server: Int, val farm: Int, val title: String,
                          val isPublic: Int,
                          val isFriend: Int, val isFamily: Int) {

        fun createUrl(): String {
            return "http://farm$farm.staticflickr.com/$server/$id" + "_" + secret + ".jpg"
        }
    }

    companion object {
        fun createPhotoModelList(json: String): ImageFeedModel {
            val jsonRoot = JSONObject(json)
            val jsonObject = jsonRoot.getJSONObject("photos")
            return ImageFeedModel(
                    jsonObject.getInt("page"),
                    jsonObject.getInt("pages"),
                    jsonObject.getInt("perpage"),
                    jsonObject.getString("total"),
                    createPhotoModelList(jsonObject)
                    )

        }

        private fun createPhotoModelList(json: JSONObject): ArrayList<PhotoModel> {
            val jsonArray = json.getJSONArray("photo")
            val list = ArrayList<PhotoModel>()
            for (i in 0..(jsonArray.length() - 1)) {
                val obj = jsonArray.getJSONObject(i)
                val model = ImageFeedModel.PhotoModel(
                        obj.getString("id"),
                        obj.getString("owner"),
                        obj.getString("secret"),
                        obj.getInt("server"),
                        obj.getInt("farm"),
                        obj.getString("title"),
                        obj.getInt("ispublic"),
                        obj.getInt("isfriend"),
                        obj.getInt("isfamily")
                )

                list.add(model)
            }

            return list
        }
    }
}