package com.example.sarthak.fluxus2k16;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Sarthak on 1/30/2016.
 */
public class contact_us extends Fragment {


    View layout1,layout2,layout3,layout4,layout5;
    ImageView im1,im2,im3,im4,im5,im6,im7,im8,im9,im10;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.contact_us,container,false);

        layout1=view.findViewById(R.id.contact_lay1);
        layout2=view.findViewById(R.id.contact_lay2);
        layout3=view.findViewById(R.id.contact_lay3);
        layout4=view.findViewById(R.id.contact_lay4);
        layout5=view.findViewById(R.id.contact_lay5);

        im1=(ImageView)layout1.findViewById(R.id.contact_im1);
        im2=(ImageView)layout1.findViewById(R.id.contact_im2);
        im3=(ImageView)layout1.findViewById(R.id.contact_im3);
        t1=(TextView)layout1.findViewById(R.id.info3);
        t2=(TextView)layout1.findViewById(R.id.info3_1);
        t3=(TextView)layout1.findViewById(R.id.info3_2);


        im4=(ImageView)layout2.findViewById(R.id.contact_im4);
        im5=(ImageView)layout2.findViewById(R.id.contact_im5);
        t4=(TextView)layout2.findViewById(R.id.info3);
        t5=(TextView)layout2.findViewById(R.id.info3_1);


        im6=(ImageView)layout3.findViewById(R.id.contact_im);
        im7=(ImageView)layout3.findViewById(R.id.contact_im1);
        t6=(TextView)layout3.findViewById(R.id.info3);
        t7=(TextView)layout3.findViewById(R.id.info3_1);



        im8=(ImageView)layout4.findViewById(R.id.contact_im);
        t8=(TextView)layout4.findViewById(R.id.info3);



        im9=(ImageView)layout5.findViewById(R.id.contact_im);
        im10=(ImageView)layout5.findViewById(R.id.contact_im1);
        t9=(TextView)layout5.findViewById(R.id.info3);
        t10=(TextView)layout5.findViewById(R.id.info3_1);



        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_click("+91-9685546180");
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_click("+91-9753672257");
            }
        });


        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_click("+91-8818881795");
            }
        });



        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_click("+91-9009705612");
            }
        });


        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_click("+91-9685650569");
            }
        });


        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_click("+91-8827623867");
            }
        });


        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_click("+91-8349462210");
            }
        });


        t8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_click("+91-8109992422");
            }
        });


        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_click("+91-9713867776");
            }
        });


        t10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_click("+91-9713867775");
            }
        });

        Context context=getActivity().getBaseContext();
        Glide.with(context).load(R.drawable.apurv).into(im1);
        Glide.with(context).load(R.drawable.yash).into(im2);
        Glide.with(context).load(R.drawable.mudit).into(im3);
        Glide.with(context).load(R.drawable.sudhakar).into(im4);
        Glide.with(context).load(R.drawable.pratik).into(im5);
        Glide.with(context).load(R.drawable.parul).into(im6);
        Glide.with(context).load(R.drawable.dhruv).into(im7);
        Glide.with(context).load(R.drawable.akarsh).into(im8);
        Glide.with(context).load(R.drawable.swetha).into(im9);
        Glide.with(context).load(R.drawable.navneet).into(im10);



        return view;
    }

    public void text_click(String phone_no)
    {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phone_no));

        MainActivity.open=1;


        startActivity(intent);
    }
}
