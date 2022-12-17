package kr.co.younhwan.simpleloading

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.airbnb.lottie.compose.*

internal const val ANIMATION_TIME = 500L

@Composable
fun SimpleLoading(
    openDialogCustom: MutableState<Boolean>,
    clickableBackground: Boolean = false, // 배경을 클릭했을 때 다이얼로그가 닫히는지
    clickableClose: Boolean = true, // 닫기 버튼을 클릭할 수 있는지
    onClose: () -> Unit = { openDialogCustom.value = !openDialogCustom.value }
) {
    if (openDialogCustom.value) {
        Dialog(
            onDismissRequest = {
                if (clickableBackground) openDialogCustom.value = false
            }
        ) {
            SimpleLoadingUI(
                clickableClose = clickableClose,
                onClose = onClose
            )
        }
    }
}

@Composable
fun SimpleLoadingUI(
    modifier: Modifier = Modifier,
    clickableClose: Boolean,
    onClose: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(10.dp, 5.dp, 10.dp, 10.dp),
        elevation = 8.dp
    ) {
        Box(
            modifier
                .background(Color.White)
        ) {
            if (clickableClose) {
                IconButton(
                    modifier = Modifier
                        .padding(4.dp)
                        .align(Alignment.TopEnd),
                    onClick = onClose
                ) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = null)
                }
            }

            Column() {
                val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))
                val progress by animateLottieCompositionAsState(
                    composition = composition,
                    iterations = LottieConstants.IterateForever
                )
                LottieAnimation(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(275.dp),
                    composition = composition,
                    progress = { progress },
                )

                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Please wait ... ",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 5.dp, bottom = 24.dp)
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.body2,
                        overflow = TextOverflow.Ellipsis,
                        color = Color(0xFF4CBBA1),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

