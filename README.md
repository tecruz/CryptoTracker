<h1 align="center">Crypto Tracker</h1>

<p align="center">  
  Crypto Tracker that demonstrates list/detail pattern with <a href="https://developer.android.com/develop/ui/compose/layouts/adaptive/list-detail">Adaptive Layout</a> from Jetpack Compose
</p>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://github.com/tecruz/CryptoTracker/actions/workflows/android.yml"><img alt="Build" src="https://github.com/tecruz/VisitedCountries/actions/workflows/android.yml/badge.svg"/></a>
  <a href="https://codecov.io/gh/tecruz/CryptoTracker"><img src="https://codecov.io/gh/tecruz/CryptoTracker/graph/badge.svg?token=7vB8MLLmd9"/> 
 </a>
</p>

## Tech stack & Open-source libraries
- Minimum SDK level 26.
- [Kotlin](https://kotlinlang.org/) based, utilizing [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) for asynchronous operations.
- Jetpack Libraries:
  - Jetpack Compose: Android’s modern toolkit for declarative UI development.
  - Lifecycle: Observes Android lifecycles and manages UI states upon lifecycle changes.
  - ViewModel: Manages UI-related data and is lifecycle-aware, ensuring data survival through configuration changes.
  - Junit & Compose UI tests
- [Koin](https://insert-koin.io/): Facilitates dependency injection.
- [Ktor](https://ktor.io/): Constructs REST APIs and facilitates network requests.
- [Kotlin Serialization](https://github.com/Kotlin/kotlinx.serialization): Kotlin multiplatform / multi-format reflectionless serialization.
- [Turbine](https://github.com/cashapp/turbine): Small testing library for kotlinx.coroutines.
- [AssertK](https://github.com/willowtreeapps/assertk): Fluent assertion library for Kotlin.
- [Detekt](https://github.com/detekt/detekt): Code static analyzer.
- [Spotless](https://github.com/diffplug/spotless): Code formatter and lint.

## API
Crypto Traker using [Coincap](https://docs.coincap.io/) for constructing RESTful API.<br>
Coincap provides a RESTful API interface to crypto coins and corresponding price history.

## Screenshots
<p>  
  Smartphone
</p>
<img src="https://github.com/user-attachments/assets/a464270b-4abc-4a85-adef-36ce8cb5a42c" width="45%"/>
<img src="https://github.com/user-attachments/assets/673e15eb-df7f-4ec2-97df-0dab337c43d3" width="45%"/>


<p>  
  Tablet
</p>
<img src="https://github.com/user-attachments/assets/4742eefb-18e0-47cf-9cab-3c7a5ab787ae"/>

## Architecture
- MVI (Model-View-Intent)
- Clean Architecture 

<img src="https://github.com/user-attachments/assets/ab055255-ea96-406a-82b9-69033a61c4e7" width="45%"/>




