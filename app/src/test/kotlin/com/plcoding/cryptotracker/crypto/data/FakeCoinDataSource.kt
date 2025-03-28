/*
 * Designed and developed by 2025 tecruz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.plcoding.cryptotracker.crypto.data

import com.plcoding.cryptotracker.core.domain.util.NetworkError
import com.plcoding.cryptotracker.core.domain.util.Result
import com.plcoding.cryptotracker.crypto.domain.Coin
import com.plcoding.cryptotracker.crypto.domain.CoinDataSource
import com.plcoding.cryptotracker.crypto.domain.CoinPrice
import java.time.ZonedDateTime

class FakeCoinDataSource : CoinDataSource {
    override suspend fun getCoins(): Result<List<Coin>, NetworkError> = Result.Success(
        listOf(
            Coin(
                id = "bitcoin",
                rank = 1,
                name = "Bitcoin",
                symbol = "BTC",
                marketCapUsd = 2124124142344.75,
                priceUsd = 62828.15,
                changePercent24Hour = 0.1,
            ),
        ),
    )

    override suspend fun getCoinHistory(
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime,
    ): Result<List<CoinPrice>, NetworkError> {
        TODO("Not yet implemented")
    }
}
