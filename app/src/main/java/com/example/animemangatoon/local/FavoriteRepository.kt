package com.example.animemangatoon.local

class FavoriteRepository(private val dao: FavoriteWebtoonDao) {
    suspend fun addFavorite(webtoon: FavoriteWebtoon) {
        dao.addFavorite(webtoon)
    }
    suspend fun getFavorites(): List<FavoriteWebtoon> {
        return dao.getAllFavorites()
    }
}