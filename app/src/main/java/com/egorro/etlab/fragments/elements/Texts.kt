package com.egorro.etlab.fragments.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.egorro.etlab.R


@Preview(showBackground = true)
@Composable
fun PreviewText() {
    Column {
        TextE(resId = R.string.welcome)
    }
}

@Composable
fun TextE(
    modifier: Modifier = Modifier,
    resId: Int,
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    textAlign: TextAlign = TextAlign.Center,
) {
    Text(
        modifier = modifier.fillMaxWidth(),
        text = stringResource(id = resId),
        style = style,
        textAlign = textAlign
    )
}
