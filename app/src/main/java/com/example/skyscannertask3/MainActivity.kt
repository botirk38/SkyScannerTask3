package com.example.skyscannertask3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.skyscanner.backpack.compose.card.BpkCard
import net.skyscanner.backpack.compose.card.BpkCardCorner
import com.example.skyscannertask3.ui.theme.SkyScannerTask3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SkyScannerTask3Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FlightInfoCard(
                        flightNumber = "AB123",
                        departureCode = "XYZ",
                        departureTime = "08:00",
                        arrivalCode = "ABC",
                        arrivalTime = "10:00"
                    )
                }
            }
        }
    }
}

@Composable
fun FlightInfoCard(
    flightNumber: String,
    departureCode: String,
    departureTime: String,
    arrivalCode: String,
    arrivalTime: String,
    modifier: Modifier = Modifier
) {
    BpkCard(modifier = modifier.padding(16.dp), corner = BpkCardCorner.Large) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Flight Number: $flightNumber", style = MaterialTheme.typography.titleLarge)
            Text(text = "Departure: $departureCode at $departureTime", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Arrival: $arrivalCode at $arrivalTime", style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FlightInfoCardPreview() {
    SkyScannerTask3Theme {
        FlightInfoCard(
            flightNumber = "AB123",
            departureCode = "XYZ",
            departureTime = "08:00",
            arrivalCode = "ABC",
            arrivalTime = "10:00"
        )
    }
}
