package com.mobile.recorduserapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile.recorduserapp.data.response.foods.FoodResponse
import com.mobile.recorduserapp.data.response.getusers.GetAllUsers
import com.mobile.recorduserapp.service.ApiService
import com.tanta.jivstream.util.SingleLiveEvent
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class HomeViewModel:ViewModel() {


    var liveUsers :MutableLiveData<FoodResponse> = MutableLiveData()
    var error =SingleLiveEvent<String?>()
    var isloading :MutableLiveData<Boolean> = MutableLiveData()

    private fun showError(message: String?) {
        error.value = message

        // Automatically clear the error after 3 seconds
        viewModelScope.launch {
            delay(2000)
            error.value = null
        }
    }

    fun getUsers() {
        isloading.value = true
        viewModelScope.launch {
            try {
                val response = ApiService.apicall.getfood()
                if (response.isSuccessful){

                    liveUsers.value = response.body()
                    isloading.value = false

                }else{
                    error.value = "Unknown error occurred"
                    isloading.value = false

                }

            } catch (e: IOException) {
                println("IOE:: "+e.localizedMessage)
                showError(e.localizedMessage)
                error.value = e.localizedMessage
                isloading.value = false


            } catch (e: HttpException) {
                println("IOEhttp:: "+e.localizedMessage)
                showError(e.localizedMessage)

                error.value = e.localizedMessage
                isloading.value = false


            } catch (e: Exception) {
                println("IOEhttpeee:: "+e.localizedMessage)
                showError(e.localizedMessage)

                error.value = e.localizedMessage
                isloading.value = false


            }
        }
    }



}