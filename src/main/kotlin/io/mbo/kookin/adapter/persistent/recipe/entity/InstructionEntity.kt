package io.mbo.kookin.adapter.persistent.recipe.entity

import io.mbo.kookin.adapter.persistent.common.EntityMapper
import io.mbo.kookin.domain.recipe.Instruction
import java.io.Serializable
import javax.persistence.*

@Entity(name = "instructions")
@IdClass(InstructionId::class)
class InstructionEntity() {

    @Id
    var instructionOrder: Int = -1

    lateinit var title: String
    lateinit var description: String

    @Id
    @ManyToOne
    lateinit var recipe: RecipeEntity

    constructor(order: Int, title: String, description: String) : this() {
        this.instructionOrder = order
        this.title = title
        this.description = description
    }

    companion object : EntityMapper<InstructionEntity, Instruction> {
        override fun of(domain: Instruction) = domain.run { InstructionEntity(order, title, description) }

        override fun toDomain(entity: InstructionEntity) = entity.run { Instruction(instructionOrder, title, description) }
    }
}

data class InstructionId(var instructionOrder: Int?, var recipe: RecipeEntity?) : Serializable {
    constructor() : this(null, null)
}
