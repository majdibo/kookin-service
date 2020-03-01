package io.mbo.kookin.application.recipe

import io.mbo.kookin.domain.recipe.Recipes

class RecipeQueryHandler(private val recipes: Recipes) {
    fun execute(query: RecipeFindAllQuery) = recipes.findAll()
    fun execute(query: RecipeFindByProductsQuery) = query.products.flatMap { recipes.findByProduct(it) }.distinctBy { it.title() }
}

data class RecipeFindAllQuery(val limit: Int = Int.MAX_VALUE)

data class RecipeFindByProductsQuery(val products: List<String>)