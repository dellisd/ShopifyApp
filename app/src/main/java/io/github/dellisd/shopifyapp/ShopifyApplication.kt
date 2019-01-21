package io.github.dellisd.shopifyapp

import android.app.Application
import io.github.dellisd.shopifyapp.di.appModule
import io.github.dellisd.shopifyapp.di.networkModule
import org.koin.android.ext.android.startKoin

class ShopifyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appModule, networkModule))
    }

}