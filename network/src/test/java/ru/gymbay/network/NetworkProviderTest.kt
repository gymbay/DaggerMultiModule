package ru.gymbay.network

import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import ru.gymbay.core.network.MoexService
import ru.gymbay.models.bond.Board
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

    @Test
    fun requestNews(): Unit = runBlocking {
        try {
            val newsObjects = moexService.getNews()
            val news = newsObjects.getOrNull(1)?.siteNews?.firstOrNull()
            assertTrue(news?.id != null)
        } catch (error: Exception) {
            fail(error.message)
        }
    }

}