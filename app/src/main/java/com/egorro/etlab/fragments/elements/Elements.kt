package com.egorro.etlab.fragments.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.egorro.etlab.R
import com.egorro.etlab.tools.l


const val tag = "CLICK_TXT"

@Preview(showBackground = true)
@Composable
fun PreviewElements() {
    Column {
        SpacerE()
        OutlinedTextFieldE(titleResId = R.string.name)
        SpacerE()
        ClickableTextE(
            annotatedTexts = arrayOf(
                AnnotatedText(resId = R.string.not_a_member),
                AnnotatedText(
                    resId = R.string.register_now, tag = "rn",
                    style = SpanStyle(color = Color.Blue), onClick = { l("Register now") }),
            )
        )
    }
}

@Composable
fun SpacerE(padding: Int = 24) {
    Spacer(modifier = Modifier.height(padding.dp))
}

@Composable
fun OutlinedTextFieldE(
    modifier: Modifier = Modifier,
    titleResId: Int? = null,
    titleStyle: TextStyle = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
    titleTextAlignment: TextAlign = TextAlign.Start,
    roundedCorner: Int = 12,
    value: String = "",
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    placeholderResId: Int = R.string.empty,
    onValueChange: (String) -> Unit = {},
    onIconClick: () -> Unit = {},
    icon: ImageVector? = null,
    iconContentDescription: Int = R.string.empty,
    trailingIcon: @Composable (() -> Unit) = {
        IconButton(onClick = onIconClick) {
            icon?.let {
                Icon(
                    imageVector = icon,
                    contentDescription = stringResource(id = iconContentDescription)
                )
            }
        }
    },
) {
    titleResId?.let {
        TextE(
            resId = titleResId,
            style = titleStyle,
            textAlign = titleTextAlignment
        )
        SpacerE(padding = 8)
    }
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(roundedCorner.dp),
        value = value,
        placeholder = { Text(text = stringResource(placeholderResId), style = textStyle) },
        onValueChange = onValueChange,
        trailingIcon = trailingIcon
    )
}

data class AnnotatedText(
    val resId: Int,
    val style: SpanStyle = SpanStyle(),
    val tag: String = "",
    val suffix: String? = " ",
    val onClick: (() -> Unit)? = null,
)

@Composable
fun ClickableTextE(
    modifier: Modifier = Modifier,
    vararg annotatedTexts: AnnotatedText,
) {
    val annotatedString = buildAnnotatedString {
        annotatedTexts.forEach { textBlock ->

            textBlock.onClick?.let { onClick ->
                pushStringAnnotation(
                    tag = textBlock.tag,
                    annotation = stringResource(id = textBlock.resId)
                )

                withStyle(
                    style = textBlock.style.copy(fontWeight = FontWeight.Bold)
                ) {
                    append(stringResource(textBlock.resId))
                }

                textBlock.suffix?.let { append(it) }

                pop()
            }
                ?: run {
                    withStyle(style = textBlock.style) {
                        append(stringResource(id = textBlock.resId))
                    }
                    textBlock.suffix?.let { append(it) }
                }
        }
    }
    Row(
        modifier = modifier
    ) {
        ClickableText(
            modifier = modifier,
            text = annotatedString,
            onClick = {
                annotatedString.getStringAnnotations(
                    start = it,
                    end = it
                ).firstOrNull()?.let { annot ->
                    l(annot)
                    annotatedTexts.firstOrNull { item -> item.tag == annot.tag }?.let { at ->
                        at.onClick?.invoke()
                    }
                }
            }
        )
    }
}

@Composable
fun DividerE(
    modifier: Modifier = Modifier,
    color: Color = Color.LightGray,
    thickness: Int = 0,
) {
    Divider(
        modifier = modifier.padding(top = 24.dp),
        color = color,
        thickness = thickness.dp
    )
}