package kr.co.younhwan.simpleloading

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kr.co.younhwan.simpleloading.ui.theme.SimpleLoadingDialogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            SimpleLoadingDialogTheme {
                val state = remember {
                    mutableStateOf(true)
                }

                SimpleLoading(state)
            }
        }
    }
}