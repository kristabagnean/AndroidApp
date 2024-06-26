package com.sample.androidapp

import android.os.Build
import android.app.Application
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.os.BuildCompat
import io.ionic.portals.PortalManager

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        var portalApiKey = ""
        packageManager.getApplicationInfo(packageName, PackageManager.GET_META_DATA).apply {
            portalApiKey = metaData.getString("portals_key", "")
        }
        PortalManager.register(portalApiKey)
        // setup portals
        val portalId = getString(R.string.portal_id)
        PortalManager.newPortal(portalId).create()
    }
}