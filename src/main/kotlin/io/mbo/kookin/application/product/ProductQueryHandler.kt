package io.mbo.kookin.application.product

import io.mbo.kookin.domain.product.Products

class ProductQueryHandler(private val products: Products) {
    fun execute(productFindAllQuery: ProductFindAllQuery) = products.findAll()
}

class ProductFindAllQuery