package com.example.hensh.buttonmatrix;


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

    int rows = 3;
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


        int textViewCount = 9;
        final TextView[] textViewArray = new TextView[textViewCount];
        for (int i = 0; i < textViewCount; i++) {
            textViewArray[i] = new TextView(this);
        }

        for (int j = 0; j < 9; j += 3) {
            for (int i = 0; i < 3; i++) {
                textViewArray[j + i].setWidth(300);
                textViewArray[j + i].setHeight(300);
                textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.cellcolor, getTheme()));
                linearLayoutRows[j / 3].addView(textViewArray[j + i]);
            }
        }




        diagonal = (Button) findViewById(R.id.Diagonal);

        diagonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int j = 0; j < 9; j += 3) {
                    for (int i = 0; i < 3; i++) {
                        textViewArray[j + i].setWidth(300);
                        textViewArray[j + i].setHeight(300);
                        textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.cellcolor, getTheme()));
                        //for the first diagonal
                        if(j/3 == i) {
                            textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.cellcolormark, getTheme()));
                        }

                        if(j/3 + i == 2) {
                            textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.cellcolormark, getTheme()));
                        }
                    }
                }

            }
        });

        borders = (Button) findViewById(R.id.Border);

        borders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int j = 0; j < 9; j += 3) {
                    for (int i = 0; i < 3; i++) {
                        textViewArray[j + i].setWidth(300);
                        textViewArray[j + i].setHeight(300);
                        textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.cellcolor, getTheme()));

                        if(j == 0 || j/3 == 2 || i == 0 || i == 2) {
                            textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.cellcolormark, getTheme()));
                        }
                    }
                }

            }
        });


        upperTrangle = (Button) findViewById(R.id.UpperTriangle);

        upperTrangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int j = 0; j < 9; j += 3) {
                    for (int i = 0; i < 3; i++) {
                        textViewArray[j + i].setWidth(300);
                        textViewArray[j + i].setHeight(300);
                        textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.cellcolor, getTheme()));

                        if(j/3 == i) {
                            textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.cellcolormark, getTheme()));
                        }

                        if(i > j/3){
                            textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.cellcolormark, getTheme()));
                        }
                    }
                }

            }
        });

        bottomTrangle = (Button) findViewById(R.id.UnderTrinagle);

        bottomTrangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int j = 0; j < 9; j += 3) {
                    for (int i = 0; i < 3; i++) {
                        textViewArray[j + i].setWidth(300);
                        textViewArray[j + i].setHeight(300);
                        textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.cellcolor, getTheme()));

                        if(j/3 == i) {
                            textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.cellcolormark, getTheme()));
                        }

                        if(j/3 > i){
                            textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.cellcolormark, getTheme()));
                        }
                    }
                }

            }
        });

    }



}
