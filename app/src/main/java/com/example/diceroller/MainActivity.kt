package com.example.diceroller

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var diceimage:ImageView
    lateinit var textshown:TextView
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textshown=findViewById(R.id.text_top)
        textshown.text="No Roles Yet"
        val firstimage:ImageView=findViewById(R.id.dice_image)
        firstimage.setImageResource(R.drawable.dice_1)
        val rollbutton:Button=findViewById(R.id.roll_button)//created class rollButton of type button and has an id (roll_button)
        // from which we can access the button in xml file.
        rollbutton.text = "Let's Roll" //using rollbutton variable , we changed the text.
        rollbutton.setOnClickListener{

            rolldice()
        }
        diceimage=findViewById(R.id.dice_image)
    }

    @SuppressLint("SetTextI18n")
    private fun rolldice() {
        val randomint= Random().nextInt(6)+1
        val drawableresource=when(randomint){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceimage.setImageResource(drawableresource)
        Toast.makeText(this, "Nice Roll Nibba!", Toast.LENGTH_SHORT).show()
        textshown.text="You got "+randomint
    }
}

