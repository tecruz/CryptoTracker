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

package com.plcoding.cryptotracker.crypto.presentation.coin_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.plcoding.cryptotracker.crypto.presentation.coin_list.components.CoinListItem
import com.plcoding.cryptotracker.crypto.presentation.coin_list.components.previewCoin
import com.plcoding.cryptotracker.ui.theme.CryptoTrackerTheme

@Composable
fun CoinListScreen(state: CoinListState, onAction: (CoinListAction) -> Unit, modifier: Modifier = Modifier) {
    if (state.isLoading) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(state.coins) { coinUi ->
                CoinListItem(
                    coinUi = coinUi,
                    onClick = {
                        onAction(CoinListAction.OnCoinClick(coinUi))
                    },
                    modifier = Modifier.fillMaxWidth(),
                )
                HorizontalDivider()
            }
        }
    }
}

@PreviewLightDark
@Composable
fun CoinListScreenPreview() {
    CryptoTrackerTheme {
        CoinListScreen(
            state = CoinListState(
                coins = (1..100).map {
                    previewCoin.copy(id = it.toString())
                },
            ),
            modifier = Modifier.background(MaterialTheme.colorScheme.background),
            onAction = {},
        )
    }
}
