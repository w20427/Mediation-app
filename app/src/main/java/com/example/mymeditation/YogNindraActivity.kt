package com.example.mymeditation

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.SeekBar


class YogNindraActivity : AppCompatActivity() {

    //now we will need to change the seek bar position while we playing
    //  to do this we have to create a runnable object and a handler

    lateinit var runnable: Runnable
    private var handler= Handler()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yog_nindra)
//
//        var play =findViewById<Button>(R.id.buttonPlay)
//        var pause = findViewById<Button>(R.id.buttonPause)
//        var mp =MediaPlayer()
//
//        play.setOnClickListener {
//            mp.setDataSource(this, Uri.parse("android.resource://"+this.packageName+"/"+R.raw.yogni))
//            mp.prepare()
//            mp.start()
//        }
//        pause.setOnClickListener {
//            mp.stop()
//            mp.release()
//            mp=MediaPlayer()
//        }












        // Lets create a new Media Player object

        val mediaplayer: MediaPlayer = MediaPlayer.create(this, R.raw.yogni)

        // lets add seek baar
        val skbar2= findViewById<SeekBar>(R.id.seekBary)
        skbar2.progress=0
        //now add the maximum value of seek bar duration of the music
        skbar2.max=mediaplayer.duration



        //now lets create our play button event


        val play_Bc = findViewById<ImageButton>(R.id.play_btnyognidra)
        play_Bc.setOnClickListener {
            // first check the media player is not playing
            if (!mediaplayer.isPlaying) {
                mediaplayer.start()
                //and will change the button's image
                play_Bc.setImageResource(R.drawable.baseline_pause_24)

            } else {// media player is playing and we can pause this
                mediaplayer.pause()
                play_Bc.setImageResource(R.drawable.baseline_play_arrow_24)


            }


        }
        // now we will add the seekbar event
        // when we will change the seekbar it will change the duration of music
        skbar2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, pos: Int, changed: Boolean) {
                //now when we change the position of seek bar the music is go to that position
                if(changed){
                    mediaplayer.seekTo(pos)

                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        runnable= Runnable {
            skbar2.progress =mediaplayer.currentPosition
            handler.postDelayed(runnable,1000)
        }
        handler.postDelayed(runnable,1000)

        // now we want that when the music is finished to play the seek baar will back to zero and button image changed
        mediaplayer.setOnCompletionListener {
            play_Bc.setImageResource(R.drawable.baseline_play_arrow_24)
            skbar2.progress =0
        }

    }
}