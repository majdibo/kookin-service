package io.mbo.kookin.adapter.persistent.common

interface EntityMapper<ENTITY, DOMAIN> {
    fun of(domain: DOMAIN): ENTITY
    fun toDomain(entity: ENTITY) : DOMAIN
}
