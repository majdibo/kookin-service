package adapter.persistent.product

import io.mbo.kookin.adapter.persistent.product.CategoryEntity
import io.mbo.kookin.adapter.persistent.product.ProductEntity

class InMemProductRepository {
    private val products: MutableList<ProductEntity> = ArrayList()

    fun add(product: ProductEntity): Boolean = products.add(product)

    fun delete(name: String): Boolean = products.removeIf { it.name == name }

    fun find(name: String): ProductEntity? = products.find { it.name == name }

    fun findAll(): List<ProductEntity> = products.toList()

    fun findByCategory(category: CategoryEntity): List<ProductEntity> = products.filter { it.root.category == category }
}