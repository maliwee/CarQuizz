package com.example.coursework1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class IdentifyCarActivity extends AppCompatActivity {
    ImageView image1_period1;
    ImageView image2_period2;
    ImageView image3_period3;
    TextView brandName;
    TextView answer;
    int randNum1;
    int randNum2;
    int randNum3;
    int randNum4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_car);

        Integer [] bmwCars={
                R.drawable.bmw1, R.drawable.bmw2, R.drawable.bmw3, R.drawable.bmw4, R.drawable.bmw5, R.drawable.bmw6, R.drawable.bmw7, R.drawable.bmw8, R.drawable.bmw9, R.drawable.bmw10,
        };

        Integer [] audiCars={
                R.drawable.audi1, R.drawable.audi2, R.drawable.audi3, R.drawable.audi4, R.drawable.audi5, R.drawable.audi6, R.drawable.audi7, R.drawable.audi8, R.drawable.audi9, R.drawable.audi10,
        };
        Integer [] fordCars={
                R.drawable.ford1, R.drawable.ford2, R.drawable.ford3, R.drawable.ford4, R.drawable.ford5, R.drawable.ford6, R.drawable.ford7, R.drawable.ford8, R.drawable.ford9, R.drawable.ford10
        };

        String [] brandNames={"BMW","Ford","Audi"};

        image1_period1=findViewById(R.id.img1);
        image2_period2=findViewById(R.id.img2);
        image3_period3=findViewById(R.id.img3);
        brandName=findViewById(R.id.brandName);
        answer=findViewById(R.id.result);
        Button button_toNext_stat = (Button)findViewById(R.id.button5);

        button_toNext_stat.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                answer.setText("");
                toNext(button_toNext_stat);

                Random random1 = new Random();
                randNum1 = random1.nextInt(bmwCars.length);
                image1_period1.setImageResource(bmwCars[randNum1]);

                Random random2 = new Random();
                randNum2 = random2.nextInt(audiCars.length);
                image2_period2.setImageResource(audiCars[randNum2]);

                Random random3 = new Random();
                randNum3 = random3.nextInt(fordCars.length);
                image3_period3.setImageResource(fordCars[randNum3]);

                Random random4 = new Random();
                randNum4 = random4.nextInt(brandNames.length);
                brandName.setText(brandNames[randNum4]);



                image1_period1.setOnClickListener(new View.OnClickListener(){


                    @Override
                    public void onClick(View v) {
                        answer.setText("");
                        if(randNum4 ==0){
                            answer.setTextColor(Color.GREEN);
                            answer.setText("Correct Answer");

                        } else {
                            answer.setTextColor(Color.RED);
                            answer.setText("Wrong  Answer");
                        }



                    }
                });

                image2_period2.setOnClickListener(new View.OnClickListener(){


                    @Override
                    public void onClick(View v) {
                        answer.setText("");
                        if(randNum4 ==2){
                            answer.setTextColor(Color.GREEN);
                            answer.setText("Correct Answer");

                        } else {
                            answer.setTextColor(Color.RED);
                            answer.setText("Wrong  Answer");
                        }



                    }
                });

                image3_period3.setOnClickListener(new View.OnClickListener(){


                    @Override
                    public void onClick(View v) {
                        answer.setText("");
                        if(randNum4 ==1){
                            answer.setTextColor(Color.GREEN);
                            answer.setText("Correct Answer");

                        } else {
                            answer.setTextColor(Color.RED);
                            answer.setText("Wrong  Answer");
                        }



                    }
                });



            }

            public void toNext(View v1){
                v1.setEnabled(true);
                Button button=(Button) v1;
                button_toNext_stat.setText("next");
            }
        });



    }


}