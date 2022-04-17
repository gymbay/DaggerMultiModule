package ru.gymbay.network.services

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.gymbay.core.network.MoexService
import ru.gymbay.models.Board
import ru.gymbay.models.BondHistory

interface MoexServiceImpl: MoexService {

    @GET("history/engines/stock/markets/bonds/boards/{board}/securities/{isin}.json?iss.meta=off&iss.json=extended&lang=ru")
    override suspend fun getBondHistory(
        @Path("board") board: Board,
        @Path("isin") isin: String,
        @Query("from") from: String
    ): List<BondHistory>

}