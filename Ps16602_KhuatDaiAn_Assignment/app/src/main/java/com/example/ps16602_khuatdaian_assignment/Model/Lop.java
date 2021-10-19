package com.example.ps16602_khuatdaian_assignment.Model;

public class Lop {
    private String STT;
    private String MaLop;
    private String TenLop;

    public Lop(String STT, String maLop, String tenLop) {
        this.STT = STT;
        MaLop = maLop;
        TenLop = tenLop;
    }

    public String getSTT() {
        return STT;
    }

    public void setSTT(String STT) {
        this.STT = STT;
    }

    public String getMaLop() {
        return MaLop;
    }

    public void setMaLop(String maLop) {
        MaLop = maLop;
    }

    public String getTenLop() {
        return TenLop;
    }

    public void setTenLop(String tenLop) {
        TenLop = tenLop;
    }
}
