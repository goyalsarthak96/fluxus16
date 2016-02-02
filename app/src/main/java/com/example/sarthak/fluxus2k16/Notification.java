package com.example.sarthak.fluxus2k16;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Notification extends Fragment {

    ArrayList<String> notifications=new ArrayList<>();
    ArrayList<String> notifications1=new ArrayList<>();
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        Database db=new Database(getBaseContext());
        notifications=db.getAllNotifications();

        ListView notif_list=(ListView)findViewById(R.id.notification_list);
        ListAdapter adapter=new notif_listadap(getBaseContext(),notifications);
        notif_list.setAdapter(adapter);
    }*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_notification,container,false);
        Database db=new Database(getActivity().getBaseContext());
        notifications=db.getAllNotifications();

        int j=notifications.size();
        for(int i=0;i<j;i++)
        {
            notifications1.add(i,notifications.get(j-i-1));
        }

        ListView notif_list=(ListView)view.findViewById(R.id.notification_list);
        ListAdapter adapter=new notif_listadap(getActivity().getBaseContext(),notifications1);
        notif_list.setAdapter(adapter);
        return view;
    }
}
