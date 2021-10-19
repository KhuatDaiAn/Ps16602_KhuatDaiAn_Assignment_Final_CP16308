package com.example.ps16602_khuatdaian_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ps16602_khuatdaian_assignment.DAO.SinhVienDAO;
import com.example.ps16602_khuatdaian_assignment.Model.SinhVien;

public class chitietActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        SinhVien sinhVien = (new SinhVienDAO(this)).get(id);

        EditText idsv = (EditText) findViewById(R.id.ID);
        EditText tensv = (EditText) findViewById(R.id.ten);
        EditText datesv = (EditText) findViewById(R.id.date);
        EditText malop = (EditText) findViewById(R.id.malop);

        idsv.setText(sinhVien.getID());
        tensv.setText(sinhVien.getName());
        datesv.setText(sinhVien.getDate());
        malop.setText(sinhVien.getMaLop());

        Button buttonCapNhat = (Button) findViewById(R.id.buttonUpdate);
        buttonCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _name = tensv.getText().toString();
                String _date = datesv.getText().toString();
                String _malop = malop.getText().toString();

                SinhVienDAO dao = new SinhVienDAO(chitietActivity.this);
                sinhVien.setName(_name);
                sinhVien.setDate(_date);
                sinhVien.setMaLop(_malop);

                dao.update(sinhVien);
                setResult(Activity.RESULT_OK);
                finish();
            }
        });
        Button buttonXoa = (Button) findViewById(R.id.buttoXoa);
        buttonXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SinhVienDAO dao = new SinhVienDAO(chitietActivity.this);
                dao.delete(sinhVien.getID());
                setResult(Activity.RESULT_OK);
                finish();
                Intent intent = new Intent(chitietActivity.this,QuanLySVActivity.class);
                startActivity(intent);
                return;
            }
        });
    }
}