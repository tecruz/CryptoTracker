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

package com.plcoding.cryptotracker.core.domain.util

typealias DomainError = Error

sealed interface Result<out D, out E : Error> {
    data class Success<out D>(val data: D) : Result<D, Nothing>

    data class Error<out E : DomainError>(val error: E) : Result<Nothing, E>
}

inline fun <T, E : Error, R> Result<T, E>.map(map: (T) -> R): Result<R, E> = when (this) {
    is Result.Error -> Result.Error(error)
    is Result.Success -> Result.Success(map(data))
}

fun <T, E : Error> Result<T, E>.asEmptyDataResult(): EmptyResult<E> = map { }

inline fun <T, E : Error> Result<T, E>.onSuccess(action: (T) -> Unit): Result<T, E> = when (this) {
    is Result.Error -> this
    is Result.Success -> {
        action(data)
        this
    }
}

inline fun <T, E : Error> Result<T, E>.onError(action: (E) -> Unit): Result<T, E> = when (this) {
    is Result.Error -> {
        action(error)
        this
    }
    is Result.Success -> this
}

typealias EmptyResult<E> = Result<Unit, E>
