package com.example.coursework1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void launchHintActivity(View view) {
        Intent intent = new Intent(this, HintActivity.class);
        startActivity(intent);
    }

    public void launchIdentifyCarActivity(View view) {
        Intent intent = new Intent(this, IdentifyCarActivity.class);
        startActivity(intent);
    }

    public void launchAdvancedLevelActivity(View view) {
        Intent intent = new Intent(this, AdvancedLevelActivity.class);
        startActivity(intent);

    }
}