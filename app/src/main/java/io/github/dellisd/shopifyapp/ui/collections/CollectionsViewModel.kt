package io.github.dellisd.shopifyapp.ui.collections

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.dellisd.shopifyapp.data.ShopifyRepository
import io.github.dellisd.shopifyapp.data.api.models.Collection
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

class CollectionsViewModel(private val repository: ShopifyRepository) : ViewModel() {

    private val disposables = CompositeDisposable()

    private val _collections = MutableLiveData<List<Collection>>()
    val collections: LiveData<List<Collection>> = _collections

    fun fetchCollections() {
        repository.getCustomCollections()
            .subscribe({
                _collections.postValue(it.collections)
            }, {
                it.printStackTrace()
            })
            .addTo(disposables)
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

}