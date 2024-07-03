package com.example.travelapp

data class CityDetail(
    val city: String,
    val country: String,
    val imageRes: Int,
    val description: String,
    val highlights: List<String>,
    val price: String
)

val cityDetailsList = listOf(
    CityDetail(
        city = "Amsterdam",
        country = "Netherlands",
        imageRes = R.drawable.amsterdam,
        description = "Amsterdam is known for its canals, windmills, and tulips. It is the capital of the Netherlands and a major European city.",
        highlights = listOf("Vondelpark", "Museumplein", "Concertgebouw", "Rijksmuseum", "Van Gogh Museum"),
        price = "$400/Package"
    ),
    CityDetail(
        city = "Sydney",
        country = "Australia",
        imageRes = R.drawable.sydney,
        description = "Sydney is known for its Sydney Opera House, with a distinctive sail-like design. It's a major city in Australia and a gateway to the country.",
        highlights = listOf("Sydney Opera House", "Sydney Harbour Bridge", "Bondi Beach", "Darling Harbour", "Taronga Zoo"),
        price = "$500/Package"
    ),
    CityDetail(
        city = "Bali",
        country = "Indonesia",
        imageRes = R.drawable.bali,
        description = "Bali is a popular tourist destination known for its forested volcanic mountains, iconic rice paddies, beaches, and coral reefs.",
        highlights = listOf("Uluwatu Temple", "Ubud Monkey Forest", "Tegallalang Rice Terrace", "Kuta Beach", "Mount Batur"),
        price = "$300/Package"
    ),
    CityDetail(
        city = "Tokyo",
        country = "Japan",
        imageRes = R.drawable.tokyo,
        description = "Tokyo, Japan's busy capital, mixes the ultramodern and the traditional, from neon-lit skyscrapers to historic temples.",
        highlights = listOf("Shibuya Crossing", "Tokyo Tower", "Senso-ji Temple", "Akihabara", "Ueno Park"),
        price = "$600/Package"
    ),
    CityDetail(
        city = "New York",
        country = "USA",
        imageRes = R.drawable.newyork,
        description = "New York City is known for its cultural diversity, iconic landmarks, and as a major hub for finance and culture in the USA.",
        highlights = listOf("Statue of Liberty", "Central Park", "Times Square", "Empire State Building", "Brooklyn Bridge"),
        price = "$700/Package"
    ),
    CityDetail(
        city = "Bukittinggi",
        country = "Indonesia",
        imageRes = R.drawable.bukit,
        description = "Bukittinggi is a city in West Sumatra, Indonesia, known for its cultural heritage, beautiful landscapes, and historical landmarks.",
        highlights = listOf("Jam Gadang", "Sianok Canyon", "Japanese Tunnel", "Ngarai Sianok", "Fort de Kock"),
        price = "$200/Package"
    ),
    CityDetail(
        city = "Kilimanjaro",
        country = "Tanzania",
        imageRes = R.drawable.kilimanjaro,
        description = "Mount Kilimanjaro is the highest mountain in Africa, known for its breathtaking landscapes and as a popular trekking destination.",
        highlights = listOf("Uhuru Peak", "Marangu Route", "Machame Route", "Shira Plateau", "Chala Crater Lake"),
        price = "$800/Package"
    ),
    CityDetail(
        city = "Los Angeles",
        country = "USA",
        imageRes = R.drawable.los_angeles,
        description = "Los Angeles is known for its Mediterranean climate, ethnic diversity, the entertainment industry, and its sprawling metropolis.",
        highlights = listOf("Hollywood Sign", "Universal Studios", "Griffith Observatory", "Santa Monica Pier", "Getty Center"),
        price = "$600/Package"
    ),
    CityDetail(
        city = "Osaka",
        country = "Japan",
        imageRes = R.drawable.osaka,
        description = "Osaka is a large port city and commercial center on the Japanese island of Honshu, known for modern architecture, nightlife, and hearty street food.",
        highlights = listOf("Osaka Castle", "Dotonbori", "Universal Studios Japan", "Shinsekai", "Sumiyoshi Taisha"),
        price = "$550/Package"
    ),
    CityDetail(
        city = "Bandung",
        country = "Indonesia",
        imageRes = R.drawable.bandung,
        description = "Bandung is known for its universities, technology institutes, colonial architecture, and as a shopping destination with a cooler climate.",
        highlights = listOf("Tangkuban Perahu", "Kawah Putih", "Gedung Sate", "Braga Street", "Floating Market Lembang"),
        price = "$250/Package"
    ),
    CityDetail(
        city = "Chicago",
        country = "USA",
        imageRes = R.drawable.chicago,
        description = "Chicago, on Lake Michigan in Illinois, is known for its skyscrapers, museums, and as the birthplace of modern architecture.",
        highlights = listOf("Millennium Park", "Willis Tower", "Navy Pier", "Art Institute of Chicago", "Magnificent Mile"),
        price = "$650/Package"
    ),
    CityDetail(
        city = "Cape Town",
        country = "South Africa",
        imageRes = R.drawable.cape_town,
        description = "Cape Town is a port city on South Africa’s southwest coast, on a peninsula beneath the imposing Table Mountain.",
        highlights = listOf("Table Mountain", "Robben Island", "Cape of Good Hope", "V&A Waterfront", "Kirstenbosch National Botanical Garden"),
        price = "$500/Package"
    )
)

    // Add more city details here


