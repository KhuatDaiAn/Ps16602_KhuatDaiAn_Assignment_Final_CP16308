package com.example.ps16602_khuatdaian_assignment.DAO;

import com.example.ps16602_khuatdaian_assignment.Model.Lop;
import com.example.ps16602_khuatdaian_assignment.Model.SinhVien;

import java.util.List;

public interface iLopDAO {
    List<Lop> get();
    Lop get(String STT);
    void insert(Lop lop);
    void update(Lop lop);
    void delete(String STT);
}
