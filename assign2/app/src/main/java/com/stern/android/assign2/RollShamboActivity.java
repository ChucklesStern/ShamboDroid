package com.stern.android.assign2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.UTFDataFormatException;
import java.lang.reflect.Array;
/*
Adam C Stern
adamstern@my.smccd.edu
CIS135POL
RollShamboActivity.java
Main acitivity file for Roll Shambo app
Assignment#2
28 February 2018

 */
public class RollShamboActivity extends AppCompatActivity {

     TextView _play;
     Button _rock, _scissors, _paper;
    String[] items = new String[4];



    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_shambo);

    _rock = (Button) findViewById(R.id.rock_button);
    _paper = (Button) findViewById(R.id.paper_button);
    _scissors = (Button) findViewById(R.id.scissors_button);

    _play = (TextView) findViewById(R.id.play_view);

    _rock.setOnClickListener(myListener);
    _scissors.setOnClickListener(myListener);
    _paper.setOnClickListener(myListener);





        items[0] = "Click for New Game";
        items[1] = "Rock";
        items[2] = "Scissors";
        items[3] = "Paper";
    }

    private View.OnClickListener myListener = new View.OnClickListener(){
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.paper_button:
                    comparePlays(Util.PAPER_ID);
                    break;
                case R.id.rock_button:
                    comparePlays(Util.ROCK_ID);
                    break;
                case R.id.scissors_button:
                    comparePlays(Util.SCISSOR_ID);
                    break;
            }
        }
    };

    private void gameLost(Integer aidecision, Integer userDecision) {
        String one = "";
        String two = "";

        if (aidecision.equals(Util.PAPER_ID)) {
            one = "Paper";
        }  if (aidecision.equals(Util.ROCK_ID)) {
            one = "Rock";
        } if (aidecision.equals(Util.SCISSOR_ID)) {
            one = "Scissors";
        }

        if (userDecision.equals(Util.PAPER_ID)) {
            two = "Paper";
        }  if (userDecision.equals(Util.ROCK_ID)) {
            two = "Rock";
        } if (userDecision.equals(Util.SCISSOR_ID)) {
            two = "Scissors";
        }
    String eachGame ="You Lost! " + one+" Beats " +two;
    _play.setText(eachGame);

    }

private void gameWon(Integer aidecision, Integer userDecision) {
    String one = "";
    String two = "";

if (aidecision.equals(Util.PAPER_ID)) {
    two = "Paper";
    }  if (aidecision.equals(Util.ROCK_ID)) {
        two = "Rock";
    } if (aidecision.equals(Util.SCISSOR_ID)) {
        two = "Scissors";
    }

    if (userDecision.equals(Util.PAPER_ID)) {
        one = "Paper";
    }  if (userDecision.equals(Util.ROCK_ID)) {
        one = "Rock";
    } if (userDecision.equals(Util.SCISSOR_ID)) {
        one = "Scissors";
    }
    String eachGame ="You Won! "+ one+" Beats " +two;;
    _play.setText(eachGame);
}

    private void gameTied(Integer aidecision, Integer userDecision) {
        String one = "";
        String two = "";

        if (aidecision.equals(Util.PAPER_ID)) {
            one = "Paper";
        }  if (aidecision.equals(Util.ROCK_ID)) {
            one = "Rock";
        } if (aidecision.equals(Util.SCISSOR_ID)) {
            one = "Scissors";
        }

        if (userDecision.equals(Util.PAPER_ID)) {
            two = "Paper";
        }  if (userDecision.equals(Util.ROCK_ID)) {
            two = "Rock";
        } if (userDecision.equals(Util.SCISSOR_ID)) {
            two = "Scissors";
        }
        String eachGame ="You Tied! "+ one+" Matches  " +two;
        _play.setText(eachGame);
    }

    private void comparePlays(Integer userPlay) {
        Integer aidecision = Util.AIDecides();
        Log.v("User Played", userPlay.toString());
        Log.v("AI Played", aidecision.toString());
        // gamePlayed();

        if (aidecision.equals(userPlay)) {
            //tie situation

            gameTied(aidecision, userPlay);

            //showReplay();
        } else if (aidecision.equals(Util.PAPER_ID) && userPlay.equals(Util.ROCK_ID) || aidecision.equals(Util.ROCK_ID) && aidecision.equals(Util.SCISSOR_ID) || aidecision.equals(Util.SCISSOR_ID) && userPlay.equals(Util.PAPER_ID)) {
            //compuer win
            gameLost(aidecision, userPlay);
        } else if (aidecision.equals(Util.ROCK_ID) && userPlay.equals(Util.PAPER_ID) || aidecision.equals(Util.SCISSOR_ID) && aidecision.equals(Util.ROCK_ID) || aidecision.equals(Util.PAPER_ID) && userPlay.equals(Util.SCISSOR_ID)) {
    //player wins
            gameWon(aidecision, userPlay);

            //showReplay();
        }
}
}