package com.example.yiheng.pd_3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class leaderboards extends AppCompatActivity {

    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboards);

        TextView tv = findViewById(R.id.scorebaord);
        Button back = findViewById(R.id.back);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(leaderboards.this);

        String playerName = prefs.getString("Name","00");
        int points = prefs.getInt("Score",00);

        String pointString = Integer.toString(points);

        msg = playerName + " has won " + pointString + " games.";
        tv.setText(msg);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(leaderboards.this,game.class);
                startActivity(i);
            }
        });
    }
}
