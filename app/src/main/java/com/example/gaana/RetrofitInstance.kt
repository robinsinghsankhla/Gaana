package com.example.gaana

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance() {

    var apiInterface: ApiInterface
    companion object{
//        lateinit var instance : RetrofitInstance

        fun gitInstance() : RetrofitInstance{
//            if (instance==null){
//                instance = RetrofitInstance()
//            }
//            return instance
            var instance = RetrofitInstance()
            return  instance
        }
    }

    init {
        var retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://deezerdevs-deezer.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInterface = retrofitBuilder.create(ApiInterface::class.java)
    }


}