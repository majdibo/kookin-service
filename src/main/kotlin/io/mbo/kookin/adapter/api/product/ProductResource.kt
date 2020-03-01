package io.mbo.kookin.adapter.api.product

import io.mbo.kookin.domain.product.Product

data class ProductResource(
        val name: String,
        val category: String,
        val root: String
) {
    companion object {
        fun of(product: Product) = product.run { ProductResource(name(), root().category.name, root().name) }
    }
}
