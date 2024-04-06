package com.example.vant

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util


class MainReproductor : AppCompatActivity() {
    private  lateinit var simpleExoPlayer: SimpleExoPlayer
    private lateinit var  playerView: PlayerView


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_reproductor)

        val playerView = findViewById<PlayerView>(R.id.playerView)

        val dataSourceFactory=DefaultDataSourceFactory(
            this,
            Util.getUserAgent(this,"ExoPlayerDemo")
        )
        val extractorsFactory = DefaultExtractorsFactory()

        val direc = "https://www.rmp-streaming.com/media/big-buck-bunny-360p.mp4"






        val factory: DataSource.Factory = DefaultDataSourceFactory(
            this,
            Util.getUserAgent(this, "ExoPlayerDemo")
        )



        simpleExoPlayer = SimpleExoPlayer.Builder(this)
            .setTrackSelector(DefaultTrackSelector(this))
            .build()


        val mediaItem: MediaItem = MediaItem.fromUri(Uri.parse(direc))



        playerView.player = simpleExoPlayer
        val mediaSource: ProgressiveMediaSource = ProgressiveMediaSource.Factory(factory)
            .createMediaSource(MediaItem.fromUri(direc))


        simpleExoPlayer.prepare(mediaSource)
        simpleExoPlayer.playWhenReady = true



    }
    override fun onDestroy() {
        super.onDestroy()

        // Liberar recursos cuando la actividad se destruye
        simpleExoPlayer.release()
    }
   // "https://www.rmp-streaming.com/media/big-buck-bunny-360p.mp4"



}


