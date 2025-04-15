package com.moscow.squad.data

import java.io.File

class CsvFileReader(private val csvFile: File) {
    fun readLineFromFile(): List<String> {
        return csvFile.readLines()
    }
}