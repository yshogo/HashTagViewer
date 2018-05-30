package com.example.shogoyamada.hashtagviewer.ImageFeed

import adapter.ImageFeedGridViewAdapter
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shogoyamada.hashtagviewer.R
import kotlinx.android.synthetic.main.fragment_image_feed.view.*

class ImageFeedFragment : Fragment() {

    companion object {
        private var position = 0

        fun newInstance(position: Int): Fragment {
            this.position = position
            return ImageFeedFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_image_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sampleImageList = createSampleList()
        val activity = activity as ImageFeedActivity
        val adapter = ImageFeedGridViewAdapter(activity, sampleImageList)
        adapter.notifyDataSetChanged()
        view.image_feed.layoutManager = GridLayoutManager(activity, 4)
        view.image_feed.adapter = adapter
    }

    private fun createSampleList(): ArrayList<String> {

        val list = ArrayList<String>()

        list.add("https://firebasestorage.googleapis.com/v0/b/onecam-ce3d7.appspot.com/o/group_item%2F12ie1WFq2KvslwLxFXur?alt=media&token=4b547ab9-7100-4ee9-9733-f29e738ec8f1")
        list.add("https://firebasestorage.googleapis.com/v0/b/onecam-ce3d7.appspot.com/o/group_item%2F12ie1WFq2KvslwLxFXur?alt=media&token=4b547ab9-7100-4ee9-9733-f29e738ec8f1")
        list.add("https://firebasestorage.googleapis.com/v0/b/onecam-ce3d7.appspot.com/o/group_item%2F12ie1WFq2KvslwLxFXur?alt=media&token=4b547ab9-7100-4ee9-9733-f29e738ec8f1")
        list.add("https://firebasestorage.googleapis.com/v0/b/onecam-ce3d7.appspot.com/o/group_item%2F12ie1WFq2KvslwLxFXur?alt=media&token=4b547ab9-7100-4ee9-9733-f29e738ec8f1")
        list.add("https://firebasestorage.googleapis.com/v0/b/onecam-ce3d7.appspot.com/o/group_item%2F12ie1WFq2KvslwLxFXur?alt=media&token=4b547ab9-7100-4ee9-9733-f29e738ec8f1")
        list.add("https://firebasestorage.googleapis.com/v0/b/onecam-ce3d7.appspot.com/o/group_item%2F12ie1WFq2KvslwLxFXur?alt=media&token=4b547ab9-7100-4ee9-9733-f29e738ec8f1")
        list.add("https://firebasestorage.googleapis.com/v0/b/onecam-ce3d7.appspot.com/o/group_item%2F12ie1WFq2KvslwLxFXur?alt=media&token=4b547ab9-7100-4ee9-9733-f29e738ec8f1")
        list.add("https://firebasestorage.googleapis.com/v0/b/onecam-ce3d7.appspot.com/o/group_item%2F12ie1WFq2KvslwLxFXur?alt=media&token=4b547ab9-7100-4ee9-9733-f29e738ec8f1")
        list.add("https://firebasestorage.googleapis.com/v0/b/onecam-ce3d7.appspot.com/o/group_item%2F12ie1WFq2KvslwLxFXur?alt=media&token=4b547ab9-7100-4ee9-9733-f29e738ec8f1")
        list.add("https://firebasestorage.googleapis.com/v0/b/onecam-ce3d7.appspot.com/o/group_item%2F12ie1WFq2KvslwLxFXur?alt=media&token=4b547ab9-7100-4ee9-9733-f29e738ec8f1")

        return list
    }
}
