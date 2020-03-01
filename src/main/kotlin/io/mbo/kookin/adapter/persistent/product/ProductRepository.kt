package io.mbo.kookin.adapter.persistent.product

import adapter.persistent.product.InMemProductRepository
import io.mbo.kookin.domain.product.Category
import io.mbo.kookin.domain.product.Product
import io.mbo.kookin.domain.product.Products

class ProductRepository : Products {
    private val repository = InMemProductRepository()


    override fun add(product: Product) = repository.add(ProductEntity.of(product))


    override fun delete(name: String) = repository.delete(name)

    override fun find(name: String) = repository.find(name)?.let { ProductEntity.toProduct(it) }

    override fun findAll() = repository.findAll().map { ProductEntity.toProduct(it) }

    override fun findByCategory(category: Category) =
            repository.findByCategory(CategoryEntity.of(category))
                    .map { ProductEntity.toProduct(it) }


}