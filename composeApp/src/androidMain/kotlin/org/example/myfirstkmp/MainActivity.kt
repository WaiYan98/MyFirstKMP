package org.example.myfirstkmp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import org.example.myfirstkmp.common.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App(
                remember {
                    Device()
                },
                networkComponent
            )
        }
    }
}
