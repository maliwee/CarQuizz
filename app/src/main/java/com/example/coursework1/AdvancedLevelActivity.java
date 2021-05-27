package com.example.coursework1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class AdvancedLevelActivity extends AppCompatActivity {
    ImageView image01_period01,image02_period02,image03_period03;
    EditText editable_txt1,editable_txt2,editable_txt3;
    TextView result_1,result_2,result_3,result_4;
    int randNum01, randNum02, randNum03;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_level);


        Integer [] BmwCars={
                R.drawable.bmw1, R.drawable.bmw2, R.drawable.bmw3, R.drawable.bmw4, R.drawable.bmw5, R.drawable.bmw6, R.drawable.bmw7, R.drawable.bmw8, R.drawable.bmw9, R.drawable.bmw10,
        };

        Integer [] AudiCars={
                R.drawable.audi1, R.drawable.audi2, R.drawable.audi3, R.drawable.audi4, R.drawable.audi5, R.drawable.audi6, R.drawable.audi7, R.drawable.audi8, R.drawable.audi9, R.drawable.audi10,
        };
        Integer [] FordCars={
                R.drawable.ford1, R.drawable.ford2, R.drawable.ford3, R.drawable.ford4, R.drawable.ford5, R.drawable.ford6, R.drawable.ford7, R.drawable.ford8, R.drawable.ford9, R.drawable.ford10
        };

        editable_txt1=findViewById(R.id.eTxt1);
        editable_txt2=findViewById(R.id.eTxt2);
        editable_txt3=findViewById(R.id.eTxt3);

        image01_period01=findViewById(R.id.img01);
        image02_period02=findViewById(R.id.img02);
        image03_period03=findViewById(R.id.img03);
        Button button_to_submit = (Button)findViewById(R.id.submitButton);


        Random random01 = new Random();
        randNum01 = random01.nextInt(BmwCars.length);
        image01_period01.setImageResource(BmwCars[randNum01]);

        Random random02 = new Random();
        randNum02 = random02.nextInt(AudiCars.length);
        image02_period02.setImageResource(AudiCars[randNum02]);

        Random random03 = new Random();
        randNum03 = random03.nextInt(FordCars.length);
        image03_period03.setImageResource(FordCars[randNum03]);

        result_1=findViewById(R.id.result1);
        result_2=findViewById(R.id.result2);
        result_3=findViewById(R.id.result3);
        result_4=findViewById(R.id.wholeResult);

        button_to_submit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                checkAnswers();
                tooNext(button_to_submit);
            }
            public void tooNext(View v){
                button_to_submit.setText("next");
                finish();
                startActivity(getIntent());}
        });

    }

    private void checkAnswers() {
        String stringValue1 =editable_txt1.getText().toString().toUpperCase();
        String stringValue2 =editable_txt2.getText().toString().toUpperCase();
        String stringValue3 =editable_txt3.getText().toString().toUpperCase();

        if (stringValue1.equals("BMW")) {
            editable_txt1.setEnabled(false);
            editable_txt1.setTextColor(Color.GREEN);
            editable_txt1.setText("BMW");
        }else{ editable_txt1.setTextColor(Color.RED);
            result_1.setTextColor(Color.YELLOW);
            result_1.setText("BMW"); }

        if (stringValue2.equals("AUDI")) {
            editable_txt2.setEnabled(false);
            editable_txt2.setTextColor(Color.GREEN);
            editable_txt2.setText("AUDI");
        }else{
            editable_txt2.setTextColor(Color.RED);
            result_2.setTextColor(Color.YELLOW);
            result_2.setText("AUDI"); }

        if (stringValue3.equals("FORD")) {
            editable_txt3.setEnabled(false);
            editable_txt3.setTextColor(Color.GREEN);
            editable_txt3.setText("FORD");
        }else{
            editable_txt3.setTextColor(Color.RED);
            result_3.setTextColor(Color.YELLOW);
            result_3.setText("FORD"); }
    }

}