package com.example.ps16602_khuatdaian_assignment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.example.ps16602_khuatdaian_assignment.Adapter.TinTheoLoaiAdapter;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class MyAsyncTask extends AsyncTask<Void,Void,Void> {
    ArrayList<item2> items=new ArrayList<item2>();
    String chuoi="";
    Context context;
    String diachi_rss;
    ProgressDialog dialog;
    MyAsyncTask(Context c, String diachi_rss)
    {
        this.diachi_rss=diachi_rss;
        this.context=c;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog=ProgressDialog.show(context, "cho chut", "doc tren mang nen ton ti thoi gian");

    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url=new URL(diachi_rss);
            URLConnection connection=url.openConnection();

            InputStream is=connection.getInputStream();
            items=(ArrayList<item2>) MySaxParser2.xmlParser(is);
           // for(int i=0;i<items.size();i++)
           // {
            //   chuoi+=items.get(i).getTitle()+" ";
            //    chuoi+=items.get(i).getPubdate()+ "\n";
           // }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Log.d("dulieu",e.toString());
        }


        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        dialog.dismiss();
        try{
            TinTheoLoaiAdapter adapter=new TinTheoLoaiAdapter(context,R.layout.layout_tintheoloai_itemlistview,items);
            ((tinTheoLoai)context).lv.setAdapter(adapter);
            ((tinTheoLoai)context).lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String link=items.get(position).getLink();
                    //Toast.makeText(getApplicationContext(),link, Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(context,XemTinActivity.class);
                    intent.putExtra("link", link);
                    context.startActivity(intent);

                }
            });

        }catch(Exception e)
        {
            Log.d("title","adapter khong duoc");
        }


        super.onPostExecute(unused);

    }
}
