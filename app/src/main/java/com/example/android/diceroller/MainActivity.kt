package com.example.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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

        // Do a dice roll when the app starts
        rollDice()

    }

    /**
     * Roll the dice and update the screen with the result.
     */

    private fun rollDice() {
        // Create 2 new Dice object with 6 sides and roll it
        val dice1 = Dice(6)
        val diceRolled1 = dice1.roll()

        // Update the screen with the dice roll
        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)
        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when(diceRolled1){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = diceRolled1.toString()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}