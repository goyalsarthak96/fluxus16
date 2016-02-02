package com.example.sarthak.fluxus2k16;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.view.*;
import android.widget.TextView;



import java.util.ArrayList;



public class schedule_frag extends Fragment{


    public static final String ARG_PAGE = "ARG_PAGE";
    public static final String category_string = "CATEGORY";
    static String category="All";
    static Context mContext;

    String[] event_detail={ "event1^desc1^hh:mm-hh:mm",
                                "event2^desc2^hh:mm-hh:mm",
                                "event3^desc3^hh:mm-hh:mm",
                                "event4^desc4^hh:mm-hh:mm",
                                "event5^desc5^hh:mm-hh:mm",
                                "event6^desc6^hh:mm-hh:mm"
                                };
    String[] event_type={  "Technical","Cultural","Technical","Informal","Cultural","Informal"};
    //String[] valid_event_list = new String[event_detail.length];

    ArrayList<String> valid_event_list=new ArrayList<>();
    int mPage;
    //private List<String> mItems = new ArrayList<String>();

    schedule_list_adapter adapter;

    clicklistener activitycommander;
    public interface clicklistener
    {

        void return_adapter(int page_no,schedule_list_adapter adapter,ArrayList<String> list1,ListView id);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try
        {
            activitycommander=(clicklistener)activity;
        }
        catch (Exception e){

        }
    }

    public static schedule_frag newInstance(int page,String category1,Context context) {

        mContext = context;
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        //args.putString(category_string,category1);
        schedule_frag fragment = new schedule_frag();
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
        View view = inflater.inflate(R.layout.schedule_frag_layout, container, false);

        //category=getArguments().getString(category_string);


        //valid_event_list=event_detail;

        valid_event_list.clear();

           Database db=new Database(mContext);
        if(mPage==0)
        valid_event_list=db.getSchedule(category,"day1");
        else if(mPage==1)
            valid_event_list=db.getSchedule(category,"day2");
        else
        valid_event_list=db.getSchedule(category,"day3");




        /*for(int i=0;i<event_detail.length;i++)
        {
            if(category=="All")
            {
                valid_event_list.add(event_detail[i]);
            }
            else
            {
                if(category.equals(event_type[i]))
                {
                    valid_event_list.add(event_detail[i]);
                }
            }
        }*/

            //TextView textView = (TextView) view.findViewById(R.id.textView);
            //textView.setText("Fragment #" + mPage);
        final ListView listView=(ListView) view.findViewById(R.id.event_list);



        adapter=new schedule_list_adapter(getContext(),valid_event_list);

        listView.setAdapter(adapter);

        activitycommander.return_adapter(mPage, adapter, valid_event_list,listView);



        return view;
    }



    public void update_category(String category1)
    {
        category=category1;
    }


    public void data_change(int no,String category_sel,Context context,schedule_list_adapter adapter1,ArrayList<String> list,ListView listView) {

        ArrayList<String> data;
        if (adapter1 != null) {
            list.clear();
            Database db=new Database(context);
            if(no==0)
                data=db.getSchedule(category,"day1");
            else if(no==1)
                data=db.getSchedule(category,"day2");
            else
                data=db.getSchedule(category,"day3");

            for(int i=0;i<data.size();i++)
            {
                list.add(data.get(i));
            }

            //adapter1=new schedule_list_adapter(mContext,list);
            //listView.setAdapter(adapter1);
            adapter1.change_list(no,list,mContext);
            }
        else {
        }

        }





}
