package Task

import com.example.shogoyamada.hashtagviewer.Setting.ImageFeedModel

interface Callback {
    fun onSuccess(result: ImageFeedModel)

    fun onError()
}