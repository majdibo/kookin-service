package io.mbo.kookin.application.recipe

import io.mbo.kookin.domain.recipe.*

class RecipeCommandHandler(private val recipes: Recipes) {
    fun execute(command: CreateRecipeCommand): Boolean {
        return recipes.add(Recipe(command.recipeName))
    }

    fun execute(command: AddIngredientToRecipeCommand): Boolean {
        return command.run {

            recipes.find(recipeName)
                    ?.apply {
                        addIngredient(Ingredient(product, quantity))
                    }
                    ?.let { recipes.update(it) } ?: false
        }
    }

    fun execute(command: AddInstructionToRecipeCommand): Boolean {
        return command.run {
            recipes.find(recipeName)
                    ?.apply { addInstruction(Instruction(order, title, description)) }
                    ?.let { recipes.update(it) } ?: false
        }
    }

}

data class CreateRecipeCommand(val recipeName: String)
data class AddIngredientToRecipeCommand(
        val recipeName: String,
        val product: String,
        val quantity: Quantity
)

data class AddInstructionToRecipeCommand(
        val recipeName: String,
        val order: Int,
        val title: String,
        val description: String
)



