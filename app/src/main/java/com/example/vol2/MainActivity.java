package com.example.vol2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Context;
import android.media.AudioManager;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Button;
import android.widget.ToggleButton;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button deviceA,deviceB;
        deviceA = (Button)findViewById(R.id.device_a);
        deviceB = (Button)findViewById(R.id.device_b);

        deviceA.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this,MainActivity_DeviceA_2.class);
                startActivity(intent);

            }

        });

        deviceB.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this,MainActivity_DeviceB_3.class);
                startActivity(intent);

            }

        });


    }
}



