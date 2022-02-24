package com.example.vol2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class MainActivity_DeviceA_Program2 extends AppCompatActivity {
    Button prev_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_devicea_program2);

        prev_button = (Button) findViewById(R.id.prev_1_a_2);

        prev_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_DeviceA_Program2.this, MainActivity_DeviceA_2.class);
                startActivity(intent);

            }

        });    }
}