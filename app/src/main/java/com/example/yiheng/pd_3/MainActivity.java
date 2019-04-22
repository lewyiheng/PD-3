package com.example.yiheng.pd_3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView username = findViewById(R.id.user);
                String name = username.getText().toString();
                String[] nameName = {name};

                if (name.isEmpty()) {
                    Toast toast = Toast.makeText(MainActivity.this, "Please enter a username", Toast.LENGTH_LONG);
                    toast.show();
                } else {


                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference name1 = database.getReference(name);

                    name1.setValue(0);

                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putInt(name, 0);
                    editor.commit();


                    Intent i = new Intent(MainActivity.this, game.class);
                    i.putExtra("name", nameName);
                    startActivity(i);
                }
            }
        });
    }
}
