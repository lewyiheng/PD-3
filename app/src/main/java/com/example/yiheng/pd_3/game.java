package com.example.yiheng.pd_3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.Random;

public class game extends AppCompatActivity {

    Random rng = new Random();

    int winning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        final TextView playerName = findViewById(R.id.playerName);
        final ImageView userRock = findViewById(R.id.playerROCK);
        final ImageView userSci = findViewById(R.id.playerSCI);
        final ImageView userPaper = findViewById(R.id.playerPAPER);
        final ImageView enemyRock = findViewById(R.id.enemyROCK);
        final ImageView enemySci = findViewById(R.id.enemySCI);
        final ImageView enemyPaper = findViewById(R.id.enemyPAPER);
        Button choiceRock = findViewById(R.id.chooseRock);
        Button choiceSci = findViewById(R.id.chooseSci);
        Button choicePaper = findViewById(R.id.choosePaper);
        final Button leaderboards = findViewById(R.id.leader);
        final TextView tvChoice = findViewById(R.id.tvChoice);
        final TextView tvMatch = findViewById(R.id.tvMatch);
        final TextView winScores = findViewById(R.id.winScore);

        final TextView matchPlayed = findViewById(R.id.matchPlayed);
        //final String winScoreString = Integer.toString(winScore);
        //final String matchPlayedString = Integer.toString(matches);
        final String matchWin = "You've won!";
        final String matchDraw = "It's a draw!";
        final String matchLose = "You've lost!";

        Intent i = getIntent();

        String[] name = i.getStringArrayExtra("name");
        playerName.setText(name[0]);


        //CHOOSE ROCK
        choiceRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userRock.setVisibility(View.VISIBLE);
                userSci.setVisibility(View.INVISIBLE);
                userPaper.setVisibility(View.INVISIBLE);
                tvChoice.setText("You picked Rock!");


                int r = rng.nextInt(3);

                //If enemy is rock - DO DRAW
                if (r == 0) {
                    enemyRock.setVisibility(View.VISIBLE);
                    enemySci.setVisibility(View.INVISIBLE);
                    enemyPaper.setVisibility(View.INVISIBLE);


                    tvMatch.setText(matchDraw);

                    //If enemy is Scissors - DO WIN
                } else if (r == 1) {
                    enemyRock.setVisibility(View.INVISIBLE);
                    enemySci.setVisibility(View.VISIBLE);
                    enemyPaper.setVisibility(View.INVISIBLE);

                    winning++;

                    tvMatch.setText(matchWin);


                    //If enemy is Paper  - DO LOSE
                } else if (r == 2) {
                    enemyRock.setVisibility(View.INVISIBLE);
                    enemySci.setVisibility(View.INVISIBLE);
                    enemyPaper.setVisibility(View.VISIBLE);

                    tvMatch.setText(matchLose);
                }

            }
        });

        //CHOOSE SCISSORS
        choiceSci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userRock.setVisibility(View.INVISIBLE);
                userSci.setVisibility(View.VISIBLE);
                userPaper.setVisibility(View.INVISIBLE);
                tvChoice.setText("You picked Scissors!");


                //winScores.setText(winScoreString);
                //matchPlayed.setText(matchPlayedString);

                int r = rng.nextInt(3);

                //If enemy is rock - DO LOSE
                if (r == 0) {
                    enemyRock.setVisibility(View.VISIBLE);
                    enemySci.setVisibility(View.INVISIBLE);
                    enemyPaper.setVisibility(View.INVISIBLE);

                    tvMatch.setText(matchLose);

                    //If enemy is Scissors - DO DRAW
                } else if (r == 1) {
                    enemyRock.setVisibility(View.INVISIBLE);
                    enemySci.setVisibility(View.VISIBLE);
                    enemyPaper.setVisibility(View.INVISIBLE);

                    tvMatch.setText(matchDraw);

                    //If enemy is Paper  - DO WIN
                } else if (r == 2) {
                    enemyRock.setVisibility(View.INVISIBLE);
                    enemySci.setVisibility(View.INVISIBLE);
                    enemyPaper.setVisibility(View.VISIBLE);

                    winning++;
                    tvMatch.setText(matchWin);


                }

            }
        });

        choicePaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userRock.setVisibility(View.INVISIBLE);
                userSci.setVisibility(View.INVISIBLE);
                userPaper.setVisibility(View.VISIBLE);
                tvChoice.setText("You picked Paper!");


                //winScores.setText(winScoreString);
                //matchPlayed.setText(matchPlayedString);

                int r = rng.nextInt(3);

                //If enemy is rock - DO WIN
                if (r == 0) {
                    enemyRock.setVisibility(View.VISIBLE);
                    enemySci.setVisibility(View.INVISIBLE);
                    enemyPaper.setVisibility(View.INVISIBLE);

                    winning++;
                    tvMatch.setText(matchWin);


                    //If enemy is Scissors - DO LOSE
                } else if (r == 1) {
                    enemyRock.setVisibility(View.INVISIBLE);
                    enemySci.setVisibility(View.VISIBLE);
                    enemyPaper.setVisibility(View.INVISIBLE);

                    tvMatch.setText(matchLose);

                    //If enemy is Paper  - DO DRAW
                } else if (r == 2) {
                    enemyRock.setVisibility(View.INVISIBLE);
                    enemySci.setVisibility(View.INVISIBLE);
                    enemyPaper.setVisibility(View.VISIBLE);

                    tvMatch.setText(matchDraw);
                }
            }
        });

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("Name",name[0]);
        editor.putInt("Score",winning);
        editor.commit();

        leaderboards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(game.this,com.example.yiheng.pd_3.leaderboards.class);
                startActivity(i);

            }
        });
        //winScores.setText(winScoreString);
        //matchPlayed.setText(matchPlayedString);


    }

}

