package io.mbo.kookin.adapter.api.recipe

import adapter.api.recipe.IngredientResource
import adapter.api.recipe.InstructionResource
import adapter.api.recipe.RecipeResource
import io.mbo.kookin.application.recipe.RecipeService
import io.mbo.kookin.domain.recipe.Quantity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("recipes")
class RecipeEndpoint(private val recipeService: RecipeService) {


    @GetMapping
    fun getRecipes(@RequestParam products: List<String>?): List<RecipeResource> {

        return if (products != null && products.isNotEmpty())
            recipeService.findByProducts(products).map { RecipeResource.of(it) }
        else
            recipeService.findAll().map { RecipeResource.of(it) }
    }

    @PostMapping
    fun saveRecipe(@RequestBody request: RecipeResource): Boolean {
        return recipeService.add(request.title)
    }

    @PostMapping("{recipeName}/ingredients")
    fun saveIngredient(@PathVariable recipeName: String, @RequestBody ingredientResource: IngredientResource) {
        ingredientResource.run { recipeService.addIngredientToRecipe(recipeName, product, Quantity(quantity, unit)) }
    }


    @PostMapping("{recipeName}/instructions")
    fun saveInstructions(@PathVariable recipeName: String, @RequestBody instructionResource: InstructionResource) {
        instructionResource.run { recipeService.addInstructionToRecipe(recipeName, order, title, description) }
    }
}


