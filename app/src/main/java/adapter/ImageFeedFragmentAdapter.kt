package adapter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.shogoyamada.hashtagviewer.ImageFeed.ImageFeedFragment

class ImageFeedFragmentAdapter(fm: FragmentManager, private val textList: ArrayList<String>) : FragmentPagerAdapter(fm){

    override fun getItem(position: Int): Fragment {
        return ImageFeedFragment().apply {
            val bundle = Bundle()
            bundle.putString("searchWord", textList[position])
            arguments = bundle
        }
    }

    override fun getCount(): Int {
        return textList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return "#${textList.get(index = position)}"
    }
}