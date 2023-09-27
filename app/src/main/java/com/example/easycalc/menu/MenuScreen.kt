package com.example.easycalc.menu

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.example.easycalc.ui.theme.LightGreen
import com.example.easycalc.ui.theme.buttonImg

@Composable
fun MenuScreen(
    playerName: String,
    navController: NavController,
    viewModel: MenuViewModel = hiltViewModel()
) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {

        val triplets = listOf(
            Triple(R.drawable.ic_watch, "Against the watch", "against_the_watch/$playerName"),
            Triple(R.drawable.ic_calc, "Easy calc", "home_screen"),
            Triple(R.drawable.ic_medal, "Hard calc", "home_screen"),
            Triple(R.drawable.ic_mask, "Hell calc", "home_screen")
        )

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))

            Row {
                Image(
                    painter = painterResource(id = R.drawable.ic_logo),
                    contentDescription = "Logo of the application",
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

            MenuButtons(triplets = triplets, navController = navController)
        }
    }
}

@Composable
fun MenuButtons(triplets: List<Triple<Int, String, String>>, navController: NavController) {
    Column {
        triplets.forEach { (identifiant, chaine, route) ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(16.dp))

                Box(
                    modifier = Modifier
                        .size(85.dp)
                        .background(
                            buttonImg,
                            shape = RoundedCornerShape(10.dp)
                        )
                ) {
                    Image(
                        painter = painterResource(id = identifiant),
                        contentDescription = "Logo to : $chaine",
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
                Button(
                    onClick = { navController.navigate(route) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = LightGreen,
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = chaine,
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        ),
                        maxLines = 1,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }

}