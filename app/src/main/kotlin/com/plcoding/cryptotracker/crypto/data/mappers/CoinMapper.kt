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

package com.plcoding.cryptotracker.crypto.data.mappers

import com.plcoding.cryptotracker.crypto.data.networking.dto.CoinDto
import com.plcoding.cryptotracker.crypto.data.networking.dto.CoinPriceDto
import com.plcoding.cryptotracker.crypto.domain.Coin
import com.plcoding.cryptotracker.crypto.domain.CoinPrice
import java.time.Instant
import java.time.ZoneId

fun CoinDto.toCoin(): Coin = Coin(
    id = id,
    rank = rank,
    name = name,
    symbol = symbol,
    priceUsd = priceUsd,
    marketCapUsd = marketCapUsd,
    changePercent24Hour = changePercent24Hr,
)

fun CoinPriceDto.toCoinPrice(): CoinPrice = CoinPrice(
    priceUsd = priceUsd,
    dateTime =
    Instant
        .ofEpochMilli(time)
        .atZone(ZoneId.systemDefault()),
)
