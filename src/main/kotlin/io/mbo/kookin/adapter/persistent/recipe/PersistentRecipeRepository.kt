package io.mbo.kookin.adapter.persistent.recipe

import io.mbo.kookin.adapter.persistent.recipe.entity.RecipeEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PersistentRecipeRepository : CrudRepository<RecipeEntity, String> {
}


