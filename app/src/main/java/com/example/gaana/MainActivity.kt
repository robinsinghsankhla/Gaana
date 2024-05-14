package com.example.gaana

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gaana.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
binding.recMusic.layoutManager = LinearLayoutManager(this)
RetrofitInstance.gitInstance().apiInterface.getData("eminem").enqueue(object : Callback<MusicData> {
    override fun onResponse(p0: Call<MusicData>, p1: Response<MusicData>) {
        val musicList = p1.body()?.data!!
        binding.recMusic.adapter = MusicAdapter(applicationContext, musicList)
        binding.progress.visibility = View.INVISIBLE

    }

    override fun onFailure(p0: Call<MusicData>, p1: Throwable) {
        Log.d("apie",""+p1.message)
    }
})

    }
}