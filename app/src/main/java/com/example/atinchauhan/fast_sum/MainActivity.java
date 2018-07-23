package com.example.atinchauhan.fast_sum;

import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView problemTextView;
    Button goButton;
    int correctAnswerLocation;
    TextView  correctTextView;
    TextView countTextView;
    TextView timeTextView;
    Button playAgain;
    ConstraintLayout subLayout;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    int score=0;
    int question=0;
    ArrayList<Integer>answer=new ArrayList<Integer>();

    public void chooseAnswer(View view)
    {
        Integer.toString(correctAnswerLocation);
        view.getTag().toString();
        if(Integer.toString(correctAnswerLocation).equals(   view.getTag().toString()))
        {
            correctTextView.setText("Correct:)");
            score++;
        }
        else{
            correctTextView.setText("Wrong:(");
        }
        question++;
        countTextView.setText(Integer.toString(score)+" / "+Integer.toString(question));

        newQuestion();
    }

    public void start(View view)
    {
        goButton.setVisibility(View.INVISIBLE);

        subLayout.setVisibility(View.VISIBLE);

        playAgain(findViewById(R.id.timeTextView));
    }

    public void playAgain(View view){
        button0.setEnabled(true);
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        playAgain.setVisibility(View.INVISIBLE);
        score=0;
        question=0;
        timeTextView.setText("30s");
        newQuestion();
        correctTextView.setText("");
        countTextView.setText(Integer.toString(score)+" / "+Integer.toString(question));
        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long l) {
                timeTextView.setText(String.valueOf(l/1000)+"s");
            }

            @Override
            public void onFinish() {
                correctTextView.setText("Done!");
                playAgain.setVisibility(View.VISIBLE);
                button0.setEnabled(false);
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);

            }
        }.start();

    }

    public void newQuestion(){

        Random r = new Random();

        int a = r.nextInt(51);
        int b= r.nextInt(51);
        problemTextView.setText(Integer.toString(a)+" + "+Integer.toString(b));
        correctAnswerLocation=r.nextInt(4);
        answer.clear();
        for(int i=0;i<4;i++)
        {
            if(i==correctAnswerLocation)
            {
                answer.add(a + b);
            }
            else
            {
                int wrongAnswer;
                wrongAnswer=r.nextInt(100);
                while(wrongAnswer==a+b)
                {
                    wrongAnswer=r.nextInt(100);
                }
                answer.add(wrongAnswer);
            }
        }
        button0.setText(Integer.toString(answer.get(0)));

        button1.setText(Integer.toString(answer.get(1)));

        button2.setText(Integer.toString(answer.get(2)));

        button3.setText(Integer.toString(answer.get(3)));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goButton=findViewById(R.id.goButton);
        problemTextView=findViewById(R.id.problemTextView);
        correctTextView=findViewById(R.id.correctTextView);
        countTextView=findViewById(R.id.countTextView);
        timeTextView=findViewById(R.id.timeTextView);
        playAgain=findViewById(R.id.playAgainButton);
        subLayout=findViewById(R.id.subLayout);

        button0=findViewById(R.id.button0);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        goButton.setVisibility(View.VISIBLE);
        button3=findViewById(R.id.button3);
        goButton.setVisibility(View.VISIBLE);
        subLayout.setVisibility(View.INVISIBLE);




    }
}
