package com.example.mymeditation

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageButton
import android.widget.SeekBar

class Morning : AppCompatActivity() {

    lateinit var runnable: Runnable
    private var handler= Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_morning)



        // Lets create a new Media Player object

        val mediaplayer: MediaPlayer = MediaPlayer.create(this, R.raw.morning)

        // lets add seek baar
        val skbar3= findViewById<SeekBar>(R.id.seekBar3)
        skbar3.progress=0
        //now add the maximum value of seek bar duration of the music
        skbar3.max=mediaplayer.duration



        //now lets create our play button event


        val play_Bc3 = findViewById<ImageButton>(R.id.play_btnMorning2)
        play_Bc3.setOnClickListener {
            // first check the media player is not playing
            if (!mediaplayer.isPlaying) {
                mediaplayer.start()
                //and will change the button's image
                play_Bc3.setImageResource(R.drawable.baseline_pause_24)

            } else {// media player is playing and we can pause this
                mediaplayer.pause()
                play_Bc3.setImageResource(R.drawable.baseline_play_arrow_24)


            }


        }
        // now we will add the seekbar event
        // when we will change the seekbar it will change the duration of music
        skbar3.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
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
            skbar3.progress =mediaplayer.currentPosition
            handler.postDelayed(runnable,1000)
        }
        handler.postDelayed(runnable,1000)

        // now we want that when the music is finished to play the seek baar will back to zero and button image changed
        mediaplayer.setOnCompletionListener {
            play_Bc3.setImageResource(R.drawable.baseline_play_arrow_24)
            skbar3.progress =0
        }

    }
    }
