package io.github.dellisd.shopifyapp.ui.collections

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import io.github.dellisd.shopifyapp.R
import io.github.dellisd.shopifyapp.data.api.models.Collection
import io.github.dellisd.shopifyapp.ui.products.ProductsActivity
import kotlinx.android.synthetic.main.item_collection.view.*

class CollectionsAdapter : ListAdapter<Collection, CollectionsAdapter.ViewHolder>(Collection.DIFF_CALLBACK) {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, ProductsActivity::class.java)
                intent.putExtra(ProductsActivity.COLLECTION_ID_KEY, getItem(adapterPosition).id)
                intent.putExtra(ProductsActivity.COLLECTION_TITLE_KEY, getItem(adapterPosition).title)
                intent.putExtra(ProductsActivity.COLLECTION_DESCRIPTION_KEY, getItem(adapterPosition).bodyHtml)
                intent.putExtra(ProductsActivity.COLLECTION_IMAGE_SRC_KEY, getItem(adapterPosition).image.src)

                itemView.context.startActivity(intent)
            }
        }

        fun bind(item: Collection) {
            itemView.titleText.text = item.title
            itemView.captionText.text = item.bodyHtml

            Picasso.get().load(item.image.src).into(itemView.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_collection, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}