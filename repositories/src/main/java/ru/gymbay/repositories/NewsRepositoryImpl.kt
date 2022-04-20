package ru.gymbay.repositories

import ru.gymbay.core.network.MoexService
import ru.gymbay.core.repositories.NewsRepository
import ru.gymbay.models.news.News
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val moexService: MoexService
): NewsRepository {

    override suspend fun get(): List<News> {
        val newsObjects = moexService.getNews()
        return newsObjects[1].siteNews!!
    }

}