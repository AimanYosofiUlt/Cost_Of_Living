package com.moscow.squad.logic

import com.moscow.squad.model.City

class GetCitiesNamesWithTopSalaryUseCase(
    private val citiesRepository: CitiesRepository
) {
    fun getTopNCitiesNames(count: Int): List<String> {
        return citiesRepository.getAllCities()
            .filter(::onlyHighQualityData)
            .sortedByDescending { it.averageMonthlyNetSalaryAfterTax }
            .take(count)
            .map { it.cityName }
    }

    private fun onlyHighQualityData(city: City): Boolean {
        return city.isHighQuality && city.averageMonthlyNetSalaryAfterTax != null
    }
}