package io.mbo.kookin.domain.product

interface Products {
    fun add(product: Product): Boolean
    fun delete(name: String): Boolean
    fun find(name: String): Product?
    fun findAll(): List<Product>
    fun findByCategory(category: Category): List<Product>

}