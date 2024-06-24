package com.example.basicpracticeui1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basicpracticeui1.ui.theme.BasicPracticeUI1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicPracticeUI1Theme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.LightGray)
                        .padding(top = 25.dp, bottom = 16.dp, start = 8.dp, end = 8.dp)
                ) {
                    NavBar()
                    CardView()
                    Spacer(modifier = Modifier.height(30.dp))
                    SwitchUser()
                    Spacer(modifier = Modifier.height(20.dp))
                    ChipSection(
                        chips = listOf("Recent", "Blood", "Money"),
                        icons = listOf(
                            painterResource(id = R.drawable.baseline_change_circle_24),
                            painterResource(id = R.drawable.baseline_bloodtype_24),
                            painterResource(id = R.drawable.baseline_money_24)
                        )
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    FilteringOptions()
                    Spacer(modifier = Modifier.height(15.dp))
                    Featured(
                        mainImages = listOf(
                            painterResource(id = R.drawable.screenshot__225_),
                            painterResource(id = R.drawable.screenshot__225_),
                        ),
                        mainHeading = listOf(
                            "Support children for education",
                            "Support children for education"
                        )
                    )
                }

            }
        }
    }
}

@Composable
fun NavBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray),
        verticalAlignment = Alignment.CenterVertically
    ) {
        var clickedMenu by rememberSaveable {
            mutableStateOf(false)
        }
        Surface(
            onClick = { clickedMenu = !clickedMenu },
            color = Color.LightGray
        ) {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_menu_24),
                    contentDescription = "Menu Logo"
                )
            }
        }
        Row(
            modifier = Modifier
                .width(290.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(8.dp)
                )
                .height(45.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                painter = painterResource(id = R.drawable.baseline_search_24),
                contentDescription = "SearchBar Logo"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Search",
                color = Color.Gray
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.baseline_notifications_none_24),
            contentDescription = "Notification Icon",
            Modifier.padding(start = 8.dp)
        )
    }
}

@Composable
fun CardView(
    text: String = "International Day of Donation",
    date: String = "20 Dec 2024",
    color: Color = colorResource(id = R.color.teal_700)
) {
    Card(
        modifier = Modifier
            .width(370.dp)
            .height(330.dp)
            .padding(start = 10.dp, end = 10.dp, top = 20.dp),
        shape = RoundedCornerShape(40.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = color,
                    shape = RoundedCornerShape(40.dp)
                )
                .width(370.dp)
                .height(330.dp)

        ) {
//            Image(imageVector = , contentDescription = "Image for Background of Card")
            Box(
                modifier = Modifier
                    .background(
                        color = color,
                        shape = RoundedCornerShape(40.dp)
                    )
                    .height(330.dp)
                    .width(370.dp)
                    .padding(top = 60.dp, start = 30.dp, end = 140.dp),

                ) {
                Column {
                    Text(
                        text = text,
                        fontSize = 30.sp,
                        color = Color.White,
                        fontWeight = FontWeight(600)
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(top = 20.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_calendar_month_24),
                            contentDescription = "Calendar Logo",
                            tint = Color.White
                        )
                        Text(
                            text = date, color = Color.White,
                            modifier = Modifier.padding(start = 2.dp)
                        )
                    }
                }

            }

        }
    }
}

@Composable
fun SwitchUser() {
    Surface(
        modifier = Modifier
            .height(50.dp)
            .width(370.dp)
            .padding(start = 10.dp, end = 10.dp),
        color = colorResource(id = R.color.medium_gray),
        shape = RoundedCornerShape(50.dp)
    ) {
        var buttonToToggleUser by rememberSaveable {
            mutableStateOf(true)
        }

        var toggleColor = Color.White

        toggleColor = if (buttonToToggleUser) {
            toggleColor
        } else {
            Color.Transparent
        }

        Row(
            modifier = Modifier
                .height(50.dp)
                .width(370.dp)
        ) {
            Surface(
                modifier = Modifier
                    .height(50.dp)
                    .width(170.dp)
                    .padding(top = 6.dp, bottom = 6.dp, start = 8.dp),
                shape = RoundedCornerShape(50.dp),
                onClick = { buttonToToggleUser = !buttonToToggleUser },
                color = toggleColor
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(text = "For Peoples")
                }

            }
            Surface(
                modifier = Modifier
                    .height(50.dp)
                    .width(170.dp)
                    .padding(top = 6.dp, bottom = 6.dp, start = 8.dp),
                shape = RoundedCornerShape(50.dp),
                onClick = { },
                color = Color.Transparent
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(text = "For Organizations")
                }

            }

        }
    }
}

@Composable
fun ChipSection(
    chips: List<String>,
    icons: List<Painter>
) {
    var selectedChipIndex by remember {
        mutableIntStateOf(0)
    }
    LazyRow(
        modifier = Modifier.padding(start = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(chips.size) {
            Surface(
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color.White),
                onClick = {
                    selectedChipIndex = it
                }
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .height(100.dp)
                        .background(Color.White)
                        .fillParentMaxWidth(1 / 3.5f)
                ) {
                    Icon(
                        painter = icons[it],
                        contentDescription = "Icons of ${chips[it]}",
                        modifier = Modifier
                            .size(50.dp),
                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = chips[it],
                        color = Color.Black,
                        modifier = Modifier.background(Color.White)
                    )
                }

            }
        }
    }
}

@Composable
fun FilteringOptions() {
    Row(
        modifier = Modifier
            .padding(start = 15.dp, end = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(200.dp)
    ) {
        Text(text = "Filter")
        Row {
            Icon(
                painter = painterResource(id = R.drawable.baseline_location_on_24),
                contentDescription = "Map view"
            )
            Text(text = "Map View")
        }
    }
}

@Composable
fun Featured(
    mainImages: List<Painter>,
    mainHeading: List<String>,
) {
    Card(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
            .fillMaxWidth(1f)
            .fillMaxHeight()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(10.dp)
            )

    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            LazyColumn(
                modifier = Modifier
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    )
            ) {

                items(mainImages.size) {
                    Row(
                        modifier = Modifier
                            .padding(
                                top = 10.dp,
                                bottom = 10.dp,
                                start = 10.dp,
                                end = 20.dp
                            )
                            .background(Color.White)
                            .fillMaxWidth()
                    ) {
                        Image(
                            painter = mainImages[it],
                            contentDescription = "Images of card",
                            modifier = Modifier
                                .width(120.dp)
                                .clip(
                                    RoundedCornerShape(10.dp)
                                )
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Column {
                            Text(
                                text = mainHeading[it],
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_horizontal_rule_24),
                                contentDescription = "progress bar",
                                modifier = Modifier
                                    .width(200.dp)
                            )
                            Row {
                                Text(text = "Target: 50K USD")
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun PreviewNavBar() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(top = 25.dp, bottom = 16.dp, start = 8.dp, end = 8.dp)
    ) {
        NavBar()
        CardView()
        Spacer(modifier = Modifier.height(30.dp))
        SwitchUser()
        Spacer(modifier = Modifier.height(20.dp))
        ChipSection(
            chips = listOf("Recent", "Blood", "Money"),
            icons = listOf(
                painterResource(id = R.drawable.baseline_change_circle_24),
                painterResource(id = R.drawable.baseline_bloodtype_24),
                painterResource(id = R.drawable.baseline_money_24)
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        FilteringOptions()
        Spacer(modifier = Modifier.height(10.dp))
        Featured(
            mainImages = listOf(
                painterResource(id = R.drawable.screenshot__225_),
                painterResource(id = R.drawable.screenshot__225_),
            ),
            mainHeading = listOf("Support children for education", "Support children for education")
        )
    }

}