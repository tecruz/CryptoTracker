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

package com.plcoding.cryptotracker.crypto.presentation.models

import androidx.annotation.DrawableRes
import com.plcoding.cryptotracker.core.presentation.util.getDrawableIdForCoin
import com.plcoding.cryptotracker.crypto.domain.Coin
import com.plcoding.cryptotracker.crypto.presentation.coin_detail.DataPoint
import java.text.NumberFormat
import java.util.Locale

data class CoinUi(
    val id: String,
    val rank: Int,
    val name: String,
    val symbol: String,
    val marketCapUsd: DisplayableNumber,
    val priceUsd: DisplayableNumber,
    val changePercent24Hour: DisplayableNumber,
    @DrawableRes val iconRes: Int,
    val coinPriceHistory: List<DataPoint> = emptyList(),
)

data class DisplayableNumber(val value: Double, val formatted: String)

fun Coin.toCoinUI(): CoinUi = CoinUi(
    id = id,
    rank = rank,
    name = name,
    symbol = symbol,
    marketCapUsd = marketCapUsd.toDisplayableNumber(),
    priceUsd = priceUsd.toDisplayableNumber(),
    changePercent24Hour = changePercent24Hour.toDisplayableNumber(),
    iconRes = getDrawableIdForCoin(symbol),
)

fun Double.toDisplayableNumber(): DisplayableNumber {
    val formatter =
        NumberFormat.getNumberInstance(Locale.getDefault()).apply {
            minimumFractionDigits = 2
            maximumFractionDigits = 2
        }
    return DisplayableNumber(
        value = this,
        formatted = formatter.format(this),
    )
}
