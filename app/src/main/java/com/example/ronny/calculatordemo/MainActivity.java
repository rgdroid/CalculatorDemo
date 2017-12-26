package com.example.ronny.calculatordemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.javia.arity.Symbols;
import org.javia.arity.SyntaxException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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
        btn_two = (Button) findViewById(R.id.btn_number_two);
        btn_three = (Button) findViewById(R.id.btn_number_three);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        btn_clear = (Button) findViewById(R.id.btn_clear);

        btn_one.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_three.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_number_one:
                mResultString += "1";
                break;
            case R.id.btn_number_two:
                mResultString += "2";
                break;
            case R.id.btn_number_three:
                mResultString += "3";
                break;
            case R.id.btn_plus:
                mResultString += "+";
                break;
            case R.id.btn_equal:
                try {
                    Double result = symbols.eval(mResultString);
                    mResultString = Double.toString(result);
                } catch (SyntaxException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_clear:
                if (mResultString.length() > 0) {
                    mResultString = mResultString.substring(0, mResultString.length() - 1);
                }
                break;
        }
        tv_display_main.setText(mResultString);

    }
}
