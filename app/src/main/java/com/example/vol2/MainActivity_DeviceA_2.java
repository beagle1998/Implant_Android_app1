package com.example.vol2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.SeekBar;
import android.widget.ToggleButton;


public class MainActivity_DeviceA_2 extends AppCompatActivity {
    Button prev_button,programA_1,programA_2,programA_3,programA_4,programA_5;
    private ToggleButton toggleButton1, toggleButton2;
    private Button aMute;
    private SeekBar volumeSeekbar = null;//sets up the variables/device parts
    private AudioManager audioManager = null;
    public int prev_progress = 0;
    public boolean muted = false;

    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_devicea_2);

        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        volumeSeekbar = (SeekBar)findViewById(R.id.seekBar_A);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.canon_d);


        prev_progress = volumeSeekbar.getProgress();
        prev_button = (Button) findViewById(R.id.prev_1_a);
        programA_1 = (Button) findViewById(R.id.programA_1);
        programA_2 = (Button) findViewById(R.id.programA_2);
        programA_3 = (Button) findViewById(R.id.programA_3);
        programA_4 = (Button) findViewById(R.id.programA_4);
        programA_5 = (Button) findViewById(R.id.programA_5);

        prev_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_DeviceA_2.this, MainActivity.class);
                startActivity(intent);

            }

        });

        programA_1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_DeviceA_2.this, MainActivity_DeviceA_Program1.class);
                startActivity(intent);

            }

        });

        programA_2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_DeviceA_2.this, MainActivity_DeviceA_Program2.class);
                startActivity(intent);

            }

        });

        programA_3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_DeviceA_2.this, MainActivity_DeviceA_Program3.class);
                startActivity(intent);

            }

        });

        programA_4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_DeviceA_2.this, MainActivity_DeviceA_Program4.class);
                startActivity(intent);

            }

        });

        programA_5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_DeviceA_2.this, MainActivity_DeviceA_Program5.class);
                startActivity(intent);

            }

        });
        initControls();

        }

        private void initControls()
        {
            try
            {

                aMute = (Button)findViewById(R.id.mute_A);
                audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                volumeSeekbar.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
                volumeSeekbar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
                aMute.setOnClickListener(new View.OnClickListener() {

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