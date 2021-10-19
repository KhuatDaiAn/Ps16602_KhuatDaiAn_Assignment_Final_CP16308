package com.example.ps16602_khuatdaian_assignment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ps16602_khuatdaian_assignment.R;
import com.example.ps16602_khuatdaian_assignment.item2;

import java.util.ArrayList;

public class TinTheoLoaiAdapter extends ArrayAdapter<item2> {

    Context context;
    ArrayList<item2> items;

    public TinTheoLoaiAdapter(Context context, int textViewResourceId, ArrayList<item2> objects) {
        super(context, textViewResourceId, objects);
        // TODO Auto-generated constructor stub
        this.context = context;
        this.items = objects;
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        LayoutInflater inf = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowview = inf.inflate(R.layout.layout_tintheoloai_itemlistview, parent, false);
        TextView tv_title = (TextView) rowview.findViewById(R.id.title);
        TextView tv_description = (TextView) rowview.findViewById(R.id.description);

        tv_title.setText(items.get(position).getTitle().toString());
        tv_description.setText(items.get(position).getDescription().toString());

        return rowview;

    }

}
