package io.mbo.kookin.adapter.persistent.recipe.entity

import io.mbo.kookin.adapter.persistent.common.EntityMapper
import io.mbo.kookin.domain.recipe.Recipe
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity(name = "recipes")
class RecipeEntity() {

    @Id
    lateinit var title: String

    @OneToMany(mappedBy = "recipe", cascade = [CascadeType.ALL])
    var ingredients: MutableList<IngredientEntity> = ArrayList()

    @OneToMany(mappedBy = "recipe", cascade = [CascadeType.ALL])
    var instructions: MutableList<InstructionEntity> = ArrayList()

    constructor(title: String,
                ingredients: MutableList<IngredientEntity>,
                instructions: MutableList<InstructionEntity>) : this() {
        this.title = title
        this.ingredients = ingredients
        this.instructions = instructions
    }


    companion object : EntityMapper<RecipeEntity, Recipe> {

        override fun of(domain: Recipe) = domain.run {
            RecipeEntity(
                    title(),
                    ingredients().map { IngredientEntity.of(it) }.toMutableList(),
                    instructions().map { InstructionEntity.of(it) }.toMutableList()
            ).apply {
                ingredients.forEach { it.recipe = this }
                instructions.forEach { it.recipe = this }
            }
        }

        override fun toDomain(entity: RecipeEntity): Recipe {
            return entity.run {
                Recipe(title).also { r ->
                    ingredients.map { r.addIngredient(IngredientEntity.toDomain(it)) }
                    instructions.map { r.addInstruction(InstructionEntity.toDomain(it)) }
                }
            }
        }


    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RecipeEntity

        if (title != other.title) return false

        return true
    }

    override fun hashCode(): Int {
        return title.hashCode()
    }
}

