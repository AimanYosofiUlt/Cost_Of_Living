package com.moscow.squad.dependencyInjection

import com.moscow.squad.logic.GetCitiesHasCheapestGroceryUseCase
import com.moscow.squad.logic.GetCitiesNamesWithTopSalaryUseCase
import com.moscow.squad.logic.SearchSalariesInCountryUseCase
import org.koin.dsl.module

val useCasesModule = module {
    single { GetCitiesNamesWithTopSalaryUseCase(get()) }
    single { GetCitiesHasCheapestGroceryUseCase(get()) }
    single { SearchSalariesInCountryUseCase(get()) }
}