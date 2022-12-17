package kr.co.younhwan.simpleloading

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import kr.co.younhwan.simpleloading.ui.theme.SimpleLoadingDialogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleLoadingDialogTheme {
                val state = remember {
                    mutableStateOf(false)
                }

                SimpleLoading(
                    openDialogCustom = state,
                    color = Color.Black,
                    clickableClose = true
                )

                Button(onClick = { state.value = !state.value }) {
                    Text(text = "click")
                }
            }
        }
    }
}