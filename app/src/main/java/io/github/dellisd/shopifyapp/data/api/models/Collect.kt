package io.github.dellisd.shopifyapp.data.api.models

import com.google.gson.annotations.SerializedName
import java.util.*

data class Collect(
    @SerializedName("collection_id") val collectionId: Long,
    @SerializedName("created_at") val createdAt: Date,
    @SerializedName("featured") @Deprecated("") val featured: Boolean,
    @SerializedName("id") val id: Long,
    @SerializedName("position") val position: Long,
    @SerializedName("product_id") val productId: Long,
    @SerializedName("sort_value") val sortValue: String,
    @SerializedName("updated_at") val updatedAt: Date
)