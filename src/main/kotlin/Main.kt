package com.moscow.squad

import com.moscow.squad.data.CsvCitiesRepository
import com.moscow.squad.data.CsvFileReader
import com.moscow.squad.data.CitiesCsvParsers
import com.moscow.squad.logic.CitiesRepository
import com.moscow.squad.logic.GetCitiesHasCheapestGroceryUseCase
import com.moscow.squad.logic.GetCitiesNamesWithTopSalaryUseCase
import com.moscow.squad.logic.SearchSalariesInCountryUseCase
import com.moscow.squad.presentation.CostOfLivingUI
import java.io.File

fun main() {
    val fileName = "costOfLiving.csv"
    val csvFile = File(fileName)
    val csvFileReader = CsvFileReader(csvFile)
    val citiesCsvParsers = CitiesCsvParsers()
    val citiesRepository: CitiesRepository = CsvCitiesRepository(csvFileReader, citiesCsvParsers)
    val getCitiesNamesWithTopSalaryFeature = GetCitiesNamesWithTopSalaryUseCase(citiesRepository)
    val getCitiesHasCheapestGroceryUseCase = GetCitiesHasCheapestGroceryUseCase(citiesRepository)
    val searchSalariesInCountryUseCase = SearchSalariesInCountryUseCase(citiesRepository)

    val costOfLivingUI = CostOfLivingUI(
        getCitiesNamesWithTopSalaryFeature,
        getCitiesHasCheapestGroceryUseCase,
        searchSalariesInCountryUseCase,
    )
    costOfLivingUI.start()
}
