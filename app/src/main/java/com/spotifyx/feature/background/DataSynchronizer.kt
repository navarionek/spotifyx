package com.spotifyx.feature.background

interface DataSynchronizer {
    fun initSync() // called on first launch, starts services, alarms etc

}