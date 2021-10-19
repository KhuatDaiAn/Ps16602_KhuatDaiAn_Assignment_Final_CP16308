package com.example.ps16602_khuatdaian_assignment.Model;

public class SinhVien {
    private String ID;
    private String Name;
    private String Date;
    private String MaLop;

    public SinhVien() {
    }

    public SinhVien(String ID, String name, String date, String maLop) {
        this.ID = ID;
        Name = name;
        Date = date;
        MaLop = maLop;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getMaLop() {
        return MaLop;
    }

    public void setMaLop(String maLop) {
        MaLop = maLop;
    }
}
