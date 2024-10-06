package org.example.myfirstkmp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.example.myfirstkmp.di.AppComponent
import org.example.myfirstkmp.di.appComponent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App(remember {
                Device()
            })
        }
    }
}
