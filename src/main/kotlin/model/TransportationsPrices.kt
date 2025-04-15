package com.moscow.squad.model

data class TransportationsPrices(
    val oneWayTicketLocalTransport: Float?,
    val monthlyPassRegularPrice: Float?,
    val taxiStartNormalTariff: Float?,
    val taxi1KmNormalTariff: Float?,
    val taxi1HourWaitingNormalTariff: Float?,
    val gasolineOneLiter: Float?,
)