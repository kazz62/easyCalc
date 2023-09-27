package com.example.easycalc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.easycalc.HomeScreen.HomeScreen
import com.example.easycalc.againstTheWatch.AgainstTheWatchScreen
import com.example.easycalc.menu.MenuScreen
import com.example.easycalc.ui.theme.EasyCalcTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EasyCalcTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "home_screen"
                ) {
                    // Home
                    composable("home_screen") {
                        HomeScreen(navController = navController)
                    }

                    // Menu
                    composable("menu_screen/{playerName}",
                        arguments = listOf(navArgument("playerName") {
                            type = NavType.StringType
                        }
                        )
                    ) {
                        val playerName = remember {
                            it.arguments?.getString("playerName")
                        }
                        MenuScreen(
                            playerName = playerName ?: "",
                            navController = navController
                        )
                    }

                    // Against the watch
                    composable("against_the_watch/{playerName}",
                        arguments = listOf(navArgument("playerName") {
                            type = NavType.StringType
                        }
                        )
                    ) {
                        val playerName = remember {
                            it.arguments?.getString("playerName")
                        }
                        AgainstTheWatchScreen(
                            playerName = playerName ?: "",
                            navController = navController
                        )
                    }

                    // EasyCalc
                }
            }
        }
    }
}