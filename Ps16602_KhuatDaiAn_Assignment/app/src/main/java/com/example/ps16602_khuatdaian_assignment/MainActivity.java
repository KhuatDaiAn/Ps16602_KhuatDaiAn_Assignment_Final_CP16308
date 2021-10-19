package com.example.ps16602_khuatdaian_assignment;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnThemLop, btnDSL, btnQLSV, btnGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
//        startActivity(intent);


        btnThemLop = (Button) findViewById(R.id.btnThemLop);
        btnDSL = (Button) findViewById(R.id.btnDSL);
        btnQLSV = (Button) findViewById(R.id.btnQLSV);
        btnGame = (Button) findViewById(R.id.game);


        btnDSL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LopActivity.class);
                startActivity(intent);
            }
        });

        btnQLSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,QuanLySVActivity.class);
                startActivity(intent);
            }
        });

        btnGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,GameActivity.class);
                startActivity(intent);
            }
        });
        btnThemLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,themLopActivity.class);
                startActivity(intent);
            }
        });
    }

}









