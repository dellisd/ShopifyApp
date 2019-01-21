package io.github.dellisd.shopifyapp.ui.products

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import io.github.dellisd.shopifyapp.R
import io.github.dellisd.shopifyapp.data.api.models.Product
import kotlinx.android.synthetic.main.item_product.view.*

class ProductsAdapter : ListAdapter<Product, ProductsAdapter.ViewHolder>(Product.DIFF_CALLBACK) {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Product) {
            itemView.titleText.text = item.title

            val count = item.variants.sumBy { it.inventoryQuantity.toInt() }
            itemView.inventoryCount.text = itemView.context.getString(R.string.inventory_count_label, count)

            Picasso.get().load(item.images[0].src).into(itemView.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}