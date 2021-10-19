package com.example.ps16602_khuatdaian_assignment.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ps16602_khuatdaian_assignment.Model.Lop;
import com.example.ps16602_khuatdaian_assignment.Model.SinhVien;
import com.example.ps16602_khuatdaian_assignment.R;

import java.util.List;

public class LopAdapter extends BaseAdapter {
    private Context context;
    private List<Lop> data;
    private int layout;

    public LopAdapter( Context _context,List<Lop> _data, int layout) {
        this.context = _context;
        this.data = _data;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return data.size();
    }
//    public int getPositon(String MaLop){
//        int index = -1;
//        for (int i = 0; i < data.size(); i++) {
//            Lop lop = data.get(i);
//            if (lop.getMaLop().equals(MaLop)){
//                index = i;
//                break;
//            }
//        }
//        return index;
//    }
    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

private class ViewHolder{
    TextView Stt, Ma, Ten;
}

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);


            holder.Stt = (TextView) view.findViewById(R.id.textViewSTTL);
            holder.Ma = (TextView) view.findViewById(R.id.textViewmaLop);
            holder.Ten = (TextView) view.findViewById(R.id.textViewtenLop);
            view.setTag(holder);
        } else {
            holder = (LopAdapter.ViewHolder) view.getTag();
        }

        Lop lop = data.get(position);
        holder.Stt.setText(lop.getSTT());
        holder.Ma.setText(lop.getMaLop());
        holder.Ten.setText(lop.getTenLop());

        return view;
    }
}
