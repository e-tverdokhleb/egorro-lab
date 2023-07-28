package com.egorro.etlab.fragments

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.egorro.etlab.R
import com.egorro.etlab.fragments.elements.AnnotatedText
import com.egorro.etlab.fragments.elements.ClickableTextE
import com.egorro.etlab.fragments.elements.OutlinedTextFieldE
import com.egorro.etlab.fragments.elements.SpacerE
import com.egorro.etlab.fragments.elements.TextE
import com.egorro.etlab.tools.l

@Preview
@Composable
fun showFragment() {
    Surface(modifier = Modifier.fillMaxSize()) {
        SignUpFragment()
    }
}


@Composable
fun SignUpFragment() {
    Column(
        modifier = Modifier
            .padding(24.dp)
            .verticalScroll(rememberScrollState())
    ) {

        TextE(
            resId = R.string.sign_up,
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.ExtraBold),
            textAlign = TextAlign.Start
        )

        SpacerE(padding = 8)

        TextE(
            resId = R.string.create_an_account_to_get_started,
            textAlign = TextAlign.Start
        )

        SpacerE(padding = 16)

        OutlinedTextFieldE(
            titleResId = R.string.name,
            placeholderResId = R.string.Your_Name
        )

        SpacerE(padding = 16)

        OutlinedTextFieldE(
            titleResId = R.string.Email_Address,
            placeholderResId = R.string.name_email_com
        )

        SpacerE(padding = 16)

        OutlinedTextFieldE(
            titleResId = R.string.Password,
            placeholderResId = R.string.Create_a_password,
            icon = Icons.Outlined.Visibility
        )

        SpacerE()

        OutlinedTextFieldE(
            placeholderResId = R.string.confirm_password,
            icon = Icons.Outlined.Visibility
        )

        SpacerE()

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = false, onCheckedChange = {})
            ClickableTextE(
                annotatedTexts = arrayOf(
                    AnnotatedText(resId = R.string.ive_read_and_agree_with_the),
                    AnnotatedText(
                        resId = R.string.terms_and_conditions, tag = "tnc",
                        style = SpanStyle(color = Color.Blue), onClick = { l("Terms and Conditions") }),
                    AnnotatedText(resId = R.string.and_the),
                    AnnotatedText(
                        resId = R.string.privacy_policy, tag = "pp",
                        style = SpanStyle(color = Color.Blue), onClick = { l("Privacy Policy.") }),
                ),
            )
        }

        SpacerE()
    }
}