package com.example.ps16602_khuatdaian_assignment.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Mydatabes extends SQLiteOpenHelper {
    public Mydatabes(@Nullable Context context) {
        super(context, "SinhVienDB", null, 7);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE LOP (STT Text, MaLop Text primary key not null, " +
                "TenLop Text)";
        db.execSQL(sql);
        sql = "CREATE TABLE SINHVIEN (ID Text primary key not null, " +
                "Name Text, " +
                "Date Text, " +
                "MaLop Text not null, " +
                "foreign key (MaLop) references LOP(MaLop))";
        db.execSQL(sql);

        sql = "CREATE TABLE USER (UserId Text primary key not null, " +
                "UserName Text, Password Text)";
        db.execSQL(sql);

        // insert du lieu mau
        String sqlInsert = "INSERT INTO USER VALUES('PS00001', 'fpt', '123')";
        db.execSQL(sqlInsert);

        db.execSQL("INSERT INTO LOP VALUES('01', 'LT16303','LTMT')");
        db.execSQL("INSERT INTO LOP VALUES('02', 'LT16304','UDPM')");
        db.execSQL("INSERT INTO LOP VALUES('03', 'LT16305','TKW')");
        db.execSQL("INSERT INTO LOP VALUES('04', 'LT16306','IOT')");

        db.execSQL("INSERT INTO SINHVIEN VALUES('001', 'Khuất Đại An', '30-09-1999', 'LT16303')");
        db.execSQL("INSERT INTO SINHVIEN VALUES('002', 'Hồ Hoàng Phúc', '12-03-2000', 'LT16304')");
        db.execSQL("INSERT INTO SINHVIEN VALUES('003', 'Đặng Tuấn Nghĩa', '23-04-2002', 'LT16305')");
        db.execSQL("INSERT INTO SINHVIEN VALUES('004', 'Nguyễn Trung Tiến', '29-05-2001', 'LT16306')");


    }
@Override
public  void onConfigure(SQLiteDatabase db){
        db.setForeignKeyConstraintsEnabled(true);
        super.onConfigure(db);
}
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS SINHVIEN");
        db.execSQL("DROP TABLE IF EXISTS LOP");
        db.execSQL("DROP TABLE IF EXISTS USER");
        onCreate(db);
    }


}
