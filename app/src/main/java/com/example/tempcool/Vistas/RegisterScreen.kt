package com.example.tempcool.Vistas

import android.content.Context
import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
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
import androidx.compose.ui.platform.LocalContext
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


@Composable
fun Register(navController: NavController? = null, auth: FirebaseAuth){

    // Variables de los campos
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }
    var confirmarContrasena by remember { mutableStateOf("") }
    val context = LocalContext.current


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
            val isLoading = false
            Button(
                onClick = {
                    var isLoading = true
                    validarRegistro(nombre, correo, contrasena, confirmarContrasena, context, auth,
                        onSuccess = {
                            isLoading = false
                            navController?.popBackStack()
                            navController?.navigate("login")
                        })},
                enabled = !isLoading,
                modifier = Modifier.fillMaxWidth().height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = btnColorCherry,
                    contentColor = btnColorWhite
                )
            ) {
                Text(if (isLoading) "Registrando..." else "Registrarse")
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

private fun ColumnScope.validarRegistro(
    nombre: String,
    correo: String,
    contrasena: String,
    confirmarContrasena: String,
    context: Context,
    auth: FirebaseAuth,
    onSuccess: () -> Unit
){

    // Validar si los campos se encuentra vacios
    if (nombre.isBlank() || correo.isBlank() || contrasena.isBlank() || confirmarContrasena.isBlank()){
        Toast.makeText(context, "Ingrese todos los campos", Toast.LENGTH_SHORT).show()
        return
    }

    // Validar que el formato dle correo sea valido
    if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()){
        Toast.makeText(context, "Correo invalido", Toast.LENGTH_SHORT).show()
        return
    }

    if (contrasena.length < 6) {
        Toast.makeText(context, "la contraseña no cumple con los caracteres requeridos", Toast.LENGTH_SHORT).show()
        return
    }

    if (contrasena != confirmarContrasena) {
        Toast.makeText(context, "no coinciden las contraseñas", Toast.LENGTH_SHORT).show()
        return
    }

    auth.createUserWithEmailAndPassword(correo, contrasena).addOnCompleteListener { task ->
        if (task.isSuccessful) {
            Toast.makeText(context, "registro exitoso", Toast.LENGTH_SHORT).show()
            onSuccess()
        } else {
            Toast.makeText(context, "registro fallido", Toast.LENGTH_SHORT).show()
        }
    }
}





