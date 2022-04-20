package ru.gymbay.network.services

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.gymbay.core.network.MoexService
import ru.gymbay.models.bond.Board
import ru.gymbay.models.bond.BondHistory
import ru.gymbay.models.news.NewsListObject

interface MoexServiceImpl: MoexService {

    @GET("history/engines/stock/markets/bonds/boards/{board}/securities/{isin}.json?iss.meta=off&iss.json=extended&lang=ru")
    override suspend fun getBondHistory(
        @Path("board") board: Board,
        @Path("isin") isin: String,
        @Query("from") from: String
    ): List<BondHistory>

    @GET("sitenews.json?start=0&iss.json=extended&iss.meta=off")
    override suspend fun getNews(): List<NewsListObject>

}