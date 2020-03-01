package io.mbo.kookin.domain.recipe

interface Recipes {

    fun add(recipe: Recipe): Boolean
    fun update(recipe: Recipe): Boolean
    fun delete(recipe: Recipe): Boolean
    fun find(title: String): Recipe?
    fun findAll(): List<Recipe>
    fun findByProduct(product: String): List<Recipe>

}