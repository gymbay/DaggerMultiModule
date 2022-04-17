package ru.gymbay.core.network

import ru.gymbay.models.Board
import ru.gymbay.models.BondHistory

interface MoexService {
    suspend fun getBondHistory(board: Board, isin: String, from: String): List<BondHistory>
}