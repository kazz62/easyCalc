package com.example.easycalc.HomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.easycalc.R
import com.example.easycalc.ui.theme.FieldBack
import com.example.easycalc.ui.theme.FieldHint
import com.example.easycalc.ui.theme.LightGreen

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    var playerName by remember { mutableStateOf("") }

    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            Row {
                Image(
                    painter = painterResource(id = R.drawable.ic_logo),
                    contentDescription = "Logo de l'application",
                    modifier = Modifier
                        .size(64.dp)
                        .alignByBaseline()
                )
                Text(
                    text = "Mental Calc",
                    style = TextStyle(
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    ),
                    modifier = Modifier.padding(16.dp)
                )
            }

            Spacer(modifier = Modifier.height(80.dp))

            TextBar(
                hint = "Nickname",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(
                        FieldBack,
                        shape = RoundedCornerShape(10.dp)
                    ),
                onSearch = { nickname ->
                    playerName = nickname
                }
            )

            Spacer(modifier = Modifier.height(80.dp))

            Button(
                onClick = { navController.navigate("menu_screen/$playerName") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(128.dp)
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = LightGreen,
                    contentColor = Color.White
                )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Continue",
                        style = TextStyle(
                            fontSize = 24.sp
                        )
                    )
                    Image(
                        painter = painterResource(id = R.drawable.arrow),
                        contentDescription = "Image flèche",
                        modifier = Modifier
                            .size(48.dp)
                            .alignByBaseline()
                            .padding(start = 8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun TextBar(
    modifier: Modifier = Modifier,
    hint: String = "",
    onSearch: (String) -> Unit = {}
) {
    var text by remember {
        mutableStateOf("")
    }

    val isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }
    Box(modifier = modifier) {
        Row {
            Box(
                modifier = Modifier
                    .size(92.dp)
                    .background(
                        LightGreen,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .alignByBaseline()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_person),
                    contentDescription = "Image utilisateur",
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            BasicTextField(
                value = text,
                onValueChange = {
                    text = it
                    onSearch(it)
                },
                maxLines = 1,
                singleLine = true,
                textStyle = TextStyle(color = Color.Black, fontSize = 48.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 12.dp),
                decorationBox = { innerTextField ->
                    if (isHintDisplayed && text.isEmpty()) {
                        Text(
                            text = hint,
                            maxLines = 1,
                            modifier = Modifier
                                .fillMaxWidth(),
                            fontSize = 48.sp,
                            color = FieldHint
                        )
                    }
                    innerTextField()
                },
            )
        }
    }
}