package com.moscow.squad.logic

import com.moscow.squad.model.City

interface CitiesRepository {
    fun getAllCities(): List<City>
}