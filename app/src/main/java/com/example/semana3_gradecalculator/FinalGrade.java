package com.example.semana3_gradecalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class FinalGrade extends AppCompatActivity {

    private ConstraintLayout bgLayout4;
    private TextView name2;
    private TextView grade;
    private Button again;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_grade);

        //background
        bgLayout4 = findViewById (R.id.bg4);
        name2 = findViewById(R.id.name2);
        grade = findViewById(R.id.grade);
        again = findViewById(R.id.again);

        //calculate again button
        again.setOnClickListener(
                (view)->{

                    finish();
                }
        );

        finalName();
        finalGrade();

    }

    private void finalName(){

        String name= getIntent().getExtras().getString("name");
        name2.setText("Hola, " + name + ". \nTu nota final es de:");

    }

    private void finalGrade(){

        Double grades = getIntent().getExtras().getDouble("notaFinal");
        grade.setText("" + grades);

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences colorP= getSharedPreferences("bgColors", MODE_PRIVATE);
        String bg= colorP.getString("color", "#FFFFFFFF");
        bgLayout4.setBackgroundColor(Color.parseColor(bg));
    }

}