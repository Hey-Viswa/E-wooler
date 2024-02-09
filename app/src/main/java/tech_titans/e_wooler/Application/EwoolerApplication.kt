package tech_titans.e_wooler.Application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class EwoolerApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}