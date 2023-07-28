package com.egorro.etlab.fragments

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.egorro.etlab.R
import com.egorro.etlab.fragments.elements.AnnotatedText
import com.egorro.etlab.fragments.elements.ClickableTextE
import com.egorro.etlab.fragments.elements.DividerE
import com.egorro.etlab.fragments.elements.OutlinedTextFieldE
import com.egorro.etlab.fragments.elements.SpacerE
import com.egorro.etlab.fragments.elements.TextE
import com.egorro.etlab.tools.l

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShowFragment() {
    Surface(modifier = Modifier.fillMaxSize()) {
        LoginFragment()
    }
}

@Composable
fun LoginFragment() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        ImageBlock()
        LoginBlock()
    }
}

@Composable
fun LoginBlock() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(PaddingValues(start = 24.dp, end = 24.dp, top = 28.dp))
    ) {

        TextE(
            resId = R.string.welcome, style = MaterialTheme.typography.displayMedium
        )

        SpacerE()

        OutlinedTextFieldE(
            placeholderResId = R.string.email_address,
        )

        SpacerE()

        OutlinedTextFieldE(
            placeholderResId = R.string.password,
            trailingIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Outlined.Visibility,
                        contentDescription = stringResource(id = R.string.show_password)
                    )
                }
            },
        )

        SpacerE()

        ClickableTextE(
            annotatedTexts = arrayOf(
                AnnotatedText(
                    resId = R.string.forgot_password, tag = "fp",
                    style = SpanStyle(color = Color.Blue), onClick = { l("fp") }),
            )
        )


        SpacerE()

        Button(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
            onClick = {}
        ) {
            TextE(
                resId = R.string.login,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        SpacerE()

        ClickableTextE(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            annotatedTexts = arrayOf(
                AnnotatedText(resId = R.string.not_a_member),
                AnnotatedText(
                    resId = R.string.register_now, tag = "rn",
                    style = SpanStyle(color = Color.Blue), onClick = { l("Register now") }),
            )
        )

        DividerE()

        SpacerE()

        TextE(resId = R.string.or_continue_with)

        LoginWithGoogleAppleFacebook({ l() }, { l() }, { l() })
    }
}

@Composable
fun ImageBlock() {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp),
        painter = painterResource(id = R.drawable.img_cover),
        contentDescription = stringResource(id = R.string.cont_desc__main_image)
    )
}

@Composable
fun LoginWithGoogleAppleFacebook(
    onGoogleClick: () -> Unit,
    onAppleClick: () -> Unit,
    onFacebookClick: () -> Unit,
) {
    SpacerE()

    Box(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.align(Alignment.Center),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                modifier = Modifier.clickable { onGoogleClick.invoke() },
                painter = painterResource(id = R.drawable.google_button),
                contentDescription = stringResource(id = R.string.google),
            )
            Image(
                modifier = Modifier.clickable { onAppleClick.invoke() },
                painter = painterResource(id = R.drawable.apple_button),
                contentDescription = stringResource(id = R.string.apple)
            )
            Image(
                modifier = Modifier.clickable { onFacebookClick.invoke() },
                painter = painterResource(id = R.drawable.facebook_button),
                contentDescription = stringResource(id = R.string.facebook)
            )
        }
    }

    SpacerE()
}
