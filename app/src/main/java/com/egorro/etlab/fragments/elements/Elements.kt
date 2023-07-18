package com.egorro.etlab.fragments.elements

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.egorro.etlab.R


const val tag = "CLICK_TXT"

@Preview(showBackground = true)
@Composable
fun Preview() {
    Column {
        Text24(resId = R.string.welcome)
        TextDefault(resId = R.string.welcome)
    }
}

@Composable
fun Text24(@StringRes resId: Int) {
    TextDefault(resId = resId, fontSize = 24)
}

@Composable
fun TextDefault(
    modifier: Modifier = Modifier,
    @StringRes resId: Int,
    text: String = "",
    fontSize: Int = 12,
    fontWeight: FontWeight = FontWeight.Normal,
    textAlign: TextAlign = TextAlign.Center,
) {
    Text(
        modifier = modifier.fillMaxWidth(),
        text = text.ifEmpty { stringResource(id = resId) },
        fontSize = fontSize.sp,
        fontWeight = fontWeight,
        textAlign = textAlign
    )
}

@Composable
fun TextWithClickable(
    modifier: Modifier = Modifier,
    @StringRes regularTextResId: Int,
    regularTextColor: Color = Color.Black,
    regularFontSize: Int = 12,
    regularFontWeight: FontWeight = FontWeight.Normal,
    @StringRes clickableTextResId: Int,
    clickableTextColor: Color = Color.Blue,
    clickableFontSize: Int = 12,
    clickableFontWeight: FontWeight = FontWeight.Normal,
    textAlign: TextAlign = TextAlign.Center,
    onClick: (String) -> Unit = {},
) {
    val annotatedText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = regularTextColor,
                fontSize = regularFontSize.sp,
                fontWeight = regularFontWeight
            )
        ) {
            append(stringResource(id = regularTextResId))
        }

        pushStringAnnotation(
            tag = tag,
            annotation = stringResource(id = clickableTextResId)
        )

        withStyle(
            style = SpanStyle(
                color = clickableTextColor,
                fontSize = clickableFontSize.sp,
                fontWeight = clickableFontWeight
            )
        ) {
            append(stringResource(clickableTextResId))
        }

        pop()
    }

    ClickableText(
        modifier = modifier,
        text = annotatedText,
        style = TextStyle(textAlign = textAlign),
        onClick = {
            annotatedText.getStringAnnotations(
                tag = tag,
                start = it,
                end = it
            ).firstOrNull()?.let { annot -> onClick.invoke(annot.item) }
        }
    )
}