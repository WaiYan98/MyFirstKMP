package org.example.myfirstkmp

actual class Device {
    actual fun getName(): String {
        return android.os.Build.MODEL
    }
}