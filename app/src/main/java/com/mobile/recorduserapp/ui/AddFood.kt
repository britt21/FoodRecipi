package com.mobile.recorduserapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
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
import androidx.navigation.NavController
import com.mobile.recorduserapp.R
import com.mobile.recorduserapp.ui.theme.black
import com.mobile.recorduserapp.utils.addimage
import com.mobile.recorduserapp.utils.sh10
import com.mobile.recorduserapp.utils.sh20
import com.mobile.recorduserapp.utils.sw10
import com.mobile.recorduserapp.utils.textboldcutom
import com.mobile.recorduserapp.utils.textlit


@Composable
fun AddFood(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = modifier
            .background(Color.White)
            .fillMaxSize()
    ) {


        Column(
            modifier = Modifier
                .padding(horizontal = 11.dp)
                .background(Color.White)
                .fillMaxWidth()

        ) {


            Row(modifier = Modifier.fillMaxWidth()) {
                addimage(image = R.drawable.back, modifier = Modifier.size(45.dp).clickable { println("WELLDONE")
                navController.popBackStack()})
            }


            sh10()
            Divider()
            sh20()
            Row(modifier = Modifier.fillMaxWidth()) {


                Box(
                    contentAlignment = Alignment.Center, modifier = Modifier
                        .height(85.dp)
                        .weight(1f)
                        .border(
                            color = Color.Black,
                            width = 0.2.dp,
                            shape = RoundedCornerShape(5.dp)
                        )
                ) {


                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        addimage(image = R.drawable.camera)
                        textlit(text = "Take photo", size = 12, color = black)
                    }

                }



                sw10()
                Box(
                    contentAlignment = Alignment.Center, modifier = Modifier
                        .height(85.dp)
                        .weight(1f)
                        .border(
                            color = Color.Black,
                            width = 0.2.dp,
                            shape = RoundedCornerShape(5.dp)
                        )
                ) {


                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        addimage(image = R.drawable.upload)
                        textlit(text = "Upload", size = 12, color = black)
                    }


                }
            }

            var text by remember { mutableStateOf("") }

            sh10()
            textlit("Name", 13, color = black)
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                placeholder = { Text("Enter food name", color = Color.Gray) },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 0.dp)
            )





            sh10()
            textlit("Descripton", 13, color = black)
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                placeholder = { Text("Enter food description", color = Color.Gray) },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(top = 0.dp)
            )





            sh10()
            textlit("Category", 13, color = black)
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                placeholder = { Text("Dawn Delicacies", color = Color.Gray) },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .padding(top = 0.dp)
            )




            sh10()
            textlit("Calories", 13, color = black)
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                placeholder = { Text("Enter number of calories", color = Color.Gray) },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .padding(top = 0.dp)
            )



            sh20()
            textlit("Tags", 13, color = black)
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                placeholder = { Text("Add a tag", color = Color.Gray) },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .padding(top = 0.dp)
            )


        }
    }


}