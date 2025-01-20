package com.example.app1trueseason2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private TextView n1;
    private TextView n2;
    private TextView answer;
    private TextView fall, right;
    private int count1,count2;
    Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n1=findViewById(R.id.num1);
        n2 = findViewById(R.id.num2);
        answer = findViewById(R.id.result);
        right = findViewById(R.id.True);
        fall = findViewById(R.id.False);
        btn1 = findViewById(R.id.BASIC);
        btn2 = findViewById(R.id.MED);
        btn3 = findViewById(R.id.PRO);


    }

    public void level1(View view) {
        n1.setText(String.valueOf(random(0, 9)));
        n2.setText(String.valueOf(random(0, 9)));
    }

    public void level2(View view) {
        n1.setText(String.valueOf(random(0, 9)));
        n2.setText(String.valueOf(random(10, 99)));
    }

    public void level3(View view) {
        n1.setText(String.valueOf(random(10, 99)));
        n2.setText(String.valueOf(random(10, 99)));
    }

    public int random(int n1, int n2) {
        Random newr = new Random();
        return newr.nextInt((n2-n1)+1)+n1;
    }
    public void check(View view) {
        if (!answer.getText().toString().isEmpty()) {
            int answeruser= Integer.parseInt(answer.getText().toString());
            int answerright = Integer.parseInt(n1.getText().toString()) * Integer.parseInt(n2.getText().toString());
            if (answeruser == answerright) {
                Toast.makeText(this, "True", Toast.LENGTH_SHORT).show();
                count1++;
                right.setText(String.valueOf(count1));
            } else {
                Toast.makeText(this, "False", Toast.LENGTH_SHORT).show();
                count2++;
                fall.setText(String.valueOf(count2));
            }
        }
        else {
            Toast.makeText(this, "Please enter a valid answer", Toast.LENGTH_SHORT).show();
        }
    }
}
