package io.github.dellisd.shopifyapp.data.api.models

import com.google.gson.annotations.SerializedName
import java.util.*

data class Product(
    val bodyHtml: String,
    val createdAt: Date,
    val handle: String,
    val id: Long,
    val images: List<ProductImage>,
    val options: List<ProductOption>,
    val productType: String,
    val publishedAt: Date,
    val publishedScope: String,
    val tags: String,
    val templateSuffix: String?,
    val title: String,
    val metafieldsGlobalTitleTag: String,
    val metafieldsGlobalDescriptionTag: String,
    val updatedAt: Date,
    val variants: List<ProductVariant>,
    val vendor: String
)

data class ProductVariant(
    @SerializedName("barcode") val barcode: String,
    @SerializedName("compare_at_price") val compareAtPrice: Double,
    @SerializedName("created_at") val createdAt: Date,
    @SerializedName("fulfillment_service") val fulfillmentService: String,
    @SerializedName("grams") val grams: Double,
    @SerializedName("id") val id: Long,
    @SerializedName("image_id") val imageId: Long,
    @SerializedName("inventory_item_id") val inventoryItemId: Long,
    @SerializedName("inventory_management") val inventoryManagement: String,
    @SerializedName("inventory_policy") val inventoryPolicy: String,
    @SerializedName("inventory_quantity") val inventoryQuantity: Long,
    @SerializedName("old_inventory_quantity") @Deprecated("This property is deprecated. Use the InventoryLevel resource instead.") val oldInventoryQuantity: Long,
    @SerializedName("inventory_quantity_adjustment") @Deprecated("This property is deprecated. Use the InventoryLevel resource instead.") val inventoryQuantityAdjustment: String,
    @SerializedName("option1") val option1: String?,
    @SerializedName("option2") val option2: String?,
    @SerializedName("option3") val option3: String?,
    @SerializedName("position") val position: Long,
    @SerializedName("price") val price: Double,
    @SerializedName("product_id") val productId: Long,
    @SerializedName("requires_shipping") val requiresShipping: Boolean,
    @SerializedName("sku") val sku: String,
    @SerializedName("taxable") val taxable: Boolean,
    @SerializedName("tax_code") val taxCode: String,
    @SerializedName("title") val title: String,
    @SerializedName("updated_at") val updatedAt: Date,
    @SerializedName("weight") val weight: Double,
    @SerializedName("weight_unit") val weightUnit: String
)

data class ProductImage(
    @SerializedName("created_at") val createdAt: Date,
    @SerializedName("id") val id: Long,
    @SerializedName("position") val position: Long,
    @SerializedName("product_id") val productId: Long,
    @SerializedName("variant_ids") val variantIds: List<Long>,
    @SerializedName("src") val src: String,
    @SerializedName("width") val width: Long,
    @SerializedName("height") val height: Long,
    @SerializedName("updated_at") val updatedAt: Date
)

data class ProductOption(
    @SerializedName("id") val id: Long,
    @SerializedName("product_id") val productId: Long,
    @SerializedName("name") val name: String,
    @SerializedName("position") val position: Long,
    @SerializedName("values") val values: List<String>
)