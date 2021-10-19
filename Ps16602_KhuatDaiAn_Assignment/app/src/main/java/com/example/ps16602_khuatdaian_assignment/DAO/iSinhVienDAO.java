package com.example.ps16602_khuatdaian_assignment.DAO;

import com.example.ps16602_khuatdaian_assignment.Model.SinhVien;

import java.util.List;

public interface iSinhVienDAO {
    List<SinhVien> get();
    SinhVien get(String Id);
    void insert(SinhVien sinhVien);
    void update(SinhVien sinhVien);
    void delete(String ID);
}
