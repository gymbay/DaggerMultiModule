package ru.gymbay.network

import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import ru.gymbay.core.network.MoexService
import ru.gymbay.models.Board
import java.lang.Exception

class NetworkProviderTest {

    private lateinit var moexService: MoexService

    @Before
    fun setUp() {
        moexService = NetworkProvider().createMoexService()
    }

    @Test
    fun requestBondHistory(): Unit = runBlocking {
        val isin = "RU000A0JXPG2"

        try {
            val history = moexService.getBondHistory(Board.TQCB, isin, "2022-02-11")
            val bondInfo = history.getOrNull(1)?.history?.firstOrNull()
            assertEquals(isin, bondInfo?.secId)
        } catch (error: Exception) {
            fail(error.message)
        }
    }

}