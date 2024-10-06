package org.example.myfirstkmp

import oshi.SystemInfo

actual class Device {
    actual fun getName(): String {
        return SystemInfo().operatingSystem.networkParams.hostName
    }
}