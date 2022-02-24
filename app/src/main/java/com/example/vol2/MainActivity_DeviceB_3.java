package com.example.vol2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.SeekBar;
import android.widget.ToggleButton;


public class MainActivity_DeviceB_3 extends AppCompatActivity {

    Button prev_button,programB_1,programB_2,programB_3;
    private ToggleButton toggleButton1, toggleButton2;
    private Button bMute;
    private SeekBar volumeSeekbar = null;//sets up the variables/device parts
    private AudioManager audioManager = null;
    public int prev_progress = 0;
    public boolean muted = false;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_deviceb_3);

        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        volumeSeekbar = (SeekBar)findViewById(R.id.seekBar_B);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.canon_d);

        prev_progress = volumeSeekbar.getProgress();
        prev_button = (Button) findViewById(R.id.prev_b);
        programB_1 = (Button) findViewById(R.id.programB_1);
        programB_2 = (Button) findViewById(R.id.programB_2);
        programB_3 = (Button) findViewById(R.id.programB_3);


        prev_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_DeviceB_3.this, MainActivity.class);
                startActivity(intent);

            }

        });

        programB_1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_DeviceB_3.this, MainActivity_DeviceB_Program1.class);
                startActivity(intent);

            }

        });

        programB_2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_DeviceB_3.this, MainActivity_DeviceB_Program2.class);
                startActivity(intent);

            }

        });

        programB_3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_DeviceB_3.this, MainActivity_DeviceB_Program3.class);
                startActivity(intent);

            }

        });


        initControls();

        }

        private void initControls()
        {
            try
            {

                bMute = (Button)findViewById(R.id.mute_B);
                audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                volumeSeekbar.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
                volumeSeekbar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
                bMute.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {

                        Log.d("CREATION", "Before: "+String.valueOf(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)));
                        if(muted!=true){

                            Log.d("CREATION","bbbb");
                            audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,AudioManager.ADJUST_MUTE,0);
                            muted = true;
                        }
                        else{
                            Log.d("CREATION","cccc");
                            audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_UNMUTE,0);
                            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
                                    prev_progress, 0);
                            muted = false;
                        }
                        Log.d("CREATION", "After: "+String.valueOf(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)));

                    }
                });



                volumeSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()

                {
                    @Override
                    public void onStopTrackingTouch(SeekBar arg0)
                    {
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar arg0)
                    {
                    }
                    @Override
                    public void onProgressChanged(SeekBar arg0, int progress, boolean arg2)
                    {
                        if(muted!=true) {
                            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
                                    progress, 0);
                        }
                        prev_progress = progress;
                    }


                });

            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }

        }
        @Override
        protected void onResume() {
            super.onResume();
            mediaPlayer.start();
        }
        @Override
        protected void onStop() {
            super.onStop();
            mediaPlayer.release();

    }

    }

