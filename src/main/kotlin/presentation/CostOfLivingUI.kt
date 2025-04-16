package com.moscow.squad.presentation

import com.moscow.squad.logic.GetCitiesHasCheapestGroceryUseCase
import com.moscow.squad.logic.GetCitiesNamesWithTopSalaryUseCase
import com.moscow.squad.logic.SearchSalariesInCountryUseCase

class CostOfLivingUI(
    private val getCitiesNamesWithTopSalaryUseCase: GetCitiesNamesWithTopSalaryUseCase,
    private val getCitiesHasCheapestGroceryUseCase: GetCitiesHasCheapestGroceryUseCase,
    private val searchSalariesInCountryUseCase: SearchSalariesInCountryUseCase,
) {
    fun start() {
        showWelcome()
        presentFeatures()
    }

    private fun presentFeatures() {
        showOptions()
        val input = getUserInput()
        var shouldExit = false
        when (input) {
            1 -> launchTopSalaries()
            2 -> launchCheapestGregory()
            3 -> launchSearchSalariesInCountry()
            4 -> {
                shouldExit = true
            }

            else -> {
                println("Invalid Input")
            }
        }
        if (shouldExit)
            println("👋")
        else
            presentFeatures()
    }

    private fun showWelcome() {
        println("Welcome to cost of living app")
    }

    private fun showOptions() {
        println("\n\n === please enter one of the following numbers === ")
        println("1- get names of cities with the highest salary")
        println("2- get names of cities with the cheapest grocery comparing to salaries")
        println("3- search for salaries, in any country")
        println("4- Exit")
        print("here: ")
    }

    private fun launchTopSalaries() {
        print("enter count of cities: ")
        getUserInput()?.let { count ->
            getCitiesNamesWithTopSalaryUseCase.getTopNCitiesNames(count)
                .forEach { println(it) }
        } ?: println("input is invalid")
    }

    private fun launchCheapestGregory() {
        getCitiesHasCheapestGroceryUseCase.getCitiesNames()
            .forEach { println(it) }
    }

    private fun launchSearchSalariesInCountry() {
        print("enter country name: ")
        readlnOrNull()?.let { name ->
            try {
                searchSalariesInCountryUseCase.searchCountry(name)
                    .forEach { println(it) }
            } catch (e: Exception) {
                println("error:" + e.message)
            }
        } ?: println("input is invalid")

    }

    private fun getUserInput(): Int? {
        return readlnOrNull()?.toIntOrNull()
    }
}