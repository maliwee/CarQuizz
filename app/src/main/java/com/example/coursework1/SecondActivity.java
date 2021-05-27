package com.example.coursework1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    ImageView imageView;
    Button startingButton;

    TextView right;
    TextView wrong;
    TextView real;

    int randNum;
    Integer [] cars;
    Spinner spinner;

    int selection;
    boolean started = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        spinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.Brands, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        imageView= findViewById(R.id.imageView1);
        startingButton=findViewById(R.id.start);
        //Results
        right=(TextView)findViewById(R.id.correct);
        wrong=(TextView)findViewById(R.id.wrong);
        real=(TextView)findViewById(R.id.real);



        cars= new Integer[]{
                R.drawable.bmw1, R.drawable.bmw2, R.drawable.bmw3, R.drawable.bmw4, R.drawable.bmw5, R.drawable.bmw6, R.drawable.bmw7, R.drawable.bmw8, R.drawable.bmw9, R.drawable.bmw10,
                R.drawable.audi1, R.drawable.audi2, R.drawable.audi3, R.drawable.audi4, R.drawable.audi5, R.drawable.audi6, R.drawable.audi7, R.drawable.audi8, R.drawable.audi9, R.drawable.audi10,
                R.drawable.ford1, R.drawable.ford2, R.drawable.ford3, R.drawable.ford4, R.drawable.ford5, R.drawable.ford6, R.drawable.ford7, R.drawable.ford8, R.drawable.ford9, R.drawable.ford10
        };

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selection = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        startingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStartButtonClick();
            }
        });




    }
    public void forNext(View v1){
        v1.setEnabled(true);
        Button button=(Button) v1;
    }

    private void onStartButtonClick() {
        if(!started) {
            wrong.setText("");
            right.setText(" ");
            real.setText(" ");

            spinner.setVisibility(View.VISIBLE);

            startingButton.setText("Identify");
            started = true;

            Random random = new Random();
            randNum = random.nextInt(cars.length);
            imageView.setImageResource(cars[randNum]);
        } else {
            checkAnswer();
            startingButton.setText("Next");
            started = false;
        }
    }

    private void checkAnswer() {
        if(randNum>=0 && randNum<=9 && selection==2){
            right.setTextColor(Color.GREEN);
            right.setText("Your Answer is Correct");
        }
        else if(randNum>=0 && randNum<=9 && selection!=2){
            wrong.setTextColor(Color.RED);
            real.setTextColor(Color.YELLOW);
            real.setText("BMW");
            wrong.setText(" Your Answer is Wrong");
        }
        if (randNum>=10 && randNum<=19 && selection==1){
            right.setTextColor(Color.GREEN);
            right.setText("Your Answer is Correct");
        }
        else if (randNum>=10 && randNum<=19 && selection !=1){
            wrong.setTextColor(Color.RED);
            real.setTextColor(Color.YELLOW);
            real.setText("Audi");
            wrong.setText("Your Answer is Wrong");
        }
        if (randNum>=20 && randNum<=29 && selection==3){
            right.setTextColor(Color.GREEN);
            right.setText("Your Answer is Correct");
        }
        else if (randNum>=20 && randNum<=29 && selection !=3){
            real.setTextColor(Color.YELLOW);
            wrong.setTextColor(Color.RED);
            real.setText("Ford");
            wrong.setText("Your Answer is Wrong");
        }
    }

}