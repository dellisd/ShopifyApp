package io.github.dellisd.shopifyapp.ui.collections

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.github.dellisd.shopifyapp.R
import io.github.dellisd.shopifyapp.data.api.models.Collection
import kotlinx.android.synthetic.main.item_collection.view.*

class CollectionsAdapter : ListAdapter<Collection, CollectionsAdapter.ViewHolder>(Collection.DIFF_CALLBACK) {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Collection) {
            itemView.titleView.text = item.title
            itemView.subtextView.text = item.bodyHtml
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_collection, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}