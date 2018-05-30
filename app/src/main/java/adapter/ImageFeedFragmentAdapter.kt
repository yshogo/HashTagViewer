package adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.shogoyamada.hashtagviewer.ImageFeed.ImageFeedFragment

class ImageFeedFragmentAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm){

    override fun getItem(position: Int): Fragment {
        return ImageFeedFragment.newInstance(position)
    }

    override fun getCount(): Int {
        return 10
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return "Tab $position"
    }
}