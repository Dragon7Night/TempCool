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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tempcool.R


data class UsuarioVal(
    val correo : String,
    val contrasena : String
)
@Composable
fun Login(navController : NavController? = null) {

    // Variables de los campos
    var correo by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }

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
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
    ){
            TextButton(
                onClick = {navController?.navigate("home")}
            ){
                Text(text = "Home")
            }
            Spacer(modifier = Modifier.height(6.dp))

            Image(
            painter = logoApp,
            contentDescription = "Logo App",
            modifier = Modifier.size(300.dp)
        )
            Spacer(modifier = Modifier.height(25.dp))

            Text(
                text = "Inicio de sesión",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Formulario del correo electrónico
            OutlinedTextField(
                value = correo,
                onValueChange = {correo = it},
                label = { Text(text = "Correo electrónico")},
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Formulario de la contraseña
            OutlinedTextField(
                value = contrasena,
                onValueChange = {contrasena  =  it},
                label = {Text(text = "Contraseña")},
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Boton de inicio de sesion
            Button(
                onClick = {
                    val usuarioVal = UsuarioVal(correo, contrasena)
                    validarDataUser(usuarioVal)
                    navController?.navigate("home") },
                modifier = Modifier.fillMaxWidth().height(50.dp),
                                colors = ButtonDefaults.buttonColors(
                    containerColor = btnColorCherry,
                    contentColor = btnColorWhite
                )
            ) {Text(text = "Iniciar sesión") }

            Spacer(modifier = Modifier.height(7.dp))

            TextButton(
                onClick = {navController?.navigate("register")},
                modifier = Modifier.fillMaxWidth().height(50.dp)
            ){Text(text = "¿Aun no tines una cuenta creada? Registrate")}

        }}}


fun validarDataUser(usuarioVal : UsuarioVal){
    if(usuarioVal.correo.isEmpty() || usuarioVal.contrasena.isEmpty()){
    println("Los campos se encuentran vacios")
    }else{
        println("El usuario fue validado")
        println("Credenciales Correo: ${usuarioVal.correo} Contraseña: ${usuarioVal.contrasena}")
    }
}


