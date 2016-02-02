package com.example.sarthak.fluxus2k16;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sarthak on 1/21/2016.
 */
public class notif_listadap extends ArrayAdapter<String> {


    public notif_listadap(Context context,ArrayList<String> contents) {
        super(context,R.layout.schedule_frag_layout,contents);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final notif_viewholder vholder;
        if(convertView==null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.notif_row, parent, false);
            convertView.setBackgroundColor(Color.TRANSPARENT);

            vholder=new notif_viewholder();

            vholder.title = (TextView) convertView.findViewById(R.id.title);
            vholder.title.setTextColor(Color.WHITE);
            vholder.date = (TextView) convertView.findViewById(R.id.date);
            vholder.date.setTextColor(Color.WHITE);
            vholder.msg = (TextView) convertView.findViewById(R.id.msg);
            vholder.msg.setTextColor(Color.WHITE);
            convertView.setTag(vholder);
        }
        else
        {
            vholder=(notif_viewholder)convertView.getTag();
        }

        String notif=getItem(position);
        String temp="";
        int count=0;
        for(int i=0;i<notif.length();i++)
        {
            if(notif.charAt(i)=='^')
            {
                if(count==0) {
                    count=i;
                    vholder.title.setText(notif.substring(0, i));
                }else
                {
                    vholder.msg.setText(notif.substring(count+1,i));
                    vholder.date.setText(notif.substring(i+1));
                }
            }

        }
     return convertView;
    }
}
