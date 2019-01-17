package io.github.dellisd.shopifyapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import io.github.dellisd.shopifyapp.R
import io.github.dellisd.shopifyapp.ui.collections.CollectionsAdapter
import io.github.dellisd.shopifyapp.ui.collections.CollectionsViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val vm: CollectionsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        collectionsListView.adapter = CollectionsAdapter()

        vm.collections.observe(this, Observer {
            it?.let((collectionsListView.adapter as CollectionsAdapter)::submitList)
        })

        vm.fetchCollections()
    }
}
