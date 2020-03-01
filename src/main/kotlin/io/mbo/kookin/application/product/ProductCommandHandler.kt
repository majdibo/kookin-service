package io.mbo.kookin.application.product

import io.mbo.kookin.domain.product.Category
import io.mbo.kookin.domain.product.Product
import io.mbo.kookin.domain.product.Products
import io.mbo.kookin.domain.product.RootProduct

class ProductCommandHandler(private val products: Products) {
    fun execute(createProductCommand: CreateProductCommand): Boolean {
        return products.add(
                Product.of(
                        createProductCommand.productName,
                        RootProduct(createProductCommand.rootProductName, Category(createProductCommand.categoryName))
                )
        )
    }
}

data class CreateProductCommand(val productName: String, val rootProductName: String, val categoryName: String)


