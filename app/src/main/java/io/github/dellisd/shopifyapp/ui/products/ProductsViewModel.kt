package io.github.dellisd.shopifyapp.ui.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.dellisd.shopifyapp.data.ShopifyRepository
import io.github.dellisd.shopifyapp.data.api.models.Product
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

class ProductsViewModel(private val repository: ShopifyRepository) : ViewModel() {

    private val disposables = CompositeDisposable()

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun fetchProducts(collectionId: Long) {
        _isLoading.value = true

        repository.getCollects(collectionId)
            .map { collects -> collects.collects.map { it.productId } }
            .flatMap { repository.getProducts(*it.toLongArray()) }
            .subscribe({
                _products.postValue(it.products)
                _isLoading.value = false
            }, {
                it.printStackTrace()
                _isLoading.value = false
            })
            .addTo(disposables)
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

}