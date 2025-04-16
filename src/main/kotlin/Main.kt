package com.moscow.squad

import com.moscow.squad.dependencyInjection.appModule
import com.moscow.squad.dependencyInjection.useCasesModule
import com.moscow.squad.presentation.CostOfLivingUI
import org.koin.core.context.startKoin
import org.koin.mp.KoinPlatform

fun main() {
    startKoin {
        modules(appModule, useCasesModule)
    }

    val costOfLivingUI: CostOfLivingUI = KoinPlatform.getKoin().get()
    costOfLivingUI.start()
}
