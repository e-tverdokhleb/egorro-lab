package com.egorro.etlab.fragments

import android.util.Log
import android.widget.ImageButton
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
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.egorro.etlab.R
import com.egorro.etlab.fragments.elements.Text24
import com.egorro.etlab.fragments.elements.TextDefault
import com.egorro.etlab.fragments.elements.TextWithClickable

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
            .fillMaxWidth()
            .padding(PaddingValues(start = 24.dp, end = 24.dp, top = 28.dp))
    ) {

        Text24(resId = R.string.welcome)

        OutlinedTextField(
            modifier = Modifier
                .padding(top = 18.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            value = "",
            placeholder = { Text(text = stringResource(R.string.email_address)) },
            onValueChange = {}
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(top = 14.dp)
                .fillMaxWidth(),
            value = "",
            onValueChange = {},
            shape = RoundedCornerShape(12.dp),
            placeholder = { Text(text = stringResource(R.string.password)) },
            trailingIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Outlined.Visibility,
                        contentDescription = stringResource(id = R.string.show_password)
                    )
                }
            },
        )

        ClickableText(
            modifier = Modifier.padding(top = 16.dp),
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Blue, fontWeight = FontWeight.Bold)) {
                    append(stringResource(id = R.string.forgot_password))
                }
            },
            onClick = { }
        )

        Button(
            modifier = Modifier
                .padding(top = 28.dp)
                .fillMaxWidth()
                .height(55.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
            onClick = {}
        ) {
            TextDefault(
                resId = R.string.login,
                fontSize = 14
            )
        }

        TextWithClickable(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 18.dp),
            regularTextResId = R.string.not_a_member,
            clickableTextResId = R.string.register_now,
            onClick = { text ->
                Log.d("tag", "clicked: $text")
            }
        )

        Divider(
            modifier = Modifier.padding(top = 24.dp),
            color = Color.LightGray,
            thickness = 0.dp
        )

        TextDefault(
            modifier = Modifier.padding(top = 28.dp),
            resId = R.string.or_continue_with,
        )

        LoginWithGoogleAppleFacebook({}, {}, {})
    }
}

@Composable
fun ImageBlock() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp)
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.img_cover),
            contentDescription = stringResource(id = R.string.cont_desc__main_image)
        )
    }
}

@Composable
fun LoginWithGoogleAppleFacebook(
    onGoogleClick: () -> Unit,
    onAppleClick: () -> Unit,
    onFacebookClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, bottom = 48.dp)
    ) {
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
}
