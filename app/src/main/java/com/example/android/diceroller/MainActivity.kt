package com.example.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Join the UI button to add a onClick Listener to Roll the Dice
        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener{
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()
            rollDice()
        }

    }

    /**
     * Roll the dice and update the screen with the result.
     */

    private fun rollDice() {
        // Create 2 new Dice object with 6 sides and roll it
        val dice1 = Dice(6)
        val dice2 = Dice(6)

        val diceRolled1 = dice1.roll()
        val diceRolled2 = dice2.roll()

        // Update the screen with the dice roll
        val resultTextView1: TextView = findViewById(R.id.textView)
        val resultTextView2: TextView = findViewById(R.id.textView3)

        resultTextView1.text= "$diceRolled1"
        resultTextView2.text= "$diceRolled2"
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}