package com.example.vol2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class MainActivity_DeviceA_Program4 extends AppCompatActivity {

    Button prev_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_devicea_program4);

        prev_button = (Button) findViewById(R.id.prev_1_a_4);

        prev_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_DeviceA_Program4.this, MainActivity_DeviceA_2.class);
                startActivity(intent);

            }

        });
    }
}