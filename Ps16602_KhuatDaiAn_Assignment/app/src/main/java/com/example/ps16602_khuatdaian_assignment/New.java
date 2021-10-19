package com.example.ps16602_khuatdaian_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class New extends AppCompatActivity {
    String[] ten = {"Trang chủ","Tin tức trong ngày","Bóng đá", "Thời trang"};

    String[] loai = {"https://www.24h.com.vn/upload/rss/trangchu24h.rss",
            "https://www.24h.com.vn/upload/rss/tintuctrongngay.rss",
            "https://www.24h.com.vn/upload/rss/bongda.rss",
            "https://www.24h.com.vn/upload/rss/thoitrang.rss"};
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        lv = findViewById(R.id.lv1);
        ArrayAdapter<String> adapter=new
                ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ten);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub
                //arg2 chính là vị trí (index) được nhấn
                Intent intent=new Intent(getApplicationContext(),tinTheoLoai.class);
                intent.putExtra("diachi_rss", loai[arg2]);
                startActivity(intent);


            }
        });

    }
}