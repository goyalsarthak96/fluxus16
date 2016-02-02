package com.example.sarthak.fluxus2k16;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.*;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class reach_campus_pagerfrag extends Fragment{


    //subcategories m;

    public static final String ARG_PAGE = "ARG_PAGE";
    public static final String INDEX = "INDEX";
    int mPage,mIndex;
    View vi;
    static Context context;

    int[][] events_no={ {4,4,3,2,6,6},
            {4,5,6},
            {7},
            {4},
            {7,3},
            {4},
            {2}
    };

    public static reach_campus_pagerfrag newInstance(int page,Context context1) {


        context=context1;
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        //args.putString(category_string,category1);
        reach_campus_pagerfrag fragment = new reach_campus_pagerfrag();
        fragment.setArguments(args);

        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        mPage = getArguments().getInt(ARG_PAGE);
        //category=getArguments().getString(category_string);

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View rootView= inflater.inflate(R.layout.reach_campus_pagerfrag, container, false);
        TextView t1=(TextView)rootView.findViewById(R.id.reach_text1);
        TextView t2=(TextView)rootView.findViewById(R.id.reach_text2);

        // Instance of ImageAdapter Class
        if(mPage==0)
        {
            t1.setText("Devi Ahilyabai Holkar Airport (IDR) is a prominent airport in the Madhya Pradesh state of " +
                            "India and is about 8 km from the Indore city. This is one of the best in India " +
                            "and offers good connectivity from major cities of India like New Delhi, Mumbai, " +
                            "Bangalore, Ahmedabad, Hyderabad, Pune, Kolkata, Jabalpur, Bhopal, Nagpur, and Raipur. " +
                            "International travelers can get connecting flights to Indore from Delhi (800 km) or Mumbai (655 km) airport."+
                    "There are at least 5 airlines operating in Indore: Air India, Jet Airways, SpiceJet, Jet Lite and Indigo.");

            t2.setVisibility(View.INVISIBLE);
        }
        else if(mPage==1)
        {
            t1.setText("Indore Junction Railway Station (INDB) is an important railway station in Western railway zone. It is well connected to major Indian cities like Mumbai, Pune, Nagpur, Delhi, Jaipur, Agra, Ahmedabad, Vadodara, Howrah, Bhopal, Ujjain, Gwalior, Bhind, Jabalpur, Bilaspur, Khandwa, Lucknow, Varanasi, Patna, Ambala Ct, Jammu, Dehradun and Trivandrum.");
            t2.setText("Visit IRCTC to book your tickets.");
            t2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.irctc.co.in/eticketing/loginHome.jsf"));
                    startActivity(intent);
                }
            });
        }
        else
        {
            t1.setText("Indore is well connected by state road transport public bus services. The national highway NH3 (Bombay-Agra Road) and NH59 (Indore-Ahmedabad Road) passes through Indore and there are daily bus services from Indore to Mumbai, Jaipur, Gwalior, Bhopal, Pune, Ahmedabad, Surat etc. Regular buses, Super fast and Deluxe A/C buses are also available in these routes. Some of the bus services are Royal Travels, Hans and City Link Travels.");
            t2.setText("Visit IIT Indore Location Page to know more about reaching IIT Indore");
            t2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.iiti.ac.in/Institute/How_to_find_us/by_road_location.htm"));
                    startActivity(intent);
                }
            });
        }







        return rootView;
    }







}
