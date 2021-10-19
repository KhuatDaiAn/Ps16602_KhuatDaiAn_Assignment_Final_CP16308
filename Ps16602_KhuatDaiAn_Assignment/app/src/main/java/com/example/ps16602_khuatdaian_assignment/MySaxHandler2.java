package com.example.ps16602_khuatdaian_assignment;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class MySaxHandler2 extends DefaultHandler {
    ArrayList<item2> items;
    item2 item_tam;
    String chuoi_tam;
    boolean vao_item=false;

    public MySaxHandler2()
    {
        items=new ArrayList<item2>();
    }
    public ArrayList<item2> getItems()
    {
        return items;
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        // TODO Auto-generated method stub
        super.characters(ch, start, length);
        if(vao_item==true)
            chuoi_tam=new String(ch,start,length);


    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        // TODO Auto-generated method stub
        super.startElement(uri, localName, qName, attributes);
        if(qName.equalsIgnoreCase("item"))
        {
            item_tam=new item2();
            vao_item=true;
        }

    }



    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        // TODO Auto-generated method stub
        super.endElement(uri, localName, qName);
        if(qName.equalsIgnoreCase("item"))
        {
            items.add(item_tam);
        }else if(vao_item==true)
        {
            if(qName.equalsIgnoreCase("title"))
                item_tam.setTitle(chuoi_tam);
            if(qName.equalsIgnoreCase("description"))
                item_tam.setDescription(chuoi_tam);
            if(qName.equalsIgnoreCase("link"))
                item_tam.setLink(chuoi_tam);
            if(qName.equalsIgnoreCase("pubdate"))
                item_tam.setPubdate(chuoi_tam);
        }

    }




}
