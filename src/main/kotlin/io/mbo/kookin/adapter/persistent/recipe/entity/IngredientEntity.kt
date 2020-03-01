package io.mbo.kookin.adapter.persistent.recipe.entity

import io.mbo.kookin.adapter.persistent.common.EntityMapper
import io.mbo.kookin.domain.recipe.Ingredient
import io.mbo.kookin.domain.recipe.Quantity
import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.IdClass
import javax.persistence.ManyToOne

@Entity(name = "ingredients")
@IdClass(IngredientId::class)
class IngredientEntity() {

    @Id
    lateinit var product: String

    var quantityValue: Int = 0
    lateinit var quantityUnit: String

    @Id
    @ManyToOne
    lateinit var recipe: RecipeEntity

    constructor(product: String, quantityValue: Int, quantityUnit: String) : this() {
        this.product = product
        this.quantityValue = quantityValue
        this.quantityUnit = quantityUnit
    }

    companion object : EntityMapper<IngredientEntity, Ingredient> {
        override fun of(domain: Ingredient) = domain.run {
            IngredientEntity(product, quantity.value, quantity.unit)
        }

        override fun toDomain(entity: IngredientEntity) = entity.run {
            Ingredient(product, Quantity(quantityValue, quantityUnit))
        }
    }
}

data class IngredientId(var product: String?, var recipe: RecipeEntity?) : Serializable {
    constructor() : this(null, null)
}
