package com.example.gaana

import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.gaana.databinding.MusicListLayoutBinding
import com.squareup.picasso.Picasso

class MusicAdapter(val context : Context , val musicList: List<Data>) : RecyclerView.Adapter<MusicAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(MusicListLayoutBinding.inflate(LayoutInflater.from(context),parent,false))

    override fun getItemCount() = musicList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.textTitle.text = musicList[position].title
        Picasso.get().load(musicList[position].album.cover).into(holder.binding.image)

        //for media
        val mediaPlayer = MediaPlayer.create(context,musicList[position].preview.toUri())
        holder.binding.btnStart.setOnClickListener {
            mediaPlayer.start()
        }
        holder.binding.btnPause.setOnClickListener {
            mediaPlayer.stop()
            mediaPlayer.seekTo(0)
        }
    }

    class ViewHolder(val binding:MusicListLayoutBinding) : RecyclerView.ViewHolder(binding.root)
}