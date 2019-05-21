package com.papered.gorae.util

import android.arch.lifecycle.Lifecycle

interface LifecycleCallback {
    fun apply(event: Lifecycle.Event)
}