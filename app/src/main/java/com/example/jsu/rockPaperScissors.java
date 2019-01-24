package com.example.jsu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class rockPaperScissors extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    int playerScore;
    int computerScore;
    String winningText;
    String winner;
    Weapon playerWeapon;
    Weapon computerWeapon;

    public enum Weapon {

        ROCK("Rock"),
        PAPER("Paper"),
        SCISSORS("Scissors");

        private String message;

        private Weapon(String msg) { message = msg; }

        @Override
        public String toString() { return message; }

    };

    public void computerPick() {
        Random rn = new Random();
        int randNum = rn.nextInt((3 - 1) + 1) + 1;

        switch (randNum) {
            case 1: computerWeapon = Weapon.ROCK;
                TextView computerWeaponRock = (TextView) findViewById(R.id.computerWeapon);
                computerWeaponRock.setText("Computer's Weapon : " + computerWeapon);
                break;
            case 2: computerWeapon = Weapon.PAPER;
                TextView computerWeaponPaper = (TextView) findViewById(R.id.computerWeapon);
                computerWeaponPaper.setText("Computer's Weapon : " + computerWeapon);
                break;
            case 3: computerWeapon = Weapon.SCISSORS;
                TextView computerWeaponScissors = (TextView) findViewById(R.id.computerWeapon);
                computerWeaponScissors.setText("Computer's Weapon : " + computerWeapon);
                break;
        }
    }

    public void getWinner() {
        if (playerWeapon == Weapon.ROCK && computerWeapon == Weapon.SCISSORS) {
            winner = "Player";
            winningText = "blunts";
            TextView winnerText = (TextView) findViewById(R.id.winnerField);
            winnerText.setText(winner + " wins ... " + playerWeapon + " " + winningText + " " + computerWeapon);
            playerScore++;
        }
        else if (playerWeapon == Weapon.PAPER && computerWeapon == Weapon.ROCK) {
            winner = "Player";
            winningText = "covers";
            TextView winnerText = (TextView) findViewById(R.id.winnerField);
            winnerText.setText(winner + " wins ... " + playerWeapon + " " + winningText + " " + computerWeapon);
            playerScore++;
        }
        else if (playerWeapon == Weapon.SCISSORS && computerWeapon == Weapon.PAPER) {
            winner = "Player";
            winningText = "cuts";
            TextView winnerText = (TextView) findViewById(R.id.winnerField);
            winnerText.setText(winner + " wins ... " + playerWeapon + " " + winningText + " " + computerWeapon);
            playerScore++;
        }
        else if (computerWeapon == Weapon.ROCK && playerWeapon== Weapon.SCISSORS) {
            winner = "Computer";
            winningText = "blunts";
            TextView winnerText = (TextView) findViewById(R.id.winnerField);
            winnerText.setText(winner + " wins ... " + computerWeapon + " " + winningText + " " + playerWeapon);
            computerScore++;
        }
        else if (computerWeapon == Weapon.PAPER && playerWeapon== Weapon.ROCK) {
            winner = "Computer";
            winningText = "covers";
            TextView winnerText = (TextView) findViewById(R.id.winnerField);
            winnerText.setText(winner + " wins ... " + computerWeapon + " " + winningText + " " + playerWeapon);
            computerScore++;
        }
        else if (computerWeapon== Weapon.SCISSORS && playerWeapon == Weapon.PAPER) {
            winner = "Computer";
            winningText = "cuts";
            TextView winnerText = (TextView) findViewById(R.id.winnerField);
            winnerText.setText(winner + " wins ... " + computerWeapon + " " + winningText + " " + playerWeapon);
            computerScore++;
        }
        else if (computerWeapon == Weapon.ROCK && playerWeapon== Weapon.ROCK) {
            winner = "It is a Tie!";
            TextView winnerText = (TextView) findViewById(R.id.winnerField);
            winnerText.setText(winner);
        }
        else if (computerWeapon == Weapon.PAPER && playerWeapon== Weapon.PAPER) {
            winner = "It is a Tie!";
            TextView winnerText = (TextView) findViewById(R.id.winnerField);
            winnerText.setText(winner);
        }
        else if (computerWeapon== Weapon.SCISSORS && playerWeapon == Weapon.SCISSORS) {
            winner = "It is a Tie!";
            TextView winnerText = (TextView) findViewById(R.id.winnerField);
            winnerText.setText(winner);
        }
        TextView scoreText = (TextView) findViewById(R.id.scoreKeeper);
        scoreText.setText("Player: " + playerScore + ", Computer Score: " + computerScore);

    }

    public void rockClicked(View v) {
        playerWeapon = Weapon.ROCK;
        TextView rock = (TextView) findViewById(R.id.playerWeapon);
        rock.setText("Player's Weapon : " + playerWeapon);
        computerPick();
        getWinner();
    }
    public void paperClicked(View v) {
        playerWeapon = Weapon.PAPER;
        TextView paper = (TextView) findViewById(R.id.playerWeapon);
        paper.setText("Player's Weapon : " + playerWeapon);
        computerPick();
        getWinner();
    }
    public void scissorsClicked(View v) {
        playerWeapon = Weapon.SCISSORS;
        TextView scissors = (TextView) findViewById(R.id.playerWeapon);
        scissors.setText("Player's Weapon : " + playerWeapon);
        computerPick();
        getWinner();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rock_paper_scissors, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
