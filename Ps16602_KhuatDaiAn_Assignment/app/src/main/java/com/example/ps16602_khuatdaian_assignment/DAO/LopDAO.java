package com.example.ps16602_khuatdaian_assignment.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ps16602_khuatdaian_assignment.Database.Mydatabes;
import com.example.ps16602_khuatdaian_assignment.Model.Lop;
import com.example.ps16602_khuatdaian_assignment.Model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class LopDAO implements iLopDAO {
    Mydatabes mydatabes;
    public LopDAO(Context context){
        mydatabes = new Mydatabes(context);
    }
    @Override
    public List<Lop> get() {
        List<Lop> list = new ArrayList<>();
        SQLiteDatabase database = mydatabes.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM LOP",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String stt = cursor.getString(0);
            String maLop = cursor.getString(1);
            String tenLop = cursor.getString(2);
            Lop lop = new Lop(stt,maLop,tenLop);
            list.add(lop);
            cursor.moveToNext();
        }
        return list;
    }

    @Override
    public Lop get(String STT) {
        Lop lop = null;
        SQLiteDatabase database = mydatabes.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM LOP WHERE STT = ?",new String[]{STT});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String stt = cursor.getString(0);
            String malop = cursor.getString(1);
            String tenlop = cursor.getString(2);
            lop = new Lop(stt,malop,tenlop);;
            cursor.moveToNext();
        }
        cursor.close();
        return lop;
    }

    @Override
    public void insert(Lop lop) {
        SQLiteDatabase database = mydatabes.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("STT", lop.getSTT());
        values.put("MaLop",lop.getMaLop());
        values.put("TenLop",lop.getTenLop());
        database.insert("LOP","STT = ?",values);
    }

    @Override
    public void update(Lop lop) {

    }

    @Override
    public void delete(String STT) {
        SQLiteDatabase database = mydatabes.getReadableDatabase();
        String[] params = new  String[]{STT};
        database.delete("LOP","STT = ?", params);
    }

}
