package com.example.semana3_gradecalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Grades extends AppCompatActivity {

    private ConstraintLayout bgLayout3;
    private EditText nota1;
    private EditText nota2;
    private EditText nota3;
    private EditText nota4;
    private EditText nota5;
    private Button finalNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades);

        //background
        bgLayout3 = findViewById (R.id.bg3);
        //notes
        nota1 = findViewById (R.id.nota1);
        nota2 = findViewById (R.id.nota2);
        nota3 = findViewById (R.id.nota3);
        nota4 = findViewById (R.id.nota4);
        nota5 = findViewById (R.id.nota5);
        //next button
        finalNote = findViewById (R.id.next2);


        String name= getIntent().getExtras().getString("name");

        finalNote.setOnClickListener(
                (view)->{

                    double grade1 = Double.parseDouble(nota1.getText().toString());
                    double grade2 = Double.parseDouble(nota2.getText().toString());
                    double grade3 = Double.parseDouble(nota3.getText().toString());
                    double grade4 = Double.parseDouble(nota4.getText().toString());
                    double grade5 = Double.parseDouble(nota5.getText().toString());

                    double finalGrade = ((grade1*0.15) + (grade2*0.15) + (grade3*0.20) + (grade4*0.25) + (grade5*0.25));

                    Intent i= new Intent(this, FinalGrade.class);
                    i.putExtra("name",name);

                    //project1
                    i.putExtra("notaFinal",finalGrade);
                    nota1.setText("");

                    startActivity(i);
                    finish();
                }
        );

    }



    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences colorP= getSharedPreferences("bgColors", MODE_PRIVATE);
        String bg= colorP.getString("color", "#FFFFFFFF");
        bgLayout3.setBackgroundColor(Color.parseColor(bg));
    }

}