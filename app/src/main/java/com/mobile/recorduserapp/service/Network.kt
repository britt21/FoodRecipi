package com.mobile.recorduserapp.service

import com.mobile.recorduserapp.data.response.foods.FoodResponse
import com.mobile.recorduserapp.data.response.getusers.GetAllUsers
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST


interface Service{


//    @Headers(
//        "X-Request-ID: 1b3c82f4-b396-44eb-8e21-46100db3c899",
//        "User-Agent: Application-Name/1.0.0 (Operating System Name 1.0.0)"
//    )
//    @GET("/pupils?page=1")
//    suspend  fun getUsers():Response<GetAllUsers>



    @GET("api/foods")
    suspend  fun getfood():Response<FoodResponse>




}

var retrofit = Retrofit.Builder()
    .baseUrl("https://assessment.vgtechdemo.com")
    .addConverterFactory(GsonConverterFactory.create())
    .client(OkHttpClient.Builder().build())
    .build()

object  ApiService{
    val apicall : Service by lazy {
       retrofit.create(Service::class.java)
    }
}

