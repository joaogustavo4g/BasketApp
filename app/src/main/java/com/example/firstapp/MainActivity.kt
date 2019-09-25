package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // Score variables Data.
    private var scoreA: Int = 0
    private var scoreB: Int = 0

    // Punctuation Variables (Texts)
    // Using <lateinit> is so that variables are only started after they are filled
    // In "onCreate" function, so no need to initialize them agr
    private lateinit var pTeamA: TextView
    private lateinit var pTeamB: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Filling values ​​in punctuation variables (Texts),
        // based on Id that is in activity_main.xml code (android: id = "@ + id / <id_name>").
        pTeamA = findViewById(R.id.scoreTeamA)
        pTeamB = findViewById(R.id.scoreTeamB)


        // The buttons were initialized with <val>, thus making their values ​​unchanging
        // Is the same as declaring the variable as Final in Java

        // Team A score buttons
        val bThreePointsTeamA: Button = findViewById(R.id.threePointsA)
        val bTwoPointsTeamA: Button = findViewById(R.id.twoPointsA)
        val bFreeShotTeamA: Button = findViewById(R.id.freeShotA)

        // Team B score buttons
        val bThreePointsTeamB: Button = findViewById(R.id.threePointsB)
        val bTwoPointsTeamB: Button = findViewById(R.id.twoPointsB)
        val bFreeShotTeamB: Button = findViewById(R.id.freeShotB)

        // Button to restart the match
        val bRestartMatch: Button = findViewById(R.id.restartMatch)

        // Declaring clicks for buttons
        // Buttons of team "A"
        bThreePointsTeamA.setOnClickListener { addPoints(3, "A") }
        bTwoPointsTeamA.setOnClickListener { addPoints(2, "A") }
        bFreeShotTeamA.setOnClickListener { addPoints(1, "A") }

        // "B" Team Buttons
        bThreePointsTeamB.setOnClickListener { addPoints(3, "B") }
        bTwoPointsTeamB.setOnClickListener { addPoints(2, "B") }
        bFreeShotTeamB.setOnClickListener { addPoints(1, "B") }

        // "B" Team Buttons
        bRestartMatch.setOnClickListener { restartMatch() }
    }



    // Declaring function to score
    private fun addPoints(score: Int, team: String) {
        // Checking which team should be awarded points
        // values ​​are added to variables that were created outside the "onCreate" method
        // so getting available through the whole code
        if(team == "A") {
            scoreA += score
        } else {
            scoreB += score
        }
        updateScore(team)
    }

    // Declaring function to update text on screen
    private fun updateScore(time: String) {
        // Checking which team should be updated to score and so
        // <toString ()> is used to convert data to "String"
        // since <textView> only accepts this type of variable
        if(time == "A"){
            pTeamA.text = scoreA.toString()
        }else {
            pTeamB.text = scoreB.toString()
        }
    }


        // declaring the function to restart the match
        private fun restartMatch() {

            // All data will be reset and text will receive this data reset
            scoreA = 0
            pTeamA.text = scoreA.toString()
            scoreB = 0
            pTeamB.text = scoreB.toString()

            // Used <Toast> to display something similar to a popUp, warning that the score has been reset.
            Toast.makeText(this,"Score restarted",Toast.LENGTH_SHORT).show()
    }
}
