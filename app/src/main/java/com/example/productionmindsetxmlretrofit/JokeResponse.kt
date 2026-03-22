package com.example.productionmindsetxmlretrofit

data class JokeResponse(
    val category: String?,
    val error: Boolean?,
    val flags: Flags?,
    val id: Int?,
    val joke: String?,
    val setup: String?,      // ✅ add this
    val delivery: String?,   // ✅ add this
    val lang: String?,
    val safe: Boolean?,
    val type: String?
) {
    data class Flags(
        val explicit: Boolean?,
        val nsfw: Boolean?,
        val political: Boolean?,
        val racist: Boolean?,
        val religious: Boolean?,
        val sexist: Boolean?
    )
}