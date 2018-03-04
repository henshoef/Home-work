package com.example.android.test;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button diagonal;
    private Button borders;
    private Button bottomTrangle;
    private Button upperTrangle;

    private LinearLayout mainLayout;

  final  int rows = 3;
    LinearLayout[] linearLayoutRows = new LinearLayout[rows];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = (LinearLayout) findViewById(R.id.MatrixLO);




        for (int i = 0; i < rows; i++) {
            linearLayoutRows[i] = new LinearLayout(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.gravity = Gravity.CENTER;
            linearLayoutRows[i].setLayoutParams(layoutParams);
            mainLayout.addView(linearLayoutRows[i]);
        }


       final int textViewCount = rows*rows;
        final TextView[] textView = new TextView[textViewCount];
        for (int i = 0; i < textViewCount; i++) {
            textView[i] = new TextView(this);
        }

        for (int j = 0; j < textViewCount; j += rows) {
            for (int i = 0; i < rows; i++) {
                textView[j + i].setWidth(900/rows);
                textView[j + i].setHeight(900/rows);
                textView[j + i].setBackground(getResources().getDrawable(R.drawable.cellcolor, getTheme()));
                linearLayoutRows[j / rows].addView(textView[j + i]);
            }
        }




        diagonal = (Button) findViewById(R.id.Diagonal);

        diagonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int j = 0; j < textViewCount; j += rows) {
                    for (int i = 0; i < rows; i++) {
                        textView[j + i].setWidth(900/rows);
                        textView[j + i].setHeight(900/rows);
                        textView[j + i].setBackground(getResources().getDrawable(R.drawable.cellcolor, getTheme()));

                        if(j/rows == i) {
                            textView[j + i].setBackground(getResources().getDrawable(R.drawable.cellcolormark, getTheme()));
                        }

                        if(j/rows + i == (rows-1)) {
                            textView[j + i].setBackground(getResources().getDrawable(R.drawable.cellcolormark, getTheme()));
                        }
                    }
                }

            }
        });

        borders = (Button) findViewById(R.id.Border);

        borders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int j = 0; j < textViewCount; j += rows) {
                    for (int i = 0; i < rows; i++) {
                        textView[j + i].setWidth(900/rows);
                        textView[j + i].setHeight(900/rows);
                        textView[j + i].setBackground(getResources().getDrawable(R.drawable.cellcolor, getTheme()));

                        if(j == 0 || j/rows == (rows-1) || i == 0 || i == (rows-1)) {
                            textView[j + i].setBackground(getResources().getDrawable(R.drawable.cellcolormark, getTheme()));
                        }
                    }
                }

            }
        });


        upperTrangle = (Button) findViewById(R.id.UpperTriangle);

        upperTrangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int j = 0; j < textViewCount; j += rows) {
                    for (int i = 0; i < rows; i++) {
                        textView[j + i].setWidth(900/rows);
                        textView[j + i].setHeight(900/rows);
                        textView[j + i].setBackground(getResources().getDrawable(R.drawable.cellcolor, getTheme()));

                        if(j/rows == i) {
                            textView[j + i].setBackground(getResources().getDrawable(R.drawable.cellcolormark, getTheme()));
                        }

                        if(i > j/rows){
                            textView[j + i].setBackground(getResources().getDrawable(R.drawable.cellcolormark, getTheme()));
                        }
                    }
                }

            }
        });

        bottomTrangle = (Button) findViewById(R.id.UnderTrinagle);

        bottomTrangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int j = 0; j <textViewCount; j += rows) {
                    for (int i = 0; i < rows; i++) {
                        textView[j + i].setWidth(900/rows);
                        textView[j + i].setHeight(900/rows);
                        textView[j + i].setBackground(getResources().getDrawable(R.drawable.cellcolor, getTheme()));

                        if(j/rows == i) {
                            textView[j + i].setBackground(getResources().getDrawable(R.drawable.cellcolormark, getTheme()));
                        }

                        if(j/rows > i){
                            textView[j + i].setBackground(getResources().getDrawable(R.drawable.cellcolormark, getTheme()));
                        }
                    }
                }

            }
        });

    }



}