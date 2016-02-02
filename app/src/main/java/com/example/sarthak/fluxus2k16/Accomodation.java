package com.example.sarthak.fluxus2k16;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TableLayout;
import android.widget.TextView;

public class Accomodation extends Fragment {

    public ViewPager viewPager;
    public PagerAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_accomodation,container,false);
        TabLayout tabLayout=(TabLayout)view.findViewById(R.id.acc_tablayout);
        viewPager=(ViewPager)view.findViewById(R.id.acc_viewpager);
        adapter=new acc_pageradapter(getActivity().getBaseContext());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);




        return view;
    }




}
