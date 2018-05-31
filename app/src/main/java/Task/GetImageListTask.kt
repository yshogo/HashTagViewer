package Task

import android.os.AsyncTask
import com.example.shogoyamada.hashtagviewer.Setting.ImageFeedModel
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class GetImageListTask(callbackListener: Callback): AsyncTask<String, Void, ImageFeedModel>() {

    private val listner = callbackListener

    override fun doInBackground(vararg params: String?): ImageFeedModel? {

        val searchWord = params[0]
        val client = OkHttpClient()
        val request = Request.Builder()
                .url("https://api.flickr.com/services/rest/" +
                        "?method=flickr.photos.search" +
                        "&api_key=eb269071eb0ae77c9c26198af2598a55" +
                        "&format=rest" +
                        "&format=json" +
                        "&per_page=20" +
                        "&text="
                        + searchWord +
                        "&nojsoncallback=1")
                .get()
                .build()

        var response: Response? = null
        try {
            response = client.newCall(request).execute()
        } catch (e: IOException){
            print("エラーが発生しました")
            return null
        }

        return if (response.isSuccessful) {
            parse(response.body()?.string())
        } else {
            null
        }
    }

    override fun onPostExecute(result: ImageFeedModel?) {
        super.onPostExecute(result)

        if (result != null) {
            listner.onSuccess(result)
        } else {
            listner.onError()
        }
    }

    private fun parse(json: String?): ImageFeedModel? {

        if (json == null) {
            return null
        }

        return ImageFeedModel.createPhotoModel(json)
    }
}