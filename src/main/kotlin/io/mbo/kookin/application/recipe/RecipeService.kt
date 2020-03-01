package io.mbo.kookin.application.recipe

import io.mbo.kookin.domain.recipe.Quantity
import io.mbo.kookin.domain.recipe.Recipe
import io.mbo.kookin.domain.recipe.Recipes

class RecipeService(recipes: Recipes) {
    private val recipeQueryHandler: RecipeQueryHandler = RecipeQueryHandler(recipes)
    private val recipeCommandHandler: RecipeCommandHandler = RecipeCommandHandler(recipes)

    fun add(recipeName: String): Boolean {
        return recipeCommandHandler.execute(CreateRecipeCommand(recipeName))
    }

    fun addIngredientToRecipe(recipeName: String, product: String, quantity: Quantity): Boolean {
        return recipeCommandHandler.execute(AddIngredientToRecipeCommand(recipeName, product, quantity))
    }

    fun addInstructionToRecipe(recipeName: String, order: Int, title: String, description: String): Boolean {
        return recipeCommandHandler.execute(AddInstructionToRecipeCommand(recipeName, order, title, description))
    }

    fun findAll(): List<Recipe> = recipeQueryHandler.execute(RecipeFindAllQuery())

    fun findByProducts(products: List<String>) = recipeQueryHandler.execute(RecipeFindByProductsQuery(products))
}