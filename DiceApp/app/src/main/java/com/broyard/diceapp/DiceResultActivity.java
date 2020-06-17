package com.broyard.diceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class DiceResultActivity extends AppCompatActivity {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Calls the parent class's constructor
        super.onCreate(savedInstanceState);

        // Sets the current content view
        setContentView(R.layout.activity_dice_result);

        // Retrieves the intent
        Intent intent = getIntent();

        // Gets the deice result from the intent
        int diceResult = intent.getIntExtra(MainActivity.DICE_RESULT, 0);

        // Gets the number of faces from the intent
        String facesNumber = intent.getStringExtra(MainActivity.FACES_NUMBER);

        // Gets the dice_info TextView
        TextView diceInfo = findViewById(R.id.dice_info);

        // Gets the throw_result TextView
        TextView throwResult = findViewById(R.id.throw_result);

        // Sets the dice_info and throw_result texts
        diceInfo.setText(getResources().getString(R.string.dice_info, facesNumber));
        throwResult.setText(String.format("%s", diceResult));
    }
}