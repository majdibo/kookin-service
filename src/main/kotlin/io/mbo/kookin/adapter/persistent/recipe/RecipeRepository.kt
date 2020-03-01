package io.mbo.kookin.adapter.persistent.recipe

import io.mbo.kookin.adapter.persistent.recipe.entity.RecipeEntity
import io.mbo.kookin.domain.recipe.Recipe
import io.mbo.kookin.domain.recipe.Recipes
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class RecipeRepository(private val repository: PersistentRecipeRepository) : Recipes {


    override fun add(recipe: Recipe): Boolean {
         repository.save(RecipeEntity.of(recipe)); return true
    }

    override fun update(recipe: Recipe) = add(recipe)

    override fun delete(recipe: Recipe) = try {
        repository.delete(RecipeEntity.of(recipe)); true
    } catch (e: Exception) {
        false
    }

    override fun find(title: String) = repository.findByIdOrNull(title)?.let { RecipeEntity.toDomain(it) }

    override fun findAll() = repository.findAll().map { RecipeEntity.toDomain(it) }

    override fun findByProduct(product: String) = findAll().filter { it.hasProduct(product) }
}