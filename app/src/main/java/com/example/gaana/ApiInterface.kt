package com.example.gaana

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {
    @Headers("X-RapidAPI-Key:0f0f68b745msh1318e6da2c84af1p1950edjsn200bdcb9eafc",
        "X-RapidAPI-Host:deezerdevs-deezer.p.rapidapi.com")



    @GET("search")
    fun getData(@Query("q") query : String) : Call<MusicData>
}