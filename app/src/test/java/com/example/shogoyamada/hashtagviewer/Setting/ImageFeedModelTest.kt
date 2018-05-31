package com.example.shogoyamada.hashtagviewer.Setting


import org.junit.Assert
import org.junit.Test


class ImageFeedModelTest {

    @Test
    fun ちゃんとURLが生成できてるかテスト() {

        val photo = ImageFeedModel.PhotoModel(
                "41562004615",
                "142013618@N07",
                "d4acf50321",
                1754,
                2,
                "A fun no bake summer",
                1,
                0,
                0
        )

        val result = "http://farm2.staticflickr.com/1754/41562004615_d4acf50321.jpg"
        Assert.assertEquals(result, photo.createUrl())
    }
}