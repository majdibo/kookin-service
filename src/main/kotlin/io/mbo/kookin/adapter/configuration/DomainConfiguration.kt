package io.mbo.kookin.adapter.configuration

import io.mbo.kookin.adapter.persistent.product.ProductRepository
import io.mbo.kookin.adapter.persistent.recipe.PersistentRecipeRepository
import io.mbo.kookin.adapter.persistent.recipe.RecipeRepository
import io.mbo.kookin.application.product.ProductService
import io.mbo.kookin.application.recipe.RecipeService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class DomainConfiguration {

    @Bean
    fun productService() = ProductService(ProductRepository())

    @Bean
    fun recipeService(repository: PersistentRecipeRepository) = RecipeService(RecipeRepository(repository))
}
