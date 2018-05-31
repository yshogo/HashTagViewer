package com.example.shogoyamada.hashtagviewer.ImageFeed

interface ImageFeedContract {

    fun updateGrid(list: ArrayList<String>)

    fun getSearchKeyWordText(): String?
}