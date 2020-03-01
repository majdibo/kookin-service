package io.mbo.kookin.application.product

import io.mbo.kookin.domain.product.Product
import io.mbo.kookin.domain.product.Products

class ProductService(products: Products) {
    private val productQueryHandler: ProductQueryHandler = ProductQueryHandler(products)
    private val productCommandHandler: ProductCommandHandler = ProductCommandHandler(products)

    fun add(productName: String, rootProductName: String, categoryName: String): Boolean =
            productCommandHandler.execute(CreateProductCommand(productName, rootProductName, categoryName))

    fun findAll(): List<Product> = productQueryHandler.execute(ProductFindAllQuery())
}
