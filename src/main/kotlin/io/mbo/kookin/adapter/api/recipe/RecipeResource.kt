package adapter.api.recipe

import io.mbo.kookin.domain.recipe.Ingredient
import io.mbo.kookin.domain.recipe.Instruction
import io.mbo.kookin.domain.recipe.Recipe

data class RecipeResource(val title: String,
                          val ingredients: List<IngredientResource> = emptyList(),
                          val instructions: List<InstructionResource> = emptyList()) {
    companion object {
        fun of(recipe: Recipe) = recipe.run {
            RecipeResource(
                    title(),
                    ingredients().map { IngredientResource.of(it) },
                    instructions().map { InstructionResource.of(it) }
            )
        }
    }
}

data class InstructionResource(val order: Int, val title: String, val description: String) {
    companion object {
        fun of(instruction: Instruction) = instruction.run { InstructionResource(order, title, description) }
    }
}

data class IngredientResource(val product: String, val quantity: Int, val unit: String) {
    companion object {
        fun of(ingredient: Ingredient) = ingredient.run { IngredientResource(product, quantity.value, quantity.unit) }
    }
}