package com.example.ps16602_khuatdaian_assignment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.ps16602_khuatdaian_assignment.Model.SinhVien;
import com.example.ps16602_khuatdaian_assignment.R;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter  {
    private  List<SinhVien> data;
    private Context context;
    private int layout;

    public SinhVienAdapter(List<SinhVien> data, Context context, int layout) {
        this.data = data;
        this.context = context;
        this.layout = layout;
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    private class ViewHolder{
        TextView id, name, ngaySinh, malop;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);


            holder.id = (TextView) view.findViewById(R.id.textViewID);
            holder.name = (TextView) view.findViewById(R.id.textViewTen);
            holder.ngaySinh = (TextView) view.findViewById(R.id.textViewDate);
            holder.malop = (TextView) view.findViewById(R.id.MaLopItemLopHoc);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        SinhVien sinhVien = data.get(position);
        holder.id.setText(sinhVien.getID());
        holder.name.setText(sinhVien.getName());
        holder.ngaySinh.setText(sinhVien.getDate());
        holder.malop.setText(sinhVien.getMaLop());

        return view;
    }

}
