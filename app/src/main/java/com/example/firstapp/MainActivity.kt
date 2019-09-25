package com.example.firstapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // Score variables Data.
    private var scoreA: Int = 0
    private var scoreB: Int = 0

    // FoulsTeams
    private var foulsA: Int = 0
    private var foulsB: Int = 0
    private var tfoulsA: Int = 0
    private var tfoulsB: Int = 0

    // Punctuation Variables (Texts)
    // Using <lateinit> is so that variables are only started after they are filled
    // In "onCreate" function, so no need to initialize them agr
    private lateinit var pTeamA: TextView
    private lateinit var pTeamB: TextView

    //FoulsTeams
    private lateinit var fTeamA: TextView
    private lateinit var fTeamB: TextView
    private lateinit var tAfouls: TextView
    private lateinit var tBfouls: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Filling values ​​in punctuation variables (Texts),
        // based on Id that is in activity_main.xml code (android: id = "@ + id / <id_name>").
        pTeamA = findViewById(R.id.scoreTeamA)
        pTeamB = findViewById(R.id.scoreTeamB)
        fTeamA = findViewById(R.id.foulsTeamA)
        fTeamB = findViewById(R.id.foulsTeamB)

        //FoulsTeams
        fTeamA = findViewById(R.id.foulsTeamA)
        fTeamB = findViewById(R.id.foulsTeamB)
        tAfouls = findViewById(R.id.teamAfouls)
        tBfouls = findViewById(R.id.teamBfouls)

        // The buttons were initialized with <val>, thus making their values ​​unchanging
        // Is the same as declaring the variable as Final in Java

        // Team A score buttons
        val bThreePointsTeamA: Button = findViewById(R.id.threePointsA)
        val bTwoPointsTeamA: Button = findViewById(R.id.twoPointsA)
        val bFreeShotTeamA: Button = findViewById(R.id.freeShotA)
        val bFoulsA: Button = findViewById(R.id.addfoulsA)
        val bRestartFoulsA: Button = findViewById(R.id.foulsZeroA)

        // Team B score buttons
        val bThreePointsTeamB: Button = findViewById(R.id.threePointsB)
        val bTwoPointsTeamB: Button = findViewById(R.id.twoPointsB)
        val bFreeShotTeamB: Button = findViewById(R.id.freeShotB)
        val bFoulsB: Button = findViewById(R.id.addfoulsB)
        val bRestartFoulsB: Button = findViewById(R.id.foulsZeroB)

        // Button to restart the match
        val bRestartMatch: Button = findViewById(R.id.restartMatch)


        // Declaring clicks for buttons
        // Buttons of team "A"
        bThreePointsTeamA.setOnClickListener { addPoints(3, "A") }
        bTwoPointsTeamA.setOnClickListener { addPoints(2, "A") }
        bFreeShotTeamA.setOnClickListener { addPoints(1, "A") }
        bRestartFoulsA.setOnClickListener { restartFouls("A") }
        bFoulsA.setOnClickListener { (addfouls("A")) }

        // "B" Team Buttons
        bThreePointsTeamB.setOnClickListener { addPoints(3, "B") }
        bTwoPointsTeamB.setOnClickListener { addPoints(2, "B") }
        bFreeShotTeamB.setOnClickListener { addPoints(1, "B") }
        bRestartFoulsB.setOnClickListener { restartFouls("B") }
        bFoulsB.setOnClickListener { (addfouls("B")) }

        // Restart Match Buttons
        bRestartMatch.setOnClickListener { restartMatch() }
    }


    // Declaring function to score
    private fun addPoints(score: Int, team: String) {
        // Checking which team should be awarded points
        // values ​​are added to variables that were created outside the "onCreate" method
        // so getting available through the whole code
        if (team == "A") {
            scoreA += score
        } else {
            scoreB += score
        }
        updateScore(team)
    }

    // Declaring function to update text on screen
    private fun updateScore(team: String) {
        // Checking which team should be updated to score and so
        // <toString ()> is used to convert data to "String"
        // since <textView> only accepts this type of variable
        if (team == "A") {
            pTeamA.text = scoreA.toString()
        } else {
            pTeamB.text = scoreB.toString()
        }
    }


    // declaring the function to restart the match
    private fun restartMatch() {

        // All data will be reset and text will receive this data reset
        scoreA = 0
        foulsA = 0
        pTeamA.text = "0"
        fTeamA.text = "0"
        tAfouls.text = "Faltas: 0"

        scoreB = 0
        foulsB = 0
        pTeamB.text = "0"
        fTeamB.text = "0"
        tBfouls.text = "Faltas: 0"
        // Used <Toast> to display something similar to a popUp, warning that the score has been reset.
        Toast.makeText(this, "Game restarted", Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("SetTextI18n")
    private fun addfouls(team: String) {
        // Checking which team should be awarded points
        // values ​​are added to variables that were created outside the "onCreate" method
        // so getting available through the whole code
        if (team == "A") {
            foulsA++
            if (foulsA == 5) {
                Toast.makeText(this, "5 faltas - Lance livre", Toast.LENGTH_LONG).show()
                foulsA = 0
                tfoulsA += 5
                tAfouls.text = "Faltas: $tfoulsA"
            }
        } else {
            foulsB++
            if (foulsB == 5) {
                Toast.makeText(this, "5 faltas - Lance livre", Toast.LENGTH_LONG).show()
                foulsB = 0
                tfoulsB += 5
                tBfouls.text = "Faltas: $tfoulsB"
            }
        }
        updateFouls(team)
    }

    private fun updateFouls(team: String) {
        // Checking which team should be updated to score and so
        // <toString ()> is used to convert data to "String"
        // since <textView> only accepts this type of variable
        if (team == "A") {
            fTeamA.text = foulsA.toString()
        } else {
            fTeamB.text = foulsB.toString()
        }
    }

    private fun restartFouls(team: String) {
        // All data will be reset and text will receive this data reset

        if (team == "A") {
            foulsA = 0
            fTeamA.text = foulsA.toString()
            Toast.makeText(this, "Fouls restarted A", Toast.LENGTH_SHORT).show()
        } else {
            foulsB = 0
            fTeamB.text = foulsB.toString()
            // Used <Toast> to display something similar to a popUp, warning that the score has been reset.
            Toast.makeText(this, "Fouls restarted B", Toast.LENGTH_SHORT).show()

        }
    }
}

