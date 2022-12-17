package kr.co.younhwan.simpleloading

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

@Composable
fun SimpleLoading(
    openDialogCustom: MutableState<Boolean>,
    clickableBackground: Boolean = false, // 배경을 클릭했을 때 다이얼로그가 닫히는지
    clickableClose: Boolean = true, // 닫기 버튼을 클릭할 수 있는지
    color: Color = Color.White, // 배경색
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
                color = color,
                onClose = onClose
            )
        }
    }
}

@Composable
fun SimpleLoadingUI(
    modifier: Modifier = Modifier,
    clickableClose: Boolean,
    color: Color,
    onClose: () -> Unit
) {
    Card(
        elevation = 8.dp,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
    ) {
        Box(
            modifier.background(color)
        ) {
            // 닫기 버튼
            if (clickableClose) {
                IconButton(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp),
                    onClick = onClose
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null,
                        tint = Color(0xB3656565)
                    )
                }
            }

            // 로딩 애니메이션, 텍스트
            Column(
                modifier = modifier.padding(horizontal = 8.dp)
            ) {
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

                Text(
                    text = "Please wait...",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .paddingFromBaseline(top = 8.dp, bottom = 32.dp),
                    style = MaterialTheme.typography.body2,
                    color = Color(0xFF4CBBA1)
                )
            }
        }
    }
}

