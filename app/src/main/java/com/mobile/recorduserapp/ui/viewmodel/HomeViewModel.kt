package com.mobile.recorduserapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile.recorduserapp.data.response.getusers.GetAllUsers
import com.mobile.recorduserapp.service.ApiService
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class HomeViewModel:ViewModel() {


    var liveUsers :MutableLiveData<GetAllUsers> = MutableLiveData()
    var error :MutableLiveData<String> = MutableLiveData()
    var isloading :MutableLiveData<Boolean> = MutableLiveData()


    fun getUsers() {
        isloading.value = true
        viewModelScope.launch {
            try {
                val response = ApiService.apicall.getUsers()
                if (response.isSuccessful){
                    liveUsers.value = response.body()
                    isloading.value = false

                }

            } catch (e: IOException) {
                error.value = e.localizedMessage
                isloading.value = false


            } catch (e: HttpException) {

                error.value = e.localizedMessage
                isloading.value = false


            } catch (e: Exception) {

                error.value = e.localizedMessage
                isloading.value = false


            }
        }
    }



}