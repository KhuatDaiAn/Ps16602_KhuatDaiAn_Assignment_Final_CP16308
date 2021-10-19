package com.example.ps16602_khuatdaian_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
        EditText txtUser, txtPass;
        Button btnLogin, btnLai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtUser = (EditText) findViewById(R.id.txtUser);
        txtPass = (EditText) findViewById(R.id.txtPass);
        btnLai = (Button) findViewById(R.id.btnLai);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u = txtUser.getText().toString();
                String p = txtPass.getText().toString();
                if(u.equals("fpt") && p.equals("123")){
                    Intent intent = new Intent(LoginActivity.this,Home.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Login thanh cong", Toast.LENGTH_LONG).show();
                    finish();
                }else {
                    Toast.makeText(getApplicationContext(),"Login that bai",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtUser.setText("");
                txtPass.setText("");
            }
        });
    }
}