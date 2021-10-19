package com.example.ps16602_khuatdaian_assignment.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ps16602_khuatdaian_assignment.Database.Mydatabes;
import com.example.ps16602_khuatdaian_assignment.Model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienDAO implements iSinhVienDAO {
    Mydatabes mydatabes;


    public SinhVienDAO(Context context) {
        mydatabes = new Mydatabes(context);
    }

    @Override
    public List<SinhVien> get() {
        List<SinhVien> list = new ArrayList<>();
        SQLiteDatabase database = mydatabes.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM SINHVIEN",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String Id = cursor.getString(0);
            String Name = cursor.getString(1);
            String Date = cursor.getString(2);
            String MaLop = cursor.getString(3);
            SinhVien sinhVien = new SinhVien(Id,Name,Date,MaLop);
            list.add(sinhVien);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    @Override
    public SinhVien get(String Id) {
        SinhVien sinhVien = null;
        SQLiteDatabase database = mydatabes.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM SINHVIEN WHERE ID = ?",new String[]{Id});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String id = cursor.getString(0);
            String name = cursor.getString(1);
            String date = cursor.getString(2);
            String malop = cursor.getString(3);
            sinhVien = new SinhVien(id,name,date,malop);;
            cursor.moveToNext();
        }
        cursor.close();
        return sinhVien;
    }

    @Override
    public void insert(SinhVien sinhVien) {
        SQLiteDatabase database = mydatabes.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("ID", sinhVien.getID());
        values.put("Name",sinhVien.getName());
        values.put("Date",sinhVien.getDate());
        values.put("MaLop",sinhVien.getMaLop());
        database.insert("SINHVIEN","ID = ?",values);
    }

    @Override
    public void update(SinhVien sinhVien) {
        SQLiteDatabase database = mydatabes.getReadableDatabase();
        ContentValues values = new ContentValues();
        String[] params = new  String[]{sinhVien.getID()};
        values.put("Name",sinhVien.getName());
        values.put("Date",sinhVien.getDate());
        values.put("MaLop",sinhVien.getMaLop());
        database.update("SINHVIEN",values,"ID = ?",params);
    }

    @Override
    public void delete(String ID) {
        SQLiteDatabase database = mydatabes.getReadableDatabase();
        String[] params = new  String[]{ID};
        database.delete("SINHVIEN","ID = ?", params);
    }
}
