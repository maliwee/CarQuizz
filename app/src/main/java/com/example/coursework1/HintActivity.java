package com.example.coursework1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class HintActivity extends AppCompatActivity {
    Integer[] carIds;

    TextView wordView;
    TextView resultView;
    EditText guessedText;
    ImageView imageView;
    Button btnSubmit;

    int currentIndex;
    String currentBrand;
    Integer currentImage;

    String currentGuess;
    int guessCount = 0;

    boolean gameOver = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);

        carIds = new Integer[]{
                R.drawable.bmw1, R.drawable.bmw2, R.drawable.bmw3, R.drawable.bmw4, R.drawable.bmw5, R.drawable.bmw6, R.drawable.bmw7, R.drawable.bmw8, R.drawable.bmw9, R.drawable.bmw10,
                R.drawable.audi1, R.drawable.audi2, R.drawable.audi3, R.drawable.audi4, R.drawable.audi5, R.drawable.audi6, R.drawable.audi7, R.drawable.audi8, R.drawable.audi9, R.drawable.audi10,
                R.drawable.ford1, R.drawable.ford2, R.drawable.ford3, R.drawable.ford4, R.drawable.ford5, R.drawable.ford6, R.drawable.ford7, R.drawable.ford8, R.drawable.ford9, R.drawable.ford10
        };

        wordView = findViewById(R.id.tvWord);
        resultView = findViewById(R.id.tvResult);
        guessedText = findViewById(R.id.edtxtGuess);
        imageView = findViewById(R.id.imgHint);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {
                onButtonClick();
            }
        });
        setUI();
    }

    private void setUI() {
        pickNewImage();

        wordView.setText(currentGuess);
        wordView.setTextColor(Color.parseColor("#000000"));
        btnSubmit.setText(getString(R.string.btn_submit_Hint));
        imageView.setImageResource(currentImage);
        imageView.setVisibility(View.VISIBLE);
        guessedText.setText("");
        resultView.setVisibility(View.INVISIBLE);
        hideKeyboard();
    }

    private void onButtonClick() {
        if(!gameOver) {
            String letter = guessedText.getText().toString();
            if(letter != null && !letter.equals("")) {
                checkLetter(letter);
                guessedText.setText("");
            }
        } else {
            setUI();
            gameOver = false;
        }
    }

    private void pickNewImage() {
        Random rand = new Random();
        int newInt = rand.nextInt(30);
        while(currentIndex == newInt) {
            newInt = rand.nextInt(30);
        }
        currentIndex = newInt;
        currentImage = carIds[currentIndex];

        String name = getResources().getResourceEntryName(currentImage);
        if(name.contains("bmw")) {
            currentBrand = "BMW";
            currentGuess = "___";
        } else if(name.contains("audi")) {
            currentBrand = "AUDI";
            currentGuess = "____";
        } else if(name.contains("ford")) {
            currentBrand = "FORD";
            currentGuess = "____";
        }
    }

    private void checkLetter(String letter) {
        if(correctGuess(letter) && !alreadyGuessed(letter)) {
            updateGuess(letter);
            if(currentGuess.equals(currentBrand)) {
                wonTheGame();
            }
        } else {
            guessCount++;
            if(guessCount == 3) {
                lostTheGame();
            }
        }
    }

    private boolean correctGuess(String letter) {
        char c;
        c = letter.toLowerCase().toCharArray()[0];

        for (int i=0;i < currentBrand.length(); i++) {
            char w = currentBrand.toLowerCase().charAt(i);
            if (w == c) {
                return true;
            }
        }
        return false;
    }

    private boolean alreadyGuessed(String letter) {
        char c;
        c = letter.toLowerCase().toCharArray()[0];

        for (int i=0;i < currentGuess.length(); i++) {
            char w = currentGuess.toLowerCase().charAt(i);
            if (w == c) {
                return true;
            }
        }
        return false;
    }

    private void updateGuess(String letter){
        for (int i = 0; i < currentBrand.length(); i++) {
            char c = currentBrand.toLowerCase().charAt(i);
            if (c == letter.toLowerCase().toCharArray()[0]) {
                currentGuess = currentGuess.substring(0,i) + c + currentGuess.substring(i+1,currentGuess.length());
            }
        }
        currentGuess = currentGuess.toUpperCase();
        wordView.setText(currentGuess);
    }

    private void wonTheGame() {
        hideKeyboard();
        guessedText.clearFocus();
        resultView.setText(getString(R.string.result_correct_hint));
        resultView.setTextColor(Color.parseColor("#2cab0f"));
        resultView.setVisibility(View.VISIBLE);
        gameOver = true;
        btnSubmit.setText(getString(R.string.btn_next_Hint));
    }

    private void lostTheGame() {
        hideKeyboard();
        guessedText.clearFocus();
        resultView.setText(getString(R.string.result_incorrect_hint));
        resultView.setTextColor(Color.parseColor("#ab140f"));
        resultView.setVisibility(View.VISIBLE);
        gameOver = true;
        btnSubmit.setText(getString(R.string.btn_next_Hint));
        wordView.setText(currentBrand);
        wordView.setTextColor(Color.parseColor("#edaa1a"));
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0);
    }
}