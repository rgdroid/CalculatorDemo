package com.example.ronny.calculatordemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.javia.arity.Symbols;
import org.javia.arity.SyntaxException;

public class MainActivity extends AppCompatActivity {

    private String mResultString = "";
    private TextView tv_display_main;

    private Button btn_one;
    private Button btn_two;
    private Button btn_three;
    private Button btn_plus;
    private Button btn_equal;
    private Button btn_clear;

    Symbols symbols = new Symbols();

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

        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mResultString += "+";
                tv_display_main.setText(mResultString);
            }
        });

        btn_equal = (Button) findViewById(R.id.btn_equal);
        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Double result = symbols.eval(mResultString);
                    mResultString = Double.toString(result);
                } catch (SyntaxException e) {
                    e.printStackTrace();
                }
                tv_display_main.setText(mResultString);
                //mResultString = "";
            }
        });

        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mResultString.length() > 0) {
                    mResultString = mResultString.substring(0, mResultString.length() - 1);
                }
                tv_display_main.setText(mResultString);
            }
        });
    }


}
