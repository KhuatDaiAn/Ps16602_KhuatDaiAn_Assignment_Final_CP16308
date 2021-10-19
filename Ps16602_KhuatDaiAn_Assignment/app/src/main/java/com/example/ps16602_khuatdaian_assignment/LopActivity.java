package com.example.ps16602_khuatdaian_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ps16602_khuatdaian_assignment.Adapter.LopAdapter;
import com.example.ps16602_khuatdaian_assignment.DAO.LopDAO;
import com.example.ps16602_khuatdaian_assignment.DAO.SinhVienDAO;
import com.example.ps16602_khuatdaian_assignment.Model.Lop;
import com.example.ps16602_khuatdaian_assignment.Model.SinhVien;

import java.util.List;

public class LopActivity extends AppCompatActivity {
    List<Lop> _data;
    LopAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lop);

        ListView listView1 = (ListView) findViewById(R.id.listLop);
        _data = (new LopDAO(this)).get();
        adapter = new LopAdapter(this,_data,R.layout.item_lop);
        listView1.setAdapter(adapter);


        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                _data.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
    }

}