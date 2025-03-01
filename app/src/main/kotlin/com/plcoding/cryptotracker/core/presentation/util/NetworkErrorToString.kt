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

package com.plcoding.cryptotracker.core.presentation.util

import android.content.Context
import com.plcoding.cryptotracker.R
import com.plcoding.cryptotracker.core.domain.util.NetworkError

fun NetworkError.toString(context: Context): String {
    val resId =
        when (this) {
            NetworkError.REQUEST_TIMEOUT -> R.string.error_request_timeout
            NetworkError.TOO_MANY_REQUESTS -> R.string.error_too_many_requests
            NetworkError.NO_INTERNET -> R.string.error_no_internet
            NetworkError.SERVER_ERROR -> R.string.error_unknown
            NetworkError.SERIALIZATION -> R.string.error_serialization
            NetworkError.UNKNOWN -> R.string.error_unknown
        }
    return context.getString(resId)
}
