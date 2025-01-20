package com.example.kmp_base.webservice.dto.responses

import com.example.composebase.core.model.Other
import com.example.composebase.core.model.Sprite
import kotlinx.serialization.Serializable

@Serializable
data class SpriteDTO(val other: OtherDTO?)

fun SpriteDTO.toDomain(): Sprite = Sprite(
    other = other?.toDomain() ?: Other()
)
