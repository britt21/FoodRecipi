package com.mobile.recorduserapp.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mobile.recorduserapp.R
import com.mobile.recorduserapp.ui.theme.greyTextColor
import com.mobile.recorduserapp.utils.addimage
import com.mobile.recorduserapp.utils.textboldcutom
import com.mobile.recorduserapp.utils.textlit
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mobile.recorduserapp.ui.theme.black
import com.mobile.recorduserapp.ui.theme.hinttextcolor
import com.mobile.recorduserapp.ui.theme.litred
import com.mobile.recorduserapp.ui.theme.whitecolor
import com.mobile.recorduserapp.ui.viewmodel.HomeViewModel
import com.mobile.recorduserapp.utils.buttons.appbutton
import com.mobile.recorduserapp.utils.sh10
import com.mobile.recorduserapp.utils.sh20
import com.mobile.recorduserapp.utils.sh5
import com.mobile.recorduserapp.utils.sw10
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer
import com.mobile.recorduserapp.data.cons.ADDFOOD
import com.mobile.recorduserapp.ui.theme.blueIconColor
import com.mobile.recorduserapp.ui.theme.litgrey
import com.mobile.recorduserapp.utils.error.errorbox


@Composable
fun HomeScreen(modifier: Modifier, viewModel: HomeViewModel = viewModel(), navController: NavController){

    var context = LocalContext.current

    val allusers by viewModel.liveUsers.observeAsState()
    val error by viewModel.error.observeAsState()
    val isloading by viewModel.isloading.observeAsState()

error?.let {
    Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
}



    allusers.let { println("DDDAATAA:: +" + it) }
    println("USERSSFONUND:: "+allusers)
    println("FATALL:: "+error)

    LaunchedEffect(key1 = Unit) {
        viewModel.getUsers()

        if (error != null){
            Toast.makeText(context,error,Toast.LENGTH_SHORT).show()
        }
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {

                    navController.navigate(ADDFOOD)
                    // Add your action here
                    println("FAB Clicked!")
                },
                containerColor = Color(0xFF6200EE), // Purple color
                contentColor = Color.White
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        }
    ) {innerPadding->
    Column (
        modifier = Modifier.padding(innerPadding)
            .padding(0.dp)

            .background(Color.White)
            .fillMaxSize()) {

        Column (
            modifier = Modifier
                .padding(horizontal = 11.dp)
                .background(Color.White)
                .fillMaxWidth()

        ) {
            error?.let {
                errorbox("Error","${it}",{ true}, { viewModel.getUsers()})
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 0.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {


                addimage(image = R.drawable.avatar)
                addimage(image = R.drawable.bell,Modifier.size(47.dp))

            }


            textboldcutom(text = "Hey there, Lucy! ", size = 15, color = Color.Black)
            textlit(text = "Are you excited to create a tasty dish today? ", size = 14, color = greyTextColor)



            var text by remember { mutableStateOf("") }

            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                placeholder = { Text("Search foods...", color = Color.Gray) },

                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color.Gray
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.LightGray.copy(alpha = 0.2f),
                    unfocusedContainerColor = Color.LightGray.copy(alpha = 0.2f),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp,)
            )
            sh10()

            Row(modifier = Modifier.fillMaxWidth()){

                Box(modifier = Modifier
                    .height(40.dp)
                    .width(60.dp)
                    .background(blueIconColor, shape = RoundedCornerShape(5.dp),), contentAlignment = Alignment.Center){

                    textboldcutom(text = "All", size = 13, color = whitecolor)
                }

                sw10()

                Box(modifier = Modifier
                    .height(40.dp)
                    .background(litgrey, shape = RoundedCornerShape(5.dp),), contentAlignment = Alignment.Center){

                    textlit(text = "Morning Feast", size = 11, color = black, modifier = Modifier.padding(horizontal = 5.dp))
                }

                sw10()
                Box(modifier = Modifier
                    .height(40.dp)
                    .background(litgrey, shape = RoundedCornerShape(5.dp),), contentAlignment = Alignment.Center){

                    textlit(text = "Sunrise Meal", size = 11, color = black, modifier = Modifier.padding(horizontal = 5.dp))
                }

    sw10()
                Box(modifier = Modifier
                    .height(40.dp)
                    .background(litgrey, shape = RoundedCornerShape(5.dp),), contentAlignment = Alignment.Center){

                    textlit(text = "Dawn Delicacies", size = 11, color = black, modifier = Modifier.padding(horizontal = 3.dp))
                }




            }


            sh20()
            textboldcutom(text = "All Foods", size = 13, color = Color.Black)

            sh10()


            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp)
            )
            {
                if (isloading == true) {
                    items(5) {

                        FoodCard("", "", R.drawable.food, emptyList(), isLoading = true)
                    }
                }else{
                    allusers?.data?.let { dish->
                    items(dish) { food->
                        FoodCard("${food?.description}","${food?.calories}",R.drawable.food,food!!.foodTags!!,)



//                        Box(
//                            modifier = Modifier
//                                .height(280.dp)
//                                .fillMaxWidth()
//                                .border(color = greyTextColor, width = 0.2.dp, shape = RoundedCornerShape(5.dp))
//                        ) {
//
//
//                            Column(modifier = Modifier
//                                .fillMaxSize()
//                                .padding(0.dp)) {
//
//                                addimage(image = R.drawable.food, modifier = Modifier.fillMaxWidth())
//
//                                Column(modifier = Modifier
//                                    .fillMaxWidth()
//                                    .padding(10.dp)) {
//
//                                    Row(
//                                        modifier = Modifier.fillMaxWidth(),
//                                        horizontalArrangement = Arrangement.SpaceBetween
//                                    ) {
//                                        textboldcutom(
//                                            text = "${food?.description}",
//                                            size = 14,
//                                            color = Color.Black,
//                                            modifier = Modifier.weight(1f) // Ensures text gets space
//                                        )
//                                        addimage(image = R.drawable.like)
//                                    }
//
//
//                                    Row(modifier = Modifier.fillMaxWidth()) {
//                                        addimage(image = R.drawable.fire, modifier = Modifier.size(24.dp))
//                                        textlit(
//                                            text = "${food?.calories}",
//                                            size = 13,
//                                            color = hinttextcolor,
//                                            modifier = Modifier.padding(start = 8.dp) // Adds spacing from image
//                                        )
//                                    }
//
//                                    sh5()
//                                    Row(modifier = Modifier.fillMaxWidth()) {
//                                        textlit(
//                                            text = "Creamy hummus spread on whole grain toast topped with sliced cucumbers and radishes.",
//                                            size = 14,
//                                            color = Color.Black,
//                                            modifier = Modifier.padding(start = 0.dp)
//                                        )
//                                    }
//
//                                    sh10()
//                                    Row(modifier = Modifier.fillMaxWidth()){
//                                        Box(modifier = Modifier
//                                            .height(60.dp)
//                                            .background(color = litred, shape = RoundedCornerShape(6.dp)), contentAlignment = Alignment.Center){
//
//                                            textlit(text = "healthy", size = 10, color = black,modifier = Modifier.padding(horizontal = 5.dp))
//                                        }
//
//                                        sw10()
//                                        Box(modifier = Modifier
//                                            .height(60.dp)
//                                            .background(color = litred, shape = RoundedCornerShape(6.dp)), contentAlignment = Alignment.Center){
//
//                                            textlit(text = "vegetarian", size = 10, color = black, modifier = Modifier.padding(horizontal = 5.dp))
//                                        }
//
//
//
//                                    }
//                                }
//
//                            }
//                            }
                        }



                    }
                }

            }
        }


        Column (modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom){
            appbutton("Add", modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp))
        }

    }
    }
    }


@Composable
fun FoodCard(
    description: String,
    calories: String,
    imageRes: Int,
    tags: List<String?> = listOf(),
    onLikeClick: () -> Unit = {},
    isLoading :Boolean = false
) {
    sh20()
    Box(
        modifier = Modifier
            .height(280.dp)
            .fillMaxWidth()
            .border(color = greyTextColor, width = 0.2.dp, shape = RoundedCornerShape(5.dp))
            .placeholder(
                visible = isLoading,
        highlight = PlaceholderHighlight.shimmer()
    )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp)
        ) {
            // Food Image
            addimage(image = imageRes, modifier = Modifier.fillMaxWidth())

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                // Title and Like Icon
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    textboldcutom(
                        text = description,
                        size = 14,
                        color = Color.Black,
                        modifier = Modifier.weight(1f)
                    )
                    addimage(image = R.drawable.like, Modifier.clickable { onLikeClick() })
                }

                // Calories Section
                Row(modifier = Modifier.fillMaxWidth()) {
                    addimage(image = R.drawable.fire, modifier = Modifier.size(24.dp))
                    textlit(
                        text = "$calories kcal",
                        size = 13,
                        color = hinttextcolor,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }

                sh5()

                // Description (Hardcoded text - can be passed as param)
                Row(modifier = Modifier.fillMaxWidth()) {
                    textlit(
                        text = "Creamy hummus spread on whole grain toast topped with sliced cucumbers and radishes.",
                        size = 14,
                        color = Color.Black
                    )
                }

                sh10()

                // Tags (Dynamic)
                Row(modifier = Modifier.fillMaxWidth()) {
                    tags.forEach { tag ->
                        Box(
                            modifier = Modifier
                                .height(30.dp)
                                .background(color = litred, shape = RoundedCornerShape(6.dp))
                                .padding(horizontal = 8.dp)
                                .wrapContentWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            textlit(text = tag!!, size = 10, color = black)
                        }
                        sw10()
                    }
                }
            }
        }
    }
}

@Composable
fun InfoText(title: String, value: String, isBold: Boolean = false) {
    Row(modifier = Modifier.padding(vertical = 4.dp)) {
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = value,
            fontSize = 16.sp,
            fontWeight = if (isBold) FontWeight.Bold else FontWeight.Normal,
            color = Color.Black.copy(alpha = 0.8f)
        )
    }
}


