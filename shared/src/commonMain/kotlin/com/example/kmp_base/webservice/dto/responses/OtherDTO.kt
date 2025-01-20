package com.example.kmp_base.webservice.dto.responses

import com.example.kmp_base.model.OfficialArtwork
import com.example.composebase.core.model.Other
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OtherDTO(
    @SerialName("official-artwork") val officialArtwork: OfficialArtworkDTO?
)

fun OtherDTO.toDomain(): Other =
    Other(
        officialArtwork = officialArtwork?.toDomain() ?: OfficialArtwork()
    )