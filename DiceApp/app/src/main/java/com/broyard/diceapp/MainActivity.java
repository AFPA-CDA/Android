package com.broyard.diceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.NumberPicker;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // Unique identifiers used for the intents
    public static final String DICE_RESULT = "com.broyard.diceapp.MainActivity.dice_result";
    public static final String FACES_NUMBER = "com.broyard.diceapp.MainActivity.faces_number";

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Calls the parent class's constructor
        super.onCreate(savedInstanceState);

        // Sets the current content view
        setContentView(R.layout.activity_main);
    }

    /**
     * Throw the dice and return the result to another activity
     */
    public void throwDice(View view) {
        // Creates a new intent for the DiceResultActivity class
        Intent intent = new Intent(this, DiceResultActivity.class);

        // Retrieves the faces_number edit text
        EditText facesNumberEditText = findViewById(R.id.faces_number);

        // Gets the faces number for the dice
        String facesNumber = facesNumberEditText.getText().toString();

        // Fills the FACES_NUMBER intent with the number of faces given by the user
        intent.putExtra(FACES_NUMBER, facesNumber);

        // Creates a new random object
        Random random = new Random();

        // Generates a random result based on the number of faces
        int diceResult = random.nextInt((Integer.parseInt(facesNumber) - 1) + 1) + 1;

        // Fills the DICE_RESULT intent with the dice result
        intent.putExtra(DICE_RESULT, diceResult);

        // Starts the activity with the current intent
        startActivity(intent);
    }
}