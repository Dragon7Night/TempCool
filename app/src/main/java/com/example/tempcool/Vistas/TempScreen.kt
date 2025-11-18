package com.example.tempcool.Vistas


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tempcool.R

// Funcion de bloque de sensores
@Composable
fun SensorBlock(
    icon: Painter,
    title: String,
    value: String,
    textColor: Color
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            painter = icon,
            contentDescription = title,
            modifier = Modifier.size(130.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = title,
            color = textColor,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = value,
            color = textColor,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.SemiBold
        )
    }
}


// Funcion principal
@Composable
fun DataTemp(navController: NavController? = null) {
    // Variables de colores
    val fondoApp = colorResource(id = R.color.bg_blue_deep)
    val btnColorWhite = colorResource(id = R.color.white)

    // Variables de imagenes
    val tempSen1App = painterResource(id = R.drawable.temp1)
    val tempSen2App = painterResource(id = R.drawable.temp2)
    val humSen2App = painterResource(id = R.drawable.hum1)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(fondoApp)
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        // Boton de regreso al menú
        TextButton(
            onClick = { navController?.navigate("options") },
            modifier = Modifier.align(Alignment.TopStart)
        ) {
            Text(
                text = "Menú",
                fontWeight = FontWeight.Bold,
                color = btnColorWhite,
                fontSize = MaterialTheme.typography.headlineSmall.fontSize
            )
        }

        Column(
            modifier = Modifier.fillMaxSize()
                .padding(vertical = 42.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Entrada de variables
            val numTempS1 = "25"
            val numTempS2 = "24"
            val numHumS2 = "17"

            // Formateo de las variables
            val valueTempS1 = "${numTempS1} °C"
            val valueTempS2 = "${numTempS2} °C"
            val humSen2 = "${numHumS2} %"

            // Titulo
            Text(
                text = "Temperatura del dispositivo",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                color = btnColorWhite,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.weight(1f))

            // Bloque N1
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                SensorBlock(
                    icon = tempSen1App,
                    title = "Temperatura Sensor N°1",
                    value = valueTempS1,
                    textColor = btnColorWhite
                )}
            Spacer(modifier = Modifier.height(16.dp))

            // Bloque N2
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                SensorBlock(
                    icon = tempSen2App,
                    title = "Temperatura Sensor N°2",
                    value = valueTempS2,
                    textColor = btnColorWhite
                )}
            Spacer(modifier = Modifier.height(16.dp))
            // Bloque N3
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                SensorBlock(
                icon = humSen2App,
                title = "Humedad",
                value = humSen2,
                textColor = btnColorWhite
                )}
        }
    }
}


