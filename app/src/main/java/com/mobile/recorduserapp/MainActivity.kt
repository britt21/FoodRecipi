package com.mobile.recorduserapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.mobile.recorduserapp.data.cons.ADDFOOD
import com.mobile.recorduserapp.data.cons.HOMESCREEN
import com.mobile.recorduserapp.ui.AddFood
import com.mobile.recorduserapp.ui.HomeScreen
import com.mobile.recorduserapp.ui.theme.RecordUserAppTheme
import com.mobile.recorduserapp.ui.theme.black
import com.mobile.recorduserapp.ui.theme.greyTextColor
import com.mobile.recorduserapp.ui.theme.litg
import com.mobile.recorduserapp.utils.textlit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecordUserAppTheme {
                val systemUiController = rememberSystemUiController()
                systemUiController.setSystemBarsColor(color = Color.White, darkIcons = false)

                val navController = rememberNavController()

                var selectedTab by remember { mutableStateOf(0) }
                val items = listOf("Home", "Generator", "Add", "Favourite", "Planner")
                val icons = listOf(
                   R.drawable.home,
                   R.drawable.gen,
                   R.drawable.add,
                   R.drawable.hart,
                   R.drawable.cal,
                )

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        NavigationBar(containerColor = Color.White) {
                            items.forEachIndexed { index, item ->
                                NavigationBarItem(

                                    selected = selectedTab == index,
                                    onClick = { selectedTab = index },
                                    icon = {
                                        Image(
                                            painter = painterResource(id = icons[index]),
                                            contentDescription = item,
                                            modifier = Modifier.size(24.dp),
                                            colorFilter = if (selectedTab == index) ColorFilter.tint(Color.Blue) else null
                                        )
                                    },
                                    label = {
                                         textlit(
                                            text = item,
                                            size = 11,
                                            color = black
                                        )
                                    }
                                )
                            }
                        }
                    }
                ) { innerPadding ->  // Ensure `innerPadding` is used
                    NavHost(
                        modifier = Modifier.padding(innerPadding), // Apply padding here
                        navController = navController,
                        startDestination = HOMESCREEN
                    ) {
                        composable(HOMESCREEN) {
                            HomeScreen(modifier = Modifier.fillMaxSize(), navController = navController) // Optional: Adjust if needed
                        }
                          composable(ADDFOOD) {
                            AddFood(modifier = Modifier.fillMaxSize(),navController) // Optional: Adjust if needed
                        }


                    }
                }

            }
        }
    }
}
