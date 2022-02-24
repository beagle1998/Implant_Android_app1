package com.example.vol2;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class MainActivity_DeviceB_Program1 extends AppCompatActivity {
    Button prev_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_deviceb_program1);

        prev_button = (Button) findViewById(R.id.prev_b_1);

        prev_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_DeviceB_Program1.this, MainActivity_DeviceB_3.class);
                startActivity(intent);

            }

        });

    }
}