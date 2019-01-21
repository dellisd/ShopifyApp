package io.github.dellisd.shopifyapp.ui.products

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.squareup.picasso.Picasso
import io.github.dellisd.shopifyapp.R
import kotlinx.android.synthetic.main.activity_products.*
import org.koin.android.viewmodel.ext.android.viewModel

class ProductsActivity : AppCompatActivity() {

    private val vm: ProductsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = ""
        }

        val collectionId = intent?.extras?.getLong(COLLECTION_ID_KEY)
        if (collectionId == null) {
            finish()
            return
        }

        collectionTitle.text = intent.getStringExtra(COLLECTION_TITLE_KEY)
        collectionBody.text = intent.getStringExtra(COLLECTION_DESCRIPTION_KEY)
        Picasso.get().load(intent.getStringExtra(COLLECTION_IMAGE_SRC_KEY)).into(collectionImage)

        collectListView.adapter = ProductsAdapter()

        vm.products.observe(this, Observer {
            it?.let((collectListView.adapter as ProductsAdapter)::submitList)
        })

        vm.isLoading.observe(this, Observer {
            if (it == true) {
                progressBar.visibility = View.VISIBLE
            } else {
                progressBar.visibility = View.GONE
            }
        })

        vm.fetchProducts(collectionId)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> finish()
        }

        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val COLLECTION_ID_KEY = "collection_id"
        const val COLLECTION_TITLE_KEY = "collection_title"
        const val COLLECTION_DESCRIPTION_KEY = "collection_description"
        const val COLLECTION_IMAGE_SRC_KEY = "collection_image_src"
    }
}
