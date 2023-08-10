package com.example.weatherapp.core.domain.util

import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableStateFlow

actual open class CommonMutableStateFlow<T> actual constructor(
    private val flow: MutableStateFlow<T>
): CommonStateFlow<T>(flow), MutableStateFlow<T> by flow {

    override suspend fun collect(collector: FlowCollector<T>): Nothing {
        flow.collect(collector)
    }

    override val replayCache: List<T>
        get() = flow.replayCache

    override var value: T
        get() = flow.value
        set(value) {
            flow.value = value
        }

}