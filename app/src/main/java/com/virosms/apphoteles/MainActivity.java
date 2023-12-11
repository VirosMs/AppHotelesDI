package com.virosms.apphoteles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogin = (Button)findViewById(R.id.loginButton);

        btnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(this, Hotels.class);
            startActivity(intent);
        });
    }
}