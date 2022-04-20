package ru.gymbay.core.network

import ru.gymbay.models.bond.Board
import ru.gymbay.models.bond.BondHistory
import ru.gymbay.models.news.NewsListObject

interface MoexService {

    suspend fun getBondHistory(board: Board, isin: String, from: String): List<BondHistory>

    suspend fun getNews(): List<NewsListObject>

}