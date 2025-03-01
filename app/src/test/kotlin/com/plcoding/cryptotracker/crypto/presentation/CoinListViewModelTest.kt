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

package com.plcoding.cryptotracker.crypto.presentation

import app.cash.turbine.test
import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isTrue
import com.plcoding.cryptotracker.crypto.data.FakeCoinDataSource
import com.plcoding.cryptotracker.crypto.domain.Coin
import com.plcoding.cryptotracker.crypto.presentation.coin_list.CoinListState
import com.plcoding.cryptotracker.crypto.presentation.coin_list.CoinListViewModel
import com.plcoding.cryptotracker.crypto.presentation.models.toCoinUI
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class CoinListViewModelTest {
    private lateinit var coinListViewModel: CoinListViewModel
    private lateinit var coinDataSource: FakeCoinDataSource

    @Before
    fun setup() {
        coinDataSource = FakeCoinDataSource()
        coinListViewModel =
            CoinListViewModel(
                coinDataSource = coinDataSource,
            )
    }

    @Test
    fun `State and coin list are properly combined`() = runBlocking {
        coinListViewModel.state.test {
            val initialState = awaitItem()
            assertThat(initialState).isEqualTo(CoinListState())

            val loadingState = awaitItem()
            assertThat(loadingState.isLoading).isTrue()

            val coinItem =
                Coin(
                    id = "bitcoin",
                    rank = 1,
                    name = "Bitcoin",
                    symbol = "BTC",
                    marketCapUsd = 2124124142344.75,
                    priceUsd = 62828.15,
                    changePercent24Hour = 0.1,
                )

            val coinsLoadedState = awaitItem()
            assertThat(coinsLoadedState.coins.first()).isEqualTo(coinItem.toCoinUI())
        }
    }
}
