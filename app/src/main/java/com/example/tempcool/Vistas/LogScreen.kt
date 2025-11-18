package com.example.tempcool.Vistas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tempcool.Model.Temperatura
import com.google.firebase.firestore.FirebaseFirestore


@Composable
fun LogTemperatura() {
    val db = FirebaseFirestore.getInstance()
    var logTemperaturas by remember { mutableStateOf(listOf<Temperatura>()) }

    // Leer datos de Firestore
    LaunchedEffect(Unit) {
        db.collection("temperatua")
            .addSnapshotListener { snapshot, _ ->
                if (snapshot != null) {
                    logTemperaturas = snapshot.toObjects(Temperatura::class.java)
                }
            }
    }

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("Log de registro de temperatura", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(16.dp))

        LazyColumn {
            items(logTemperaturas) { temp ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                ) {
                    Column(Modifier.padding(16.dp)) {
                        Text("Temperatura LM35: ${temp.temp_lm35}°C")
                        Text("Temperatura DH11: ${temp.temp_dht11}°C")
                        Text("Humedad DH11: ${temp.hum_dht11}%")
                    }
                }
            }
        }
    }
}
