package com.example.tempcool.Vistas

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Register(navController: NavController? = null){

    // el Box es como un div
    Box(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        contentAlignment = Alignment.Center
    ){
        Column(
            // permite realizar modificaciones en el elementos
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Permite crear un titulo
            Text(
                text = "Registro de la cuenta",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            // permite hacer un espacio entre los elementos
            Spacer(modifier = Modifier.height(32.dp))

            // Formulario para el nombre
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "Nombre Completo") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // Formulario para el apellido
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "Apellido") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Formulario para el email
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "Correo electronico") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Formulario de contraseña
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "Contraseña") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Confirmacion de contraseña
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "Confirmar contraseña") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Boton de registro
            Button(
                onClick = {navController?.navigate("home") },
                modifier = Modifier.fillMaxWidth().height(50.dp)
            ) { Text(text = "Registrarse") }
            Spacer(modifier = Modifier.height(7.dp))

            // Boton de inicio de sesión, en caso de que el usuario ya tenga una cuenta
            TextButton(
                onClick = { navController?.navigate("login") },
                modifier = Modifier.fillMaxWidth().height(50.dp)
            ) { Text(text = "¿Tienes ya una cuenta creada?") }









        }}}
