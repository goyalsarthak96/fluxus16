package com.example.sarthak.fluxus2k16;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.*;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;



public class acc_frag extends Fragment{


    //subcategories m;

    public static final String ARG_PAGE = "ARG_PAGE";
    public static final String INDEX = "INDEX";
    int mPage;


    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;
    public static final String MyPREFERENCES = "MyPrefs";


    public static acc_frag newInstance(int page) {


        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        //args.putString(category_string,category1);
        acc_frag fragment = new acc_frag();
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

        View rootView;
        if(mPage==2)
        {
            rootView = inflater.inflate(R.layout.acc_register_layout, container, false);
            TextView t1=(TextView) rootView.findViewById(R.id.acc_reg_text1);
            TextView t2=(TextView) rootView.findViewById(R.id.acc_reg_text2);
            TextView t3=(TextView) rootView.findViewById(R.id.acc_reg_text3);
            TextView t4=(TextView) rootView.findViewById(R.id.acc_reg_text4);
            TextView t5=(TextView) rootView.findViewById(R.id.acc_reg_text5);
            TextView t6=(TextView) rootView.findViewById(R.id.link);
            TextView t7=(TextView) rootView.findViewById(R.id.acc_text);

            String s1="\nRegister for Accomodation:";

            String s7="Last Date for Online Registration :\n23:59 hours 3rd Feb, 2016.\n\n" +
                    "Last date for receiving the confirmation letter : \n23:59 hours 3rd Feb, 2016.\n\n" +
                    "Earliest Check in time : \n17:00 hours 3rd Feb, 2016.\n\n" +
                    "Latest Check out time : \n10:00 hours 8th Feb, 2016.\n" +
                    "** dates might change.\n\n\n\n" +
                    "In case of any query contact:\n\n";

            String s2="Swetha Kondubhatla : ";
            String s3="+91-9713867776\n";
            String s4="Navneet Singh : ";
            String s5="+91-9713857775\n\n\n";
            String s6="http://fluxus.in/accommodation.php#/register\n\n\n\n";
            t1.setText(s1);
            t2.setText(s2);
            t3.setText(s3);
            t4.setText(s4);
            t5.setText(s5);
            t6.setText(s6);
            t7.setText(s7);


            t6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent viewIntent =
                            new Intent("android.intent.action.VIEW",
                                    Uri.parse("http://fluxus.in/accommodation.php#/register"));
                    startActivity(viewIntent);
                }
            });

            t5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + "+91-9713857775"));

                    MainActivity.open=1;


                    startActivity(intent);
                }
            });

            t3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + "+91-9713867776"));

                    MainActivity.open=1;
                    startActivity(intent);
                }
            });

        }
        else {
            rootView = inflater.inflate(R.layout.acc_frag, container, false);
            TextView t = (TextView) rootView.findViewById(R.id.accomodation_text);
            String s = "";
            if (mPage == 0)
                s = "\n\n1. Everyone willing to attend Fluxus 2016 must register and get a FX-ID.\n\n" +
                        "2. Everyone willing to avail accommodation for Fluxus 2016 must register here.\n\n" +
                        "3. When you arrive at IIT Indore hostel, Silver Springs, you have to come to registration desk along with your college ID card and receipt of online advance payment.\n\n" +
                        "4. Accommodation would be strictly on shared basis.\n\n" +
                        "5. As a part of accommodation, Hospitality Team will make arrangements for mattress, pillow, hot water, some refreshments and transportation*. Participants need to bring bed sheets, pillow cover, blanket etc. as per their own requirement.\n\n" +
                        "6. All the people availing accommodation shall be responsible for the facilities provided to them. In event of any loss, all the payments shall be bearable by the tenants themselves and shall be paid directly to the hospitality team, failing which, action may be taken.\n\n" +
                        "7. All participants, whether coming alone or in a group, need to register individually. No group registrations for accommodation will be entertained.\n\n" +
                        "8. People who wish to stay together need to send a mail beforehand at hospitality.fluxus@gmail.com . However, the same is subject to availability.\n\n" +
                        "9. Fluxus hospitality team is not responsible for the dining facility during the stay. Though food stalls will be available at the venue of Fluxus.\n\n" +
                        "10. Students can avail accommodation facilities from 4th February to 7th February.\n\n";
            else if (mPage == 1)
                s =
                        "\n\n1 day** + 1 night**\t\t400+100*\n" +
                                "2 days** + 2 nights**\t\t400+300+100*\n" +
                                "3 days** + 3 nights**\t\t400+300+300+100*\n" +
                                "3 days** + 4 nights**\t\t400+300+300+100*\n\n\n" +
                                "*100 is the security deposit that will be refundable.\n" +
                                "**number of days and nights is subject to check-in and check-out time.\n" +
                                "## Money will be refunded as per the discounts for respective events.";
            else if (mPage == 2)
                s = "\nRegister for Accomodation:\n" +
                        "http://fluxus.in/accommodation.php#/register\n\n\n\n" +
                        "Last Date for Online Registration :\n23:59 hours 3rd Feb, 2016.\n\n" +
                        "Last date for receiving the confirmation letter : \n23:59 hours 3rd Feb, 2016.\n\n" +
                        "Earliest Check in time : \n17:00 hours 3rd Feb, 2016.\n\n" +
                        "Latest Check out time : \n10:00 hours 8th Feb, 2016.\n" +
                        "** dates might change.\n\n\n\n" +
                        "In case of any query contact:\n\n" +
                        "Swetha Kondubhatla : +91-9713867776\n" +
                        "Navneet Singh : +91-9713857775\n\n\n";


            t.setText(s);
        }





        return rootView;
    }








}
