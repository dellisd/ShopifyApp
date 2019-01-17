package io.github.dellisd.shopifyapp.data

import io.github.dellisd.shopifyapp.data.api.ShopifyApiService
import io.github.dellisd.shopifyapp.data.api.models.Collections
import io.github.dellisd.shopifyapp.data.api.models.Collects
import io.github.dellisd.shopifyapp.data.api.models.Products
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

class ShopifyRepository(private val service: ShopifyApiService) {

    fun getCustomCollections(): Single<Collections> {
        return service.getCustomCollections()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getCollects(collectionId: Long): Single<Collects> {
        return service.getCollects(collectionId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getProducts(vararg ids: Long): Single<Products> {
        return service.getProducts(ids.joinToString(separator = ","))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}