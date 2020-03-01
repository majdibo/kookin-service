package io.mbo.kookin.domain.recipe

class Recipe(private val title: String) {

    private val ingredients: MutableList<Ingredient> = ArrayList()

    private val instructions: MutableList<Instruction> = ArrayList()

    fun title() = title
    fun ingredients() = ingredients.toList()
    fun instructions() = instructions.toList()

    fun hasProduct(product: String): Boolean = ingredients.any { ingredient -> ingredient.product == product }
    fun addIngredient(ingredient: Ingredient) = ingredients.add(ingredient)
    fun addInstruction(instruction: Instruction) = instructions.add(instruction)

}

