package com.example.ps16602_khuatdaian_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ps16602_khuatdaian_assignment.Adapter.LopAdapter;
import com.example.ps16602_khuatdaian_assignment.Adapter.SinhVienAdapter;
import com.example.ps16602_khuatdaian_assignment.DAO.LopDAO;
import com.example.ps16602_khuatdaian_assignment.DAO.SinhVienDAO;
import com.example.ps16602_khuatdaian_assignment.Model.Lop;
import com.example.ps16602_khuatdaian_assignment.Model.SinhVien;

import java.util.List;

public class QuanLySVActivity extends AppCompatActivity {
    List<SinhVien> data;
    SinhVienAdapter adapter;
    EditText Id, ten, date,MaLop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_svactivity);

        Id = (EditText) findViewById(R.id.ID);
        ten = (EditText) findViewById(R.id.QLTensv);
        date = (EditText) findViewById(R.id.QLNgaySinh);
        MaLop = (EditText) findViewById(R.id.QLLop);

        ListView listView = (ListView) findViewById(R.id.listSV);
        data = (new SinhVienDAO(this)).get();
        adapter = new SinhVienAdapter(data,this, R.layout.item_qlsv);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                SinhVien sinhVien = (SinhVien) adapter.getItem(i);
                Intent intent = new Intent(QuanLySVActivity.this, chitietActivity.class);
                intent.putExtra("id",sinhVien.getID());
                startActivityForResult(intent,1);
            }
        });
        Button buttonAdd = (Button) findViewById(R.id.btnThemSV);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SinhVien sinhVien = readFormData();
                if(sinhVien != null){
                    SinhVienDAO dao = new SinhVienDAO(QuanLySVActivity.this);
                    dao.insert(sinhVien);
                    setResult(Activity.RESULT_OK);
                    Toast.makeText(getApplicationContext(),"Thêm thành công", Toast.LENGTH_LONG).show();
                    finish();
                    Intent intent = new Intent(QuanLySVActivity.this,QuanLySVActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
    private SinhVien readFormData(){
        String _id = Id.getText().toString();
        String _name = ten.getText().toString();
        String _date = date.getText().toString();
        String _lop = MaLop.getText().toString();

        SinhVien sinhVien = new SinhVien(_id,_name,_date,_lop);
        return sinhVien;
    }
}