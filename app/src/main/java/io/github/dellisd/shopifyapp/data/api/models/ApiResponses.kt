package io.github.dellisd.shopifyapp.data.api.models

import com.google.gson.annotations.SerializedName

data class Collections(@SerializedName("custom_collections") val collections: List<Collection>)

data class Collects(@SerializedName("collects") val collects: List<Collect>)

data class Products(@SerializedName("products") val products: List<Product>)