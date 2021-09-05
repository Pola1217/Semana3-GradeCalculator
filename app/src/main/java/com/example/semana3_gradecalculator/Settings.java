package com.example.semana3_gradecalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

public class Settings extends AppCompatActivity {

    private ConstraintLayout bgLayout2;
    private Button blue;
    private Button white;
    private Button pink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        bgLayout2 = findViewById(R.id.bg2);
        //color buttons
        blue = findViewById(R.id.blue);
        white = findViewById(R.id.white);
        pink = findViewById(R.id.pink);

        //bg color
        SharedPreferences colorP = getSharedPreferences("bgColors", MODE_PRIVATE);

        //apply color blue
        blue.setOnClickListener(
                (view)->{
                    colorP.edit().putString("color", "#A2E1FA").apply();
                    finish();
                }
        );
        //apply color white
        white.setOnClickListener(
                (view)->{
                    colorP.edit().putString("color", "#FFFFFFFF").apply();
                    finish();
                }
        );
        //apply color pink
        pink.setOnClickListener(
                (view)->{
                    colorP.edit().putString("color", "#F5B1CF").apply();
                    finish();
                }
        );

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences colorP= getSharedPreferences("bgColors", MODE_PRIVATE);
        String bg= colorP.getString("color", "#FFFFFFFF");
        bgLayout2.setBackgroundColor(Color.parseColor(bg));
    }
}