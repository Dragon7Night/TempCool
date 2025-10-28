package com.example.tempcool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tempcool.Vistas.DataTemp
import com.example.tempcool.Vistas.Home
import com.example.tempcool.Vistas.Login
import com.example.tempcool.Vistas.Register
import com.example.tempcool.Vistas.Opciones
import com.example.tempcool.ui.theme.TempCoolTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth


class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            auth = Firebase.auth
            TempCoolTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)){
                        NavHost(navController = navController, startDestination = "home"){
                            composable("home"){Home(navController)}
                            composable("login"){Login(navController,auth)}
                            composable("register"){Register(navController,auth)}
                            composable("options"){Opciones(navController)}
                            composable("dataTemp"){ DataTemp(navController) }
                        }
                        }
                    }
                }
            }
        }
    }

