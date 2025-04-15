package com.moscow.squad.logic

import com.moscow.squad.model.City
import com.moscow.squad.model.FruitAndVegetablesPrice

class GetCitiesHasCheapestGroceryUseCase(
    private val citiesRepository: CitiesRepository
) {
    fun getCitiesNames(): List<String> {
        return citiesRepository.getAllCities()
            .filter(::onlyHighQuality)
            .sortedBy { getAveragePriceForGrocery(it.fruitAndVegetablesPrices) / it.averageMonthlyNetSalaryAfterTax!! }
            .take(TOP_N)
            .map(City::cityName)
    }

    private fun onlyHighQuality(city: City): Boolean {
        return city.isHighQuality &&
                city.averageMonthlyNetSalaryAfterTax != null &&
                city.fruitAndVegetablesPrices.apples1Kg != null &&
                city.fruitAndVegetablesPrices.banana1Kg != null &&
                city.fruitAndVegetablesPrices.oranges1Kg != null &&
                city.fruitAndVegetablesPrices.tomato1Kg != null &&
                city.fruitAndVegetablesPrices.potato1Kg != null &&
                city.fruitAndVegetablesPrices.onion1Kg != null &&
                city.fruitAndVegetablesPrices.lettuceOneHead != null
    }

    private fun getAveragePriceForGrocery(input: FruitAndVegetablesPrice): Float {
        return (input.apples1Kg!! +
                input.banana1Kg!! +
                input.oranges1Kg!! +
                input.tomato1Kg!! +
                input.potato1Kg!! +
                input.onion1Kg!! +
                input.lettuceOneHead!!) / 7f
    }

    companion object {
        const val TOP_N = 10
    }
}