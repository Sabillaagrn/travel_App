package com.example.travelapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.travelapp.ui.theme.blue1
import com.example.travelapp.ui.theme.blue2
import com.example.travelapp.ui.theme.blue3

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val poppinsFontFamily = FontFamily(
    Font(googleFont = GoogleFont("Poppins"), fontProvider = provider, weight = FontWeight.Normal),
    Font(googleFont = GoogleFont("Poppins"), fontProvider = provider, weight = FontWeight.Bold),
    Font(googleFont = GoogleFont("Poppins"), fontProvider = provider, weight = FontWeight.SemiBold)
)


@Composable
fun HomeScreen(navController: NavController) {
    var selectedTab by remember { mutableStateOf("Indonesia") }
    val destinations = getDestinations(selectedTab)

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.background1), // Replace with your image resource
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            item {
                Header()
                Spacer(modifier = Modifier.height(16.dp))
                TabRow(selectedTab) { tab ->
                    selectedTab = tab
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
            items(destinations) { destination ->
                DestinationItem(destination)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}


@Composable
fun Header() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        // Centered "Hai Sabilla!" Text at the top
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Hai Sabilla!",
                fontSize = 20.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Bold,
                color = blue3
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Row containing the rest of the content
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                    Text(
                        text = "Mau",
                        fontSize = 35.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = blue1
                    )
                    Text(
                        text = "Liburan",
                        fontSize = 35.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = blue1
                    )
                    Text(
                        text = "Kemana",
                        fontSize = 35.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = blue1
                    )
                    Text(
                        text = "Nih?",
                        fontSize = 35.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = blue1
                    )
                }
            }

            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon3), // Replace with your image resource
                    contentDescription = "Custom Icon",
                    modifier = Modifier
                        .size(130.dp)
                        .clip(RoundedCornerShape(300.dp))
                )
            }
        }
    }
}

@Composable
fun TabRow(selectedTab: String, onTabSelected: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        val tabs = listOf("Indonesia", "Jepang", "Amerika", "Afrika")
        tabs.forEach { tab ->
            Box(
                modifier = Modifier
                    .background(
                        color = if (tab == selectedTab) blue1 else Color.LightGray,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(8.dp)
                    .clickable { onTabSelected(tab) }
            ) {
                Text(
                    text = tab,
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

data class Destination(val name: String, val description: String, val imageRes: Int)

@Composable
fun DestinationItem(destination: Destination) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(blue1, blue2, blue3)
                )
            )
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = destination.imageRes),
            contentDescription = destination.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(128.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp)
        ) {
            Text(
                text = destination.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row {
                repeat(3) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Review star",
                        modifier = Modifier.size(16.dp),
                        tint = Color.Yellow
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = destination.description,
                fontSize = 12.sp,
                color = Color.White
            )
        }
    }
}

fun getDestinations(selectedTab: String): List<Destination> {
    return when (selectedTab) {
        "Indonesia" -> listOf(
            Destination("Bali", "Kota Denpasar merupakan kota terbesar kedua di wilayah...", R.drawable.bali),
            Destination("Bukittinggi", "Kota Bukittinggi merupakan salah satu pusat pembang...", R.drawable.bukit),
            Destination("Yogyakarta", "Kota Yogyakarta merupakan pusat pemerintahan Daerah...", R.drawable.yogyakarta),
            Destination("Bandung", "Kota Bandung adalah kota metropolitan terbesar di provinsi Jawa Barat...", R.drawable.bandung)
        )
        "Jepang" -> listOf(
            Destination("Tokyo", "Tokyo adalah ibu kota Jepang yang terkenal dengan...", R.drawable.tokyo),
            Destination("Kyoto", "Kyoto dikenal dengan kuil-kuil klasik Buddha, taman-taman...", R.drawable.kyoto),
            Destination("Osaka", "Osaka adalah kota besar yang terkenal dengan modern...", R.drawable.osaka),
            Destination("Gunung Fuji", "Gunung Fuji adalah gunung berapi aktif yang terakhir meletus pada tahun 1707 hingga 1708 ...", R.drawable.fuji)
        )
        "Amerika" -> listOf(
            Destination("New York", "New York adalah kota terbesar di Amerika Serikat...", R.drawable.newyork),
            Destination("Los Angeles", "Los Angeles dikenal sebagai pusat industri film...", R.drawable.los_angeles),
            Destination("Chicago", "Chicago adalah kota terbesar di Illinois dan...", R.drawable.chicago),
            Destination("San Francisco","Jembatan Golden Gate adalah jembatan gantung yang membentang di Golden Gate , selat selebar satu mil...", R.drawable.san_francisco)
        )
        "Afrika" -> listOf(
            Destination("Cape Town", "Cape Town adalah kota pantai di Afrika Selatan...", R.drawable.cape_town),
            Destination("Cairo", "Cairo adalah ibu kota Mesir dan terkenal dengan...", R.drawable.cairo),
            Destination("Nairobi", "Nairobi adalah ibu kota Kenya yang terkenal dengan...", R.drawable.nairobii),
            Destination("Kilimanjaro", "Puncak Kilimanjaro sekaligus merupakan puncak tertinggi di Afrika, dengan ketinggian 5.895 meter di atas permukaan laut...", R.drawable.kilimanjaro)
        )
        else -> emptyList()
    }
}
