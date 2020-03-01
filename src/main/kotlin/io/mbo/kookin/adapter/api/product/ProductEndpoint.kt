package io.mbo.kookin.adapter.api.product

import io.mbo.kookin.application.product.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("products")
class ProductEndpoint(private val productService: ProductService) {

    @GetMapping
    fun getProducts(): List<ProductResource> {
        return productService.findAll().map { ProductResource.of(it) }
    }

    @PostMapping
    fun saveProduct(product: ProductResource): Boolean {
        return productService.add(product.name, product.root, product.category)
    }
}
