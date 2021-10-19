package com.example.ps16602_khuatdaian_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ps16602_khuatdaian_assignment.DAO.LopDAO;
import com.example.ps16602_khuatdaian_assignment.DAO.SinhVienDAO;
import com.example.ps16602_khuatdaian_assignment.Model.Lop;
import com.example.ps16602_khuatdaian_assignment.Model.SinhVien;

public class themLopActivity extends AppCompatActivity {
    EditText sttnew, tenlopnew, malopnew;
    Button themlopnew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_lop);

        sttnew = (EditText) findViewById(R.id.STTLOP);
        tenlopnew = (EditText) findViewById(R.id.TENLOPNEW);
        malopnew = (EditText) findViewById(R.id.MALOPNEW);
        themlopnew = (Button) findViewById(R.id.buttonThemLopNew);


        themlopnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lop lop = readFormData();
                if(lop != null){
                    LopDAO dao = new LopDAO(themLopActivity.this);
                    dao.insert(lop);
                    setResult(Activity.RESULT_OK);
                    Toast.makeText(getApplicationContext(),"Thêm thành công", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
    }
    private Lop readFormData(){
        String _stt = sttnew.getText().toString();
        String _ten = tenlopnew.getText().toString();
        String _ma = malopnew.getText().toString();

        Lop lop = new Lop(_stt,_ten,_ma);
        return lop;
    }
}