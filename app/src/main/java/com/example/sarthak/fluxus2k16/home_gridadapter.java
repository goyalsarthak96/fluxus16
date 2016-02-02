package com.example.sarthak.fluxus2k16;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.lang.ref.WeakReference;


public class home_gridadapter extends BaseAdapter {


    private Context mContext;
    int mPosition;


    int event_im_list[]={R.drawable.sunidhi2,R.drawable.shaan,R.drawable.tara,R.drawable.terrence,R.drawable.divyakumar,R.drawable.campusprincess,};



    String event_list[]= {"Sunidhi Chauhan","EDM Night- DJ Shaan","EDM Night- Miss Tara","Terence Lewis","Divya Kumar","Campus Princess"};
    String dates[]={"7 Feb 2016","5 Feb 2016","5 Feb 2016","6 Feb 2016","6 Feb 2016","6 Feb 2016"};




    int count=6;








    public home_gridadapter(Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {




        mPosition=position;




        final LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.home_grid_element, null);

        final ImageView img=(ImageView)convertView.findViewById(R.id.home_im);
        final TextView eve_name_textview=(TextView)convertView.findViewById(R.id.home_Text);
        final TextView eve_name_textview1=(TextView)convertView.findViewById(R.id.home_Text1);
        eve_name_textview.getBackground().setAlpha(124);
        eve_name_textview1.getBackground().setAlpha(124);

        final String name=event_list[position];
        final String date=dates[position];
        final int im_id=event_im_list[position];
        eve_name_textview.setText(name);
        eve_name_textview1.setText(date);

        /*img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(mContext,event_info.class);
                intent.putExtra("eve_name", name);
                switch (category_no)
                {
                    case 0:intent.putExtra("table_name","culturals");
                        break;
                    case 1:intent.putExtra("table_name","technicals");
                        break;
                    case 2:intent.putExtra("table_name","informals");
                        break;
                    case 3:intent.putExtra("table_name","quiz");
                        break;
                    case 4:intent.putExtra("table_name","lit");
                        break;
                }

                intent.putExtra("image_id", im_id);
                //intent.putExtra("from","category");
                mContext.startActivity(intent);

            }
        });*/






        Glide.with(mContext).load(event_im_list[position]).into(img);


        convertView.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT,500));

        return convertView;
    }



}



