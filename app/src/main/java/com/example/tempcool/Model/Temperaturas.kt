package com.example.tempcool.Model

data class Temperatura(
    val id: String = "",
    val temp_dht11: Float = 0.0f,
    val hum_dht11: Float = 0.0f,
    val temp_lm35: Float = 0.0f,
    val fecha_registro: String = ""
)
