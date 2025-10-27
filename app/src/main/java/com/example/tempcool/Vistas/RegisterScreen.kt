package com.example.tempcool.Vistas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tempcool.R
import com.google.firebase.auth.FirebaseAuth


// clases la cual permite crear un objeto para almacenar los datos del usuario
data class Usuario(
    val nombre: String,
    val correo: String,
    val contrasena: String
)


@Composable
fun Register(navController: NavController? = null, auth: FirebaseAuth){

    // Variables de los campos
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }
    var confirmarContrasena by remember { mutableStateOf("") }

    // Variables de colores
    val fondoApp = colorResource(id = R.color.bg_blue_deep)
    val btnColorCherry = colorResource(id = R.color.btn_cherry)
    val btnColorWhite = colorResource(id = R.color.white)
    val btnColorBlack = colorResource(id = R.color.black)

    // Variables de imagenes
    val logoApp = painterResource(id = R.drawable.logo)

    Box(
        modifier = Modifier.fillMaxSize().background(fondoApp).padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        TextButton(
            onClick = {navController?.navigate("home")},
            modifier = Modifier.align ( Alignment.TopEnd )
            ){
                Text(
                    text = "Home",
                    fontWeight = FontWeight.Bold,
                    color = btnColorWhite,
                    fontSize = MaterialTheme.typography.headlineSmall.fontSize
                )
            }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
            painter = logoApp,
            contentDescription = "Logo App",
            modifier = Modifier.size(300.dp)
        )
            Spacer(modifier = Modifier.height(16.dp))

            // Titulo de la vista
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
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Formulario para el correo
            OutlinedTextField(
                value = correo,
                onValueChange = { correo = it },
                label = { Text("Correo electrónico") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Formulario de contraseña
            OutlinedTextField(
                value = contrasena,
                onValueChange = { contrasena = it },
                label = { Text("Contraseña") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Confirmacion de contraseña
            OutlinedTextField(
                value = confirmarContrasena,
                onValueChange = { confirmarContrasena = it },
                label = { Text("Confirmar contraseña") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Boton de registro
            Button(
                onClick = {
                    val usuario = Usuario(nombre, correo, contrasena)
                    guardarDataUser(usuario)
                    navController?.navigate("options")
                },
                modifier = Modifier.fillMaxWidth().height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = btnColorCherry,
                    contentColor = btnColorWhite
                )
            ) {
                Text("Registrarse")
            }

            Spacer(modifier = Modifier.height(7.dp))

            // Boton de inicio de sesión, en caso de que el usuario ya tenga una cuenta
            TextButton(
                onClick = { navController?.navigate("login") },
                modifier = Modifier.fillMaxWidth().height(50.dp)
            ) {
                Text("¿Tienes ya una cuenta creada?",
                color = btnColorWhite)
            }
        }
    }
}

fun guardarDataUser(usuario: Usuario) {
    // Aqui se puede colocar todo lo que mandara en la DB
    println("Usuario guardado: $usuario")
    // Este print sale en el LogCat
}