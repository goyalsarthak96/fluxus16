package com.example.sarthak.fluxus2k16;

import android.content.Context;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;



/*
 * Created by Sarthak on 1/5/2016.
 */
public class schedule_list_adapter extends ArrayAdapter<String> {

    Context context1;

    //String[] array;
    schedule_list_adapter(Context context, ArrayList<String> contents)
    {
        super(context,R.layout.schedule_frag_layout,contents);
        context1=context;
        //array=contents;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final schedule_viewholder vholder;
        if(convertView==null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.schedule_row, parent, false);
            convertView.setBackgroundColor(Color.TRANSPARENT);

            vholder=new schedule_viewholder();

            vholder.t1 = (TextView) convertView.findViewById(R.id.event_name);
            vholder.t2 = (TextView) convertView.findViewById(R.id.event_type);
            vholder.t3 = (TextView) convertView.findViewById(R.id.event_timing);
            convertView.setTag(vholder);
        }
        else
        {
            vholder=(schedule_viewholder)convertView.getTag();
        }
        String event_info = getItem(position);
        int i,j=0,start=0;
        for(i=0;i<event_info.length();i++)
        {
            if(event_info.charAt(i)=='^')
            {
                switch (j)
                {
                    case 0:vholder.t3.setText(event_info.substring(start, i));
                        break;
                    case 1:vholder.t1.setText(event_info.substring(start, i));

                        vholder.t2.setText(event_info.substring(i + 1));
                        break;
                }
                start=i+1;
                j++;
            }
        }




        /*convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });*/
            return convertView;


    }


    public void change_list(int no,ArrayList<String> list,Context context)
    {

        //for(int i=0;i<array.length;i++)
        notifyDataSetChanged();
    }

    /*@Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }*/
}
