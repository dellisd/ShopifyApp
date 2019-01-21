package io.github.dellisd.shopifyapp.di

import io.github.dellisd.shopifyapp.data.ShopifyRepository
import io.github.dellisd.shopifyapp.ui.collections.CollectionsViewModel
import io.github.dellisd.shopifyapp.ui.products.ProductsViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module {

    single { ShopifyRepository(get()) }

    viewModel { CollectionsViewModel(get()) }

    viewModel { ProductsViewModel(get()) }

}