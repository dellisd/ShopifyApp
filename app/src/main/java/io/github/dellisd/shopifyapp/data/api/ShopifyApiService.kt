package io.github.dellisd.shopifyapp.data.api

import io.github.dellisd.shopifyapp.data.api.models.Collections
import io.github.dellisd.shopifyapp.data.api.models.Collects
import io.github.dellisd.shopifyapp.data.api.models.Products
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ShopifyApiService {

    @GET("admin/collects.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6")
    fun getCustomCollections(): Single<Collections>

    @GET("admin/collects.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6")
    fun getCollects(@Query("collection_id") collectionId: Long): Single<Collects>

    /**
     * @param ids Comma separated integer ids. e.g. 2759137027,2759143811
     */
    @GET("admin/collects.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6")
    fun getProducts(@Query("ids") ids: String): Single<Products>

}