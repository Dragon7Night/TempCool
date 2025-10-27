package com.example.tempcool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tempcool.Vistas.DataTemp
import com.example.tempcool.Vistas.Home
import com.example.tempcool.Vistas.Login
import com.example.tempcool.Vistas.Register
import com.example.tempcool.Vistas.Opciones
import com.example.tempcool.ui.theme.TempCoolTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TempCoolTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)){
                        NavHost(navController = navController, startDestination = "home"){
                            composable("home"){Home(navController)}
                            composable("login"){Login(navController)}
                            composable("register"){Register(navController)}
                            composable("options"){Opciones(navController)}
                            composable("dataTemp"){ DataTemp(navController) }
                        }
                        }
                    }

                }
            }
        }
    }

