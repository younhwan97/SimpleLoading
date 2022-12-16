package kr.co.younhwan.simpleloadingdialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.airbnb.lottie.compose.*

@Composable
fun SimpleLoadingDialog(openDialogCustom: MutableState<Boolean>) {
    Dialog(onDismissRequest = { openDialogCustom.value = false }) {
        SimpleLoadingDialogUI(openDialogCustom = openDialogCustom)
    }
}

//Layout
@Composable
fun SimpleLoadingDialogUI(modifier: Modifier = Modifier, openDialogCustom: MutableState<Boolean>) {
    Card(
        //shape = MaterialTheme.shapes.medium,
        shape = RoundedCornerShape(10.dp),
        // modifier = modifier.size(280.dp, 240.dp)
        modifier = Modifier.padding(10.dp, 5.dp, 10.dp, 10.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier
                .background(Color.White)
        ) {

            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.image2))
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

            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Please wait ... ",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 30.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.body2,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = Color(0xFF4CBBA1),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

