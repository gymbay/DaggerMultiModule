package ru.gymbay.core.repositories

interface BaseRepository<Response> {
    suspend fun get(): Response
}