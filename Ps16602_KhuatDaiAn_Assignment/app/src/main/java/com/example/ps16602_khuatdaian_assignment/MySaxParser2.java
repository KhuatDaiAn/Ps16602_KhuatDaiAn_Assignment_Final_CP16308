package com.example.ps16602_khuatdaian_assignment;

import android.util.Log;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.SAXParserFactory;

public class MySaxParser2 {
    public static ArrayList<item2> xmlParser(InputStream is)
    {
        ArrayList<item2> items=null;
        try{
            //tao xmlreader tu xmlparser
            XMLReader xmlreader= SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            //tao saxhandler
            MySaxHandler2 saxhandler=new MySaxHandler2();
            //luu handler vao xmlreader
            xmlreader.setContentHandler(saxhandler);
            xmlreader.parse(new InputSource(is));
            //lay danh sach cac item bo vao items
            items=saxhandler.getItems();
        }
        catch(Exception e)
        {
            Log.d("loi","lay khong duoc "+ e.toString());
        }
        return items;
    }





}
