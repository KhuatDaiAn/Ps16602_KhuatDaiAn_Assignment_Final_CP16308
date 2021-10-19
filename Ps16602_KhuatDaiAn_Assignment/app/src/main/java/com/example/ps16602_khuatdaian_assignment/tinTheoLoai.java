package com.example.ps16602_khuatdaian_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class tinTheoLoai extends AppCompatActivity {
    String diachi_rss;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tin_theo_loai);
        lv=findViewById(R.id.lvtin);
        diachi_rss=getIntent().getExtras().getString("diachi_rss");

        MyAsyncTask gandulieu=new MyAsyncTask(tinTheoLoai.this,diachi_rss);
        gandulieu.execute();
    }
}