package com.infixtopostfix.postfixcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView tvInfix, tvPostfix, tvResult;
    private StringBuilder currentExpression = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvInfix = findViewById(R.id.tvInfix);
        tvPostfix = findViewById(R.id.tvPostfix);
        tvResult = findViewById(R.id.tvResult);

        int[] buttonIds = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
                R.id.btnPlus, R.id.btnMinus, R.id.btnMultiply, R.id.btnDivide,
                R.id.btnDot, R.id.btnOpenParen, R.id.btnCloseParen
        };

        View.OnClickListener listener = v -> {
            Button b = (Button) v;
            String text = b.getText().toString();

            switch (text) {
                case "×": text = "*"; break;
                case "÷": text = "/"; break;
                case "−": text = "-"; break;
            }

            currentExpression.append(text);
            tvInfix.setText(currentExpression.toString());
        };

        for (int id : buttonIds) {
            findViewById(id).setOnClickListener(listener);
        }

        findViewById(R.id.btnEquals).setOnClickListener(v -> {
            try {
                String infix = currentExpression.toString();
                String postfix = InfixToPostfixConverter.convert(infix);
                double result = PostfixEvaluator.evaluate(postfix);

                tvPostfix.setText(postfix);
                tvResult.setText(String.valueOf(result));
            } catch (Exception e) {
                tvResult.setText("Error");
            }
        });

        findViewById(R.id.btnClear).setOnClickListener(v -> {
            currentExpression.setLength(0);
            tvInfix.setText("");
            tvPostfix.setText("");
            tvResult.setText("");
        });

        findViewById(R.id.btnDelete).setOnClickListener(v -> {
            if (currentExpression.length() > 0) {
                currentExpression.deleteCharAt(currentExpression.length() - 1);
                tvInfix.setText(currentExpression.toString());
            }
        });
    }
}
