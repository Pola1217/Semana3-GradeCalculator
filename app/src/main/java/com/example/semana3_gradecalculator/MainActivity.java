package com.example.semana3_gradecalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout bgLayout;
    private EditText name;
    private Button settings;
    private Button next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bgLayout = findViewById (R.id.bg);
        name = findViewById (R.id.name);
        settings = findViewById (R.id.settings);
        next = findViewById (R.id.next);

        //goes to settings
        settings.setOnClickListener(

                (view) -> {

                    Intent i = new Intent(this, Settings.class);
                    startActivity(i);

                }
        );

        //goes to grades
        next.setOnClickListener(
                (v)->{
                    Intent i= new Intent(this, Grades.class);
                    i.putExtra("name",name.getText().toString());
                    name.setText("");
                    startActivity(i);
                }
        );

    }

    //bg color preference
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences colorP= getSharedPreferences("bgColors", MODE_PRIVATE);
        String bg= colorP.getString("color", "#FFFFFFFF");
        bgLayout.setBackgroundColor(Color.parseColor(bg));
    }
}