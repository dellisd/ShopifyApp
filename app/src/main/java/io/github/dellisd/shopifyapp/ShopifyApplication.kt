package io.github.dellisd.shopifyapp

import android.app.Application
import com.google.gson.GsonBuilder
import io.github.dellisd.shopifyapp.data.ShopifyRepository
import io.github.dellisd.shopifyapp.data.api.ShopifyApiService
import io.github.dellisd.shopifyapp.ui.collections.CollectionsViewModel
import org.koin.android.ext.android.startKoin
import org.koin.android.viewmodel.ext.koin.viewModel
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ShopifyApplication : Application() {

    val module = org.koin.dsl.module.module {
        single { ShopifyRepository(get()) }
        single {
            Retrofit.Builder()
                .baseUrl("https://shopicruit.myshopify.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(get()))
                .build()
                .create(ShopifyApiService::class.java)
        }
        single { GsonBuilder().create() }
        viewModel { CollectionsViewModel(get()) }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(module))
    }

}