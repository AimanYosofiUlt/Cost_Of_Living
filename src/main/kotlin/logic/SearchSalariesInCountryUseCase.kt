package com.moscow.squad.logic

import com.moscow.squad.model.City

class SearchSalariesInCountryUseCase(
    private val citiesRepository: CitiesRepository
) {
    fun searchCountry(name: String): List<Pair<String, Float>> {
        return citiesRepository.getAllCities()
            .filter(::onlyHighQualityData)
            .filter { it.countryName.equals(name, ignoreCase = true) }
            .takeIf { it.isNotEmpty() }
            ?.map { it.cityName to it.averageMonthlyNetSalaryAfterTax!! }
            ?: throw Exception("Country not found")
    }


    private fun onlyHighQualityData(city: City): Boolean {
        return city.isHighQuality && city.averageMonthlyNetSalaryAfterTax != null
    }
}