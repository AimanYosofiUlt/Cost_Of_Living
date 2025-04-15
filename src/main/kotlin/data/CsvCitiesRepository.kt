package com.moscow.squad.data

import com.moscow.squad.logic.CitiesRepository
import com.moscow.squad.model.*

class CsvCitiesRepository(
    private val csvFileReader: CsvFileReader,
    private val citiesCsvParsers: CitiesCsvParsers,
) : CitiesRepository {
    override fun getAllCities(): List<City> {
        return csvFileReader.readLineFromFile().map {
            citiesCsvParsers.parseOneLine(it)
        }
    }
}
