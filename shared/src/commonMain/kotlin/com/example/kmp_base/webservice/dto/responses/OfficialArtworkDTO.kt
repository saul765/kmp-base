package com.example.kmp_base.webservice.dto.responses

import com.example.kmp_base.model.OfficialArtwork
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OfficialArtworkDTO(@SerialName("front_default") val frontDefault: String?)

fun OfficialArtworkDTO.toDomain(): OfficialArtwork =
    OfficialArtwork(
        frontDefault = frontDefault.orEmpty()
    )
