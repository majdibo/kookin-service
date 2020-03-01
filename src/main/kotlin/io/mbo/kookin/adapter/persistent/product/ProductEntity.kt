package io.mbo.kookin.adapter.persistent.product

import io.mbo.kookin.domain.product.Category
import io.mbo.kookin.domain.product.Product
import io.mbo.kookin.domain.product.RootProduct

data class ProductEntity(
        val name: String,
        val root: RootProductEntity
) {
    companion object {
        fun of(product: Product) = product.run { ProductEntity(name(), RootProductEntity.of(root())) }
        fun toProduct(product: ProductEntity) = product.run { Product.of(name, RootProductEntity.toRootProduct(root)) }

    }

}

data class RootProductEntity(
        val name: String,
        val category: CategoryEntity
) {
    companion object {
        fun of(root: RootProduct) = RootProductEntity(root.name, CategoryEntity.of(root.category))
        fun toRootProduct(root: RootProductEntity) = RootProduct(root.name, CategoryEntity.toCategory(root.category))
    }
}

data class CategoryEntity(val name: String) {
    companion object {
        fun of(category: Category) = CategoryEntity(category.name)
        fun toCategory(category: CategoryEntity) = Category(category.name)
    }
}
