package com.moscow.squad.dependencyInjection

import com.moscow.squad.data.CitiesCsvParsers
import com.moscow.squad.data.CsvCitiesRepository
import com.moscow.squad.data.CsvFileReader
import com.moscow.squad.logic.CitiesRepository
import com.moscow.squad.presentation.CostOfLivingUI
import org.koin.dsl.module
import java.io.File

val appModule = module {
    single { File("costOfLiving.csv") }
    single { CsvFileReader(get()) }
    single { CitiesCsvParsers() }

    single<CitiesRepository> { CsvCitiesRepository(get(), get()) }

    single { CostOfLivingUI(get(), get(), get()) }
}