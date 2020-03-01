package io.mbo.kookin.domain.product

class Product private constructor(
        private val name: String,
        private val root: RootProduct
) {
    fun name() = name

    fun root() = root

    fun hasCategory(category: Category) = root.category == category

    companion object {
        fun of(name: String, root: RootProduct) = Product(name, root)
    }
}

