package adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.shogoyamada.hashtagviewer.ImageFeed.ImageFeedActivity
import com.example.shogoyamada.hashtagviewer.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.image_feed_cell.view.*

class ImageFeedGridViewAdapter(private val activity: ImageFeedActivity, private val list: List<String>): RecyclerView.Adapter<ImageFeedGridViewAdapter.ViewHolder>() {

    private val inflater = LayoutInflater.from(activity)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.image_feed_cell, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = list[position]
        Picasso.get().load(item).fit().centerCrop().into(holder.imageView)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val imageView: ImageView = view.image_view
    }
}