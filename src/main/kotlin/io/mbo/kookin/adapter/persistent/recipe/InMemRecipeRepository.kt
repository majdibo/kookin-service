package io.mbo.kookin.adapter.persistent.recipe

import io.mbo.kookin.adapter.persistent.recipe.entity.RecipeEntity

class InMemRecipeRepository {
    private val recipes: MutableList<RecipeEntity> = ArrayList()

    fun add(recipe: RecipeEntity) = recipes.add(recipe)

    fun update(recipe: RecipeEntity): Boolean {
        val r = recipes.find { it.title == recipe.title }
        r ?: return false
        r.run {
            ingredients.apply { removeIf { !recipe.ingredients.contains(it) } }.addAll(recipe.ingredients)
            instructions.apply { removeIf { !recipe.instructions.contains(it) } }.addAll(recipe.instructions)
        }
        return true
    }

    fun delete(title: String) = recipes.removeIf { it.title == title }

    fun find(title: String): RecipeEntity? = recipes.find { it.title == title }

    fun findAll(): List<RecipeEntity> {
        return recipes.toList()
    }

    fun findByProduct(product: String): List<RecipeEntity> =
            recipes.filter { RecipeEntity.toDomain(it).hasProduct(product) }
}