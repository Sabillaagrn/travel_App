
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.travelapp.R
import com.example.travelapp.ui.theme.blue1
import com.example.travelapp.ui.theme.blue3
import com.example.travelapp.ui.theme.blue4

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SearchScreen(navController: NavHostController) {
    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    backgroundColor = Color.Black,
                    contentColor = blue4,
                    elevation = 0.dp
                ) {
                    Text(
                        text = "Explore",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(start = 16.dp),
                        color = blue4
                    )
                }
            }
        ) {
            ExploreScreen(navController)
        }
    }
}

@Composable
fun ExploreScreen(navController: NavHostController) {
    val places = listOf(
        Place("Amsterdam", "Netherlands", R.drawable.amsterdam),
        Place("Sydney", "Australia", R.drawable.sydney),
        Place("Bali", "France", R.drawable.bali),
        Place("Tokyo", "Japan", R.drawable.tokyo),
        Place("New York", "USA", R.drawable.newyork),
        Place("Bukittinggi", "Indonesia", R.drawable.bukit),
        Place("Kilimanjaro", "Afrika", R.drawable.kilimanjaro),
        Place("Los Angeles", "Amerika", R.drawable.los_angeles),
        Place("Osaka", "Japan", R.drawable.osaka),
        Place("Bandung", "Indonesia", R.drawable.bandung),
        Place("Chicago", "Amerika", R.drawable.chicago),
        Place("Cape Town", "Afrika", R.drawable.cape_town)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.background4), // Replace with your background image resource
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            var searchQuery by remember { mutableStateOf("") }
            val filteredPlaces = places.filter { place ->
                place.city.contains(searchQuery, ignoreCase = true)
            }

            BasicTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(color = blue4, RoundedCornerShape(8.dp))
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                singleLine = true,
                decorationBox = { innerTextField ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = android.R.drawable.ic_menu_search),
                            contentDescription = "Search Icon",
                            tint = blue1
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        if (searchQuery.isEmpty()) {
                            Text(text = "Search", color = blue1)
                        }
                        innerTextField()
                    }
                }
            )

            Spacer(modifier = Modifier.height(8.dp))
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(filteredPlaces) { place ->
                    PlaceCard(
                        navController = navController,
                        city = place.city,
                        country = place.country,
                        imageRes = place.imageRes,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun PlaceCard(navController: NavController, city: String, country: String, imageRes: Int, modifier: Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(color = blue4)
            .padding(8.dp)
            .clickable {
                // Navigate to DetailScreen when the place card is clicked
                navController.navigate("detail/${city}/${country}/${imageRes}")
            }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp) // Adjust the height as needed
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = city, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = blue1)
        Text(text = "City in $country", color = blue3)
    }
}

data class Place(val city: String, val country: String, val imageRes: Int)
