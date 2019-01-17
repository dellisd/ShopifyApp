package io.github.dellisd.shopifyapp.data.api.models

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName
import java.util.*

data class Collection(
    @SerializedName("id") val id: Long,
    @SerializedName("handle") val handle: String,
    @SerializedName("title") val title: String,
    @SerializedName("updated_at") val updatedAt: Date,
    @SerializedName("body_html") val bodyHtml: String,
    @SerializedName("published_at") val publishedAt: Date,
    @SerializedName("sort_order") val sortOrder: String,
    @SerializedName("template_suffix") val templateSuffix: String,
    @SerializedName("published_scope") val publishedScope: String,
    @SerializedName("image") val image: CollectionImage
) {

    companion object {

        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Collection>() {
            override fun areItemsTheSame(oldItem: Collection, newItem: Collection): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Collection, newItem: Collection): Boolean = oldItem == newItem
        }

    }

}

data class CollectionImage(
    @SerializedName("created_at") val createdAt: Date,
    @SerializedName("alt") val alt: String?,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("src") val src: String
)