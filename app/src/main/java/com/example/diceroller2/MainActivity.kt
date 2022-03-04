package com.example.diceroller2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView


/**
 * This activity allows the user to roll a dice and view the result on the screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }
        rollDice()


    }

    /**
     * Roll the dice and update the screen with the result
     */
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()


        val dice1 = Dice1(6)
        val diceRoll1 = dice1.roll1()

        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)


        val drawableResource1 = when (diceRoll1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            4 -> R.drawable.dice_3
            3 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage2.setImageResource(drawableResource1)


        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            4 -> R.drawable.dice_3
            3 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
    }


    /**
     * Creates Dice class and roll function
     */
    class Dice(private val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }

    }
    /**
     * Creates Dice class for second dice and roll function
     */
    class Dice1(private val sidesno: Int) {
        fun roll1(): Int {
            return (1..sidesno).random()
        }
    }
}
