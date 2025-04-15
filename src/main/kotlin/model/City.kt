package com.moscow.squad.model

import javax.print.attribute.standard.PrintQuality

data class City(
    val cityName: String,
    val countryName: String,
    val mealsPrices: MealsPrice,
    val drinksPrices: BeveragesPrice,
    val fruitAndVegetablesPrices: FruitAndVegetablesPrice,
    val foodPrices: FoodPrice,
    val servicesPrices: ServicesPrice,
    val clothesPrices: ClothesPrice,
    val transportationsPrices: TransportationsPrices,
    val carsPrices: CarsPrice,
    val realEstatesPrices: RealEstatesPrice,
    val averageMonthlyNetSalaryAfterTax: Float?,
    val isHighQuality: Boolean,
)