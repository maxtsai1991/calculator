package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText number1EditText, number2EditText;
    private TextView resultTextView;
    private char chosenOperator = '+'; // 預設運算符為加法

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
        number1EditText = findViewById(R.id.number1EditText);
        number2EditText = findViewById(R.id.number2EditText);
        resultTextView = findViewById(R.id.resultTextView);

        // 設置運算符按鈕的監聽器，保存選擇的運算符
        findViewById(R.id.addButton).setOnClickListener(v -> chosenOperator = '+');
        findViewById(R.id.subtractButton).setOnClickListener(v -> chosenOperator = '-');
        findViewById(R.id.multiplyButton).setOnClickListener(v -> chosenOperator = '*');
        findViewById(R.id.divideButton).setOnClickListener(v -> chosenOperator = '/');
        // 為等於按鈕設置監聽器，進行計算
        findViewById(R.id.equalButton).setOnClickListener(v -> calculate(chosenOperator));
        // 為清除按鈕設置監聽器
        findViewById(R.id.clearButton).setOnClickListener(v -> clearInputs());
    }

    private void calculate(char operator) {
        // 獲取輸入的數字
        int num1 = Integer.parseInt(number1EditText.getText().toString());
        int num2 = Integer.parseInt(number2EditText.getText().toString());
        int result = 0;

        // 根據選擇的運算符進行計算
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                // 防止除以0
                result = num2 != 0 ? num1 / num2 : 0;
                break;
        }

        // 顯示計算結果
        resultTextView.setText("結果: " + result);
    }

    private void clearInputs() {
        // 清除輸入框和結果顯示
        number1EditText.setText("");
        number2EditText.setText("");
        resultTextView.setText("Result");
    }
}

