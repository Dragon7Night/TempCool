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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tempcool.R


@Composable
fun Opciones(navController: NavController? = null) {
    // Variables de colores
    val fondoApp = colorResource(id = R.color.bg_blue_deep)
    val btnColorCherry = colorResource(id = R.color.btn_cherry)
    val btnColorWhite = colorResource(id = R.color.white)
    val btnColorBlack = colorResource(id = R.color.black)
    val btnColorGreen = colorResource(id = R.color.btn_green_pastel)

    // Variables de imagenes
    val logoApp = painterResource(id = R.drawable.logo)
    val tempApp = painterResource(id = R.drawable.temp)

    Box(
        modifier = Modifier.fillMaxSize().background(fondoApp).padding(24.dp),
        contentAlignment = Alignment.Center

    ){
        Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Menú de opciones",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(20.dp))
            Image(
            painter = tempApp,
            contentDescription = "Logo de temperatura",
            modifier = Modifier.size(250.dp)
        )
            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = { navController?.navigate("dataTemp") },
                modifier = Modifier.fillMaxWidth().height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = btnColorCherry,
                    contentColor = btnColorWhite)
            ) {
                Text(text = "Monitorear temperatura")

            }

        Spacer(modifier = Modifier.weight(1f))


            Text(text="¿Necesitas bajar la temperatura del dispositivo?",
                color = btnColorWhite)

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { navController?.navigate("home") },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = btnColorGreen,
                contentColor = btnColorBlack
            )
        ) {
            Text(text = "Encender Ventiladores")
        }
            Image(
            painter = logoApp,
            contentDescription = "Logo App",
            modifier = Modifier.size(250.dp)
        )
    }
    }

}