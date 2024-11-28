package com.gpigroup

import android.content.Intent
import android.util.Log
import androidx.activity.result.ActivityResult
import com.getcapacitor.JSObject
import com.getcapacitor.Plugin
import com.getcapacitor.PluginCall
import com.getcapacitor.PluginMethod
import com.getcapacitor.annotation.ActivityCallback
import com.getcapacitor.annotation.CapacitorPlugin

@CapacitorPlugin(name = "CieIDLogin")
class CieIDLoginPlugin : Plugin() {
    val URL = "URL"

    @PluginMethod
    fun loginWithCieID(call: PluginCall) {
        val value = call.getString("value")

        val intent = Intent(context, RedirectionActivity::class.java)
        startActivityForResult(call, intent, "onResult")
    }

    @ActivityCallback
    fun onResult(call: PluginCall, result: ActivityResult) {
        Log.d("CieIDLoginPlugin", "onResult: ${result.data?.getStringExtra("value")}")
        val ret = JSObject()
        ret.put("value", result.data?.getStringExtra(URL))
        call.resolve(ret)
    }
}
