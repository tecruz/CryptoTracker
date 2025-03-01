package com.plcoding.cryptotracker.crypto.data

import com.plcoding.cryptotracker.core.domain.util.NetworkError
import com.plcoding.cryptotracker.core.domain.util.Result
import com.plcoding.cryptotracker.crypto.domain.Coin
import com.plcoding.cryptotracker.crypto.domain.CoinDataSource
import com.plcoding.cryptotracker.crypto.domain.CoinPrice
import java.time.ZonedDateTime

class FakeCoinDataSource : CoinDataSource {

    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return Result.Success(listOf(Coin(
            id = "bitcoin",
            rank = 1,
            name = "Bitcoin",
            symbol = "BTC",
            marketCapUsd = 2124124142344.75,
            priceUsd = 62828.15,
            changePercent24Hour = 0.1
        )))

    }

    override suspend fun getCoinHistory(
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPrice>, NetworkError> {
        TODO("Not yet implemented")
    }
}