package com.example.ronny.calculatordemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String mResultString = "";
    private TextView tv_display_main;

    private Button btn_one;
    private Button btn_two;
    private Button btn_three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_display_main = findViewById(R.id.tv_display);

        btn_one = (Button) findViewById(R.id.btn_number_one);
        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mResultString += "1";
                tv_display_main.setText(mResultString);
            }
        });

        btn_two = (Button) findViewById(R.id.btn_number_two);
        btn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mResultString += "2";
                tv_display_main.setText(mResultString);
            }
        });

        btn_three = (Button) findViewById(R.id.btn_number_three);
        btn_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mResultString += "3";
                tv_display_main.setText(mResultString);
            }
        });
    }


}
