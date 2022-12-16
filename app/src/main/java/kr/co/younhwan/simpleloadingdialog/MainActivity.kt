package kr.co.younhwan.simpleloadingdialog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import kr.co.younhwan.simpleloadingdialog.ui.theme.SimpleLoadingDialogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            SimpleLoadingDialogTheme {
                val state = remember {
                    mutableStateOf(true)
                }

                SimpleLoadingDialog(state)
            }
        }
    }
}