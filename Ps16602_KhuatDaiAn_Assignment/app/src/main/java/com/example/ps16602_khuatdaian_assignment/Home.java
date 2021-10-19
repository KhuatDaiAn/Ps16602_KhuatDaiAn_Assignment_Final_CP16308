package com.example.ps16602_khuatdaian_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
    Button qlsv, bd, btnNew,btnSocoal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        qlsv = findViewById(R.id.qlsv);
        bd = findViewById(R.id.banDo);
        btnNew = findViewById(R.id.btnNew);
        btnSocoal = findViewById(R.id.btnSocial);

        qlsv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, MainActivity.class);
                startActivity(intent);
            }
        });
        bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, BanDo.class);
                startActivity(intent);
            }
        });
        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, New.class);
                startActivity(intent);
            }
        });
        btnSocoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Social.class);
                startActivity(intent);
            }
        });
    }
}